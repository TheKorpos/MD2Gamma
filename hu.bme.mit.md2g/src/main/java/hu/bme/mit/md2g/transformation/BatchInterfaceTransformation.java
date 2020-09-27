package hu.bme.mit.md2g.transformation;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Classifier;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Signal;

import hu.bme.mit.gamma.statechart.interface_.Event;
import hu.bme.mit.gamma.statechart.interface_.EventDeclaration;
import hu.bme.mit.gamma.statechart.interface_.EventDirection;
import hu.bme.mit.gamma.statechart.interface_.Interface;
import hu.bme.mit.gamma.statechart.interface_.InterfaceModelFactory;
import hu.bme.mit.md2g.util.NameSanitizer;
import hu.bme.mit.md2g.util.profile.SysML;
import hu.bme.mit.md2g.util.profile.SysML.FlowDirectionEnum;
import hu.bme.mit.gamma.statechart.interface_.Package;

public class BatchInterfaceTransformation {

	private Set<Classifier> classifiers;
	private Map<Signal, Event> signalTraces = new HashMap<>();
	private Map<Classifier, Interface> interfaceTraces = new HashMap<>();
	private static final InterfaceModelFactory INTERFACE_FACTORY = InterfaceModelFactory.eINSTANCE;
	private final NameSanitizer nameSanitizer = new NameSanitizer();
	
	public BatchInterfaceTransformation(Set<Classifier> classifiers) {
		this.classifiers = classifiers;
	}

	public TransformedElements transform(Package gPackage) {
		
		for (Classifier classifier : classifiers) {
			
			Interface gInterface= INTERFACE_FACTORY.createInterface();
			gInterface.setName(nameSanitizer.getSenitizedName(classifier));
			interfaceTraces.put(classifier, gInterface);
			gPackage.getInterfaces().add(gInterface);
			
			classifier.getAttribute().stream().filter(SysML::isFlowProperty)
				.filter(prop -> prop.getType() instanceof Signal)
					.map(prop -> new SimpleEntry<Property, FlowDirectionEnum>(prop,
							SysML.FlowProperty.getDirection(prop)))
					.forEach(pairs -> {
						Signal signal = (Signal) pairs.getKey().getType();
						Event event = INTERFACE_FACTORY.createEvent();
						event.setName(nameSanitizer.getSenitizedName(signal));
						EventDeclaration eventDecl = INTERFACE_FACTORY.createEventDeclaration();
						eventDecl.setDirection(getEventDirection(pairs.getValue()));
						eventDecl.setEvent(event);
						gInterface.getEvents().add(eventDecl);
						signalTraces.put(signal, event);
					});
		}
		
		return new TransformedElements(gPackage, signalTraces, interfaceTraces);
	}

	public EventDirection getEventDirection(FlowDirectionEnum flowDirectionEnum) {

		if (SysML.FlowDirectionEnum.IN == flowDirectionEnum) {
			return EventDirection.IN;
		} else if (SysML.FlowDirectionEnum.OUT == flowDirectionEnum) {
			return EventDirection.OUT;
		}
		return EventDirection.INOUT;
	}
	
	
	public class TransformedElements {
		
		private Map<Signal, Event> signalTraces;
		private Map<Classifier, Interface> interfaceTraces;
		private Package interfacePackage;

		public TransformedElements(Package interfacePackage, Map<Signal, Event> signalTraces, Map<Classifier, Interface> interfaceTraces) {
			this.signalTraces = signalTraces;
			this.interfaceTraces = interfaceTraces;
			this.interfacePackage = interfacePackage;
		}
		
		public Package getInterfacePackage() {
			return interfacePackage;
		}
		
		public Map<Classifier, Interface> getInterfaceTraces() {
			return interfaceTraces;
		}
		
		public Map<Signal, Event> getSignalTraces() {
			return signalTraces;
		}
	}
}
