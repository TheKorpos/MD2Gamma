package hu.bme.mit.md2g.transformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import com.nomagic.magicdraw.sysml.util.MDCustomizationForSysMLProfile;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Classifier;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Type;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdinternalstructures.Connector;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdinternalstructures.ConnectorEnd;

import hu.bme.mit.gamma.statechart.model.Package;
import hu.bme.mit.gamma.statechart.model.Port;
import hu.bme.mit.gamma.statechart.model.RealizationMode;
import hu.bme.mit.gamma.statechart.model.StatechartDefinition;
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory;
import hu.bme.mit.gamma.statechart.model.composite.Component;
import hu.bme.mit.gamma.statechart.model.composite.ComponentInstance;
import hu.bme.mit.gamma.statechart.model.composite.CompositeFactory;
import hu.bme.mit.gamma.statechart.model.composite.InstancePortReference;
import hu.bme.mit.gamma.statechart.model.composite.PortBinding;
import hu.bme.mit.gamma.statechart.model.composite.SimpleChannel;
import hu.bme.mit.gamma.statechart.model.composite.SynchronousComponent;
import hu.bme.mit.gamma.statechart.model.composite.SynchronousComponentInstance;
import hu.bme.mit.gamma.statechart.model.composite.SynchronousCompositeComponent;
import hu.bme.mit.gamma.statechart.model.interface_.InterfaceFactory;
import hu.bme.mit.md2g.transformation.BatchInterfaceTransformation.TransformedElements;
import hu.bme.mit.md2g.util.NameSanitizer;
import hu.bme.mit.md2g.util.SysMLProfile;

public class CompositeTransformation {

	private static final InterfaceFactory interfaceFactory = InterfaceFactory.eINSTANCE;
	public static final StatechartModelFactory statechartFacory = StatechartModelFactory.eINSTANCE;
	public static final CompositeFactory compositeFactory = CompositeFactory.eINSTANCE;
	private final NameSanitizer nameSanitizer = new NameSanitizer();
	
