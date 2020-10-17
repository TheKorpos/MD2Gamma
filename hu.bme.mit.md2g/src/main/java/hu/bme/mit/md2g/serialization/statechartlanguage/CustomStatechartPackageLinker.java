package hu.bme.mit.md2g.serialization.statechartlanguage;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.nodemodel.INode;

import com.google.inject.Inject;

import hu.bme.mit.gamma.statechart.interface_.InterfaceModelPackage;

public class CustomStatechartPackageLinker extends DefaultLinkingService{
	
	 @Inject IValueConverterService valueConverterService;
	
	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) {
		
		if (context instanceof hu.bme.mit.gamma.statechart.interface_.Package) {
			if (ref.equals(InterfaceModelPackage.eINSTANCE.getPackage_Imports())) {
				
				String name = valueConverterService.toValue(node.getText(),
	    				getLinkingHelper().getRuleNameFrom(node.getGrammarElement()), node).toString().replaceAll("\\s","");
				
	    		Resource rootResource = context.eResource();
	    		ResourceSet resourceSet = rootResource.getResourceSet();
	    		
	    		for (Resource resource: resourceSet.getResources()) {
	    			if (resource != rootResource) {
	    				EList<EObject> contents = resource.getContents();
	    				
						List<EObject> localMatces = contents.stream()
								.filter(hu.bme.mit.gamma.statechart.interface_.Package.class::isInstance)
								.map(hu.bme.mit.gamma.statechart.interface_.Package.class::cast)
								.filter(p -> p.getName().equals(name)).collect(Collectors.toList());
						
						if (!localMatces.isEmpty()) {
							return localMatces;
						}
	    			}
	    		}
			}
		}
		
		return super.getLinkedObjects(context, ref, node);
	}
}