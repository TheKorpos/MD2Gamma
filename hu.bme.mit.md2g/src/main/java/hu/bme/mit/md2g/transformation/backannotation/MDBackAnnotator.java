package hu.bme.mit.md2g.transformation.backannotation;


import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.actions.mdbasicactions.SendSignalAction;
import com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.ActivityFinalNode;
import com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.ControlFlow;
import com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.InitialNode;
import com.nomagic.uml2.ext.magicdraw.activities.mdfundamentalactivities.Activity;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Type;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Signal;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port;
import com.nomagic.uml2.impl.ElementsFactory;

import hu.bme.mit.gamma.statechart.composite.SynchronousComponentInstance;
import hu.bme.mit.gamma.statechart.interface_.Component;
import hu.bme.mit.gamma.statechart.interface_.Event;
import hu.bme.mit.gamma.statechart.statechart.State;
import hu.bme.mit.gamma.trace.model.Act;
import hu.bme.mit.gamma.trace.model.ComponentSchedule;
import hu.bme.mit.gamma.trace.model.ExecutionTrace;
import hu.bme.mit.gamma.trace.model.InstanceState;
import hu.bme.mit.gamma.trace.model.InstanceStateConfiguration;
import hu.bme.mit.gamma.trace.model.RaiseEventAct;
import hu.bme.mit.gamma.trace.model.Step;
import hu.bme.mit.gamma.trace.model.TimeElapse;
import hu.bme.mit.md2g.transformation.TraceModelManager;
import hu.bme.mit.md2g.transformation.backannotation.objects.ActObject;
import hu.bme.mit.md2g.transformation.backannotation.objects.InstanceStateConstant;
import hu.bme.mit.md2g.transformation.backannotation.objects.RaiseEventActObject;
import hu.bme.mit.md2g.transformation.backannotation.objects.ScheduleAct;
import hu.bme.mit.md2g.transformation.backannotation.objects.StepObject;
import hu.bme.mit.md2g.transformation.backannotation.objects.TimeElapseActObject;
import hu.bme.mit.md2g.util.profile.Gamma;
import hu.bme.mit.md2g.util.profile.SysML;

public class MDBackAnnotator {
	
	private ExecutionTrace executionTrace;
	private Package workspace;
	private Project project;

	public MDBackAnnotator(Package mdPackage, ExecutionTrace gammaTrace) {
		this.executionTrace = gammaTrace;
		this.workspace = mdPackage;
		project = Project.getProject(workspace);
	}
	
	public void executeInSession(TraceModelManager manager) {
		
		SessionManager.getInstance().executeInsideSession(project, "Creating trace model", () -> {
			
			Package tracePackage = project.getElementsFactory().createPackageInstance();
			tracePackage.setOwner(getOrCreateTracesPackage());
			tracePackage.setName(executionTrace.getName());
			
			Class backAnnot = project.getElementsFactory().createClassInstance();
			StereotypesHelper.addStereotype(backAnnot, Gamma.getInstance(project).getExecutionTrace());
			backAnnot.setOwner(tracePackage);
			backAnnot.setName(executionTrace.getName());
			
			Component component = executionTrace.getComponent();
			
			Class tracedCompositeComponent = manager.g2md(component).stream().filter(Class.class::isInstance).map(Class.class::cast).findAny().orElseThrow(()  -> new IllegalStateException("Component trace is missing."));
			
			Gamma.ExecutionTrace.setComponent(backAnnot, tracedCompositeComponent);
			
			int stepCounter = 0;
			
			for (Step step: executionTrace.getSteps()) {
				
				StepObject stepObject = new StepObject(project, backAnnot, stepCounter);
				
				int actCounter = 0;
				
				for (Act action: step.getActions()) {
					
					
					if (action instanceof ComponentSchedule) {
						ScheduleAct obj = new ScheduleAct(project, stepCounter + "." + actCounter++ + ". schedule");
						stepObject.getActs().add(obj);
					}
					else
					if (action instanceof RaiseEventAct) {
						RaiseEventAct rea = (RaiseEventAct) action;
						handleRaiseAction(manager, stepObject.getActs(), stepCounter + "." + actCounter++, rea);
					}
					else
					if (action instanceof TimeElapse) {
						
						TimeElapse timeElapse = (TimeElapse) action;
						BigInteger elapsedTime = timeElapse.getElapsedTime();
						
						TimeElapseActObject timeout = new TimeElapseActObject(project, stepCounter + "." + actCounter++ + ". after " + elapsedTime.toString(), elapsedTime);
						stepObject.getActs().add(timeout);
					}
				}
				
				for (InstanceState instanceState : step.getInstanceStates()) {
					
					if (instanceState instanceof InstanceStateConfiguration) {
						
						InstanceStateConfiguration stateConfig = (InstanceStateConfiguration) instanceState;
						State state = stateConfig.getState();
						SynchronousComponentInstance instance = stateConfig.getInstance();
						
						NamedElement tracedStates = manager.g2md(state).stream().findFirst().orElseThrow(() -> new IllegalStateException("No trace found for state"));
						NamedElement tracedParts = manager.g2md(instance).stream().findFirst().orElseThrow(() -> new IllegalStateException("No trace found for component"));
						
						InstanceStateConstant obj = new InstanceStateConstant(project, (Property) tracedParts, 
								(com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State) tracedStates);
						
						stepObject.getInstanceStates().add(obj);
					}
				}
				
				int raiseCounter = 0;
				
				for (RaiseEventAct raise: step.getOutEvents()) {
					handleRaiseAction(manager, stepObject.getOut(), stepCounter + "." + raiseCounter++, raise);
				}
				
				Class stepClass = stepObject.createObject();
				stepClass.setOwner(backAnnot);
				
				stepCounter++;
			}
		});
	}