	public List<Package> transform(Class upperMostComponent) {
		
		final Package gPackage = statechartFacory.createPackage();
		gPackage.setName(nameSanitizer.getSenitizedName(upperMostComponent.getOwningPackage()));
		
		final Package interfacePackage = statechartFacory.createPackage();
		interfacePackage.setName("Interfaces");

		final Map<Type, Component> traces = new HashMap<>();
		
		final Stack<Type> unvisited = new Stack<>();
		final Stack<Type> collectedTypes = new Stack<>();
		unvisited.push(upperMostComponent);
		collectedTypes.push(upperMostComponent);
		
		while (!unvisited.empty()) {
			final Classifier unvisitedNode = (Classifier) unvisited.pop();

			for (Property prop : unvisitedNode.getAttribute()) {
				if (MDCustomizationForSysMLProfile.isPartProperty(prop)) {
					final Type propClassifier = prop.getType();
					//avoid circles
					if (!collectedTypes.contains(propClassifier)) {
						collectedTypes.push(propClassifier);
						unvisited.push(propClassifier);
					}
				}
			}
		}
		
		Set<Classifier> portClassifiers = collectedTypes.stream().filter(SysMLProfile::isBlock)
								.map(Class.class::cast)
								.flatMap(c -> c.getOwnedPort().stream())
								.map(p -> (Classifier) p.getType())
								.collect(Collectors.toSet());
		BatchInterfaceTransformation interfaceTransformation = new BatchInterfaceTransformation(portClassifiers);
		
		TransformedElements transformedElements = interfaceTransformation.transform(interfacePackage);
		
		List<Package> packages = new ArrayList<Package>();
		packages.add(interfacePackage);
		Map<com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port, Port> portTraces = new HashMap<>();
		Map<Property, ComponentInstance> instanceTraces = new HashMap<>();
		
		while (!collectedTypes.isEmpty()) {
			Type typeType = collectedTypes.pop();
			if (SysMLProfile.isBlock(typeType)) {
				Class classType = (Class) typeType;
				
				Package p = statechartFacory.createPackage();
				p.setName(nameSanitizer.getSenitizedName(typeType));
				p.getImports().add(interfacePackage);
				packages.add(p);
				
				if (classType.getClassifierBehavior() != null) {
					
					StatechartTransformation transformer = new StatechartTransformation(classType);
					StatechartDefinition statechartDef = transformer.transform(p, transformedElements.getSignalTraces(), transformedElements.getInterfaceTraces());
					p.getComponents().add(statechartDef);
					
					portTraces.putAll(transformer.getPortTraces());
					
					traces.put(classType, statechartDef);
					
				} else {
					SynchronousCompositeComponent compositeDef = compositeFactory.createSynchronousCompositeComponent();
					compositeDef.setName(nameSanitizer.getSenitizedName(classType));
					p.getComponents().add(compositeDef);
					
					
					classType.getOwnedAttribute().stream().filter(MDCustomizationForSysMLProfile::isPartProperty).forEach(prop -> {
						
						Component gType = traces.get(prop.getType());
						Package container = (Package) gType.eContainer();
						
						p.getImports().add(container);
						
						SynchronousComponentInstance instance = compositeFactory.createSynchronousComponentInstance();
						instance.setType((SynchronousComponent) gType);
						instance.setName(nameSanitizer.getSenitizedName(prop));
						instanceTraces.put(prop, instance);
						compositeDef.getComponents().add(instance);
						
						
						p.getComponents().add(compositeDef);
					});
					
					StatechartTransformation.transformPort(classType, compositeDef, transformedElements.getInterfaceTraces(), portTraces);
					
					classType.getOwnedElement().stream()
												.filter(Connector.class::isInstance)
												.map(Connector.class::cast)
												.forEach(conn -> {
													ConnectorEnd end1 = conn.getEnd().get(0);
													ConnectorEnd end2 = conn.getEnd().get(1);
													//bindings
													if (classType.getOwnedPort().contains(end1.getRole())) {
														
														if (end2.getPartWithPort() != null) {
															transformBindingConnector(portTraces, instanceTraces, compositeDef, end1, end2);
														}
														
													} else if (classType.getOwnedPort().contains(end2.getRole())) {
														if (end1.getPartWithPort() != null) {
															transformBindingConnector(portTraces, instanceTraces, compositeDef, end2, end1);
														}
													}
													//connectors
													if (checkPort(end1) && checkPort(end2)) {
														Port port1 = portTraces.get(end1.getRole());
														Port port2 = portTraces.get(end2.getRole());
														ComponentInstance instance1 = instanceTraces.get(end1.getPartWithPort());
														ComponentInstance instance2 = instanceTraces.get(end2.getPartWithPort());
														SimpleChannel chann = compositeFactory.createSimpleChannel();
														
														compositeDef.getChannels().add(chann);
														
														InstancePortReference portRef1 = compositeFactory.createInstancePortReference();
														portRef1.setPort(port1);
														portRef1.setInstance(instance1);
														InstancePortReference portRef2 = compositeFactory.createInstancePortReference();
														portRef2.setPort(port2);
														portRef2.setInstance(instance2);
														
														if (port1.getInterfaceRealization().getRealizationMode() == RealizationMode.REQUIRED) {
															chann.setRequiredPort(portRef1);
															chann.setProvidedPort(portRef2);
														} else {
															chann.setRequiredPort(portRef2);
															chann.setProvidedPort(portRef1);
														}
													}
												});
					
					traces.put(classType, compositeDef);
				}
			}
		}

		return packages;
	}

	private boolean checkPort(ConnectorEnd end1) {
		return end1.getRole() instanceof com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port && end1.getPartWithPort() != null;
	}

	private void transformBindingConnector(
			Map<com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port, Port> portTraces,
			Map<Property, ComponentInstance> instanceTraces, SynchronousCompositeComponent compositeDef,
			ConnectorEnd end1, ConnectorEnd end2) {
		PortBinding portBinding = compositeFactory.createPortBinding();
		portBinding.setCompositeSystemPort(portTraces.get(end1.getRole()));
		
		ComponentInstance instance = instanceTraces.get(end2.getPartWithPort());
		
		InstancePortReference portRef = compositeFactory.createInstancePortReference();
		portRef.setPort(portTraces.get(end2.getRole()));
		portRef.setInstance(instance);
		portBinding.setInstancePortReference(portRef);
		
		compositeDef.getPortBindings().add(portBinding);
	}
	
	
}