	private void handleRaiseAction(TraceModelManager manager, List<ActObject> acts, String actCounter, RaiseEventAct rea) {
		hu.bme.mit.gamma.statechart.interface_.Port port = rea.getPort();
		Event event = rea.getEvent();
		
		Port tracedPort = manager.g2md(port).stream().findFirst()
				.filter(Port.class::isInstance).map(Port.class::cast).orElseThrow(() -> new IllegalStateException("No trace found for port"));
		
		Type type = tracedPort.getType();
		
		if (SysML.isInterfaceBlock(type)) {
			//probably should use the tarce instead of finding it by name
			Signal signal = type.getOwnedElement().stream().filter(SysML::isFlowProperty)
					.map(Property.class::cast)
					.map(Property::getType)
					.filter(Objects::nonNull)
					.filter(Signal.class::isInstance)
					.map(Signal.class::cast)
					.filter(sig -> sig.getName().equals(event.getName()))
					.findFirst()
					.orElseThrow(() -> new IllegalStateException("No trace found for event"));
			
			String name = actCounter + ". raise " + port.getName() +  "."  + signal.getName();
			
			Activity activity = createRaiseEventAction(signal, tracedPort);
			activity.setName(name);
			RaiseEventActObject obj = new RaiseEventActObject(project, name, activity);
			acts.add((ActObject)obj);
		}
	}
	
	private Package getOrCreateTracesPackage() {
		
		return workspace.getOwnedElement().stream().filter(Package.class::isInstance).map(Package.class::cast)
				.filter(it -> "2_Traces".equals(it.getName())).findFirst().orElseGet(() -> {
					Package newPackage = project.getElementsFactory().createPackageInstance();
					newPackage.setName("2_Traces");
					newPackage.setOwner(workspace);
					return newPackage;
				});
	}
	
	
	private Activity createRaiseEventAction(Signal signal, Port port) {
		
		ElementsFactory elementsFactory = project.getElementsFactory();
		
		Activity activity = elementsFactory.createActivityInstance();
		SendSignalAction sendSignalAction = elementsFactory.createSendSignalActionInstance();
		InitialNode initialNode = elementsFactory.createInitialNodeInstance();
		ActivityFinalNode finalNode = elementsFactory.createActivityFinalNodeInstance();
		
		sendSignalAction.setSignal(signal);
		sendSignalAction.setOnPort(port);
		
		sendSignalAction.setOwner(activity);
		initialNode.setOwner(activity);
		finalNode.setOwner(activity);
		
		ControlFlow cf1 = elementsFactory.createControlFlowInstance();
		cf1.setOwner(activity);
		cf1.setSource(initialNode);
		cf1.setTarget(sendSignalAction);
		
		ControlFlow cf2 = elementsFactory.createControlFlowInstance();
		cf2.setOwner(activity);
		cf2.setSource(sendSignalAction);
		cf2.setTarget(finalNode);
		
		return activity;
	}
}
