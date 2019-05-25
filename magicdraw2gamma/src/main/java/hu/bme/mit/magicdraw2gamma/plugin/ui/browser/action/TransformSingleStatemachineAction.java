package hu.bme.mit.magicdraw2gamma.plugin.ui.browser.action;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.swing.JFileChooser;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.google.inject.Injector;
import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;

import hu.bme.mit.gamma.statechart.language.StatechartLanguageRuntimeModule;
import hu.bme.mit.gamma.statechart.language.StatechartLanguageStandaloneSetup;
import hu.bme.mit.gamma.statechart.language.ui.internal.LanguageActivator;
import hu.bme.mit.gamma.statechart.model.Package;
import hu.bme.mit.gamma.statechart.model.StatechartDefinition;
import hu.bme.mit.magicdraw2gamma.plugin.transformation.StateMachineTransformer;
import hu.bme.mit.magicdraw2gamma.plugin.transformation.serializer.StatechartLanguageSerializer;

public class TransformSingleStatemachineAction extends NMAction {
	
	
	private static final long serialVersionUID = -391974153578591338L;
	
	private Class target;
	
	public TransformSingleStatemachineAction(String id, String name, Class target) {
		super(id, name, 0, null);
		this.target = target;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		StateMachineTransformer transformer = new StateMachineTransformer();
		ArrayList<Class> targetList = new ArrayList<>();
		targetList.add(target);
		
			ResourceSet rs = new ResourceSetImpl();
			
			JFileChooser filechooser = new JFileChooser();
			filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
			
			int state = filechooser.showSaveDialog(Application.getInstance().getMainFrame());
			
			if (state == JFileChooser.APPROVE_OPTION) {
				
				File selectedFile = filechooser.getSelectedFile();
				
				Set<Package> gSet = transformer.transform(targetList, new ResourceSetImpl());
				
				gSet.stream().filter(Package.class::isInstance).map(Package.class::cast).forEach(it -> {
					
					try {
					
					StatechartDefinition statechartDef = it.getComponents().stream().filter(StatechartDefinition.class::isInstance)
																					.map(StatechartDefinition.class::cast)
																					.findFirst()
																					.orElseThrow(() -> new NoSuchElementException());
//					
//					Resource r = rs.createResource(URI.createFileURI(
//						selectedFile.getAbsolutePath() + File.separator + toFilePath(it.getName()) + File.separator + statechartDef + ".gsm"
//					));
//					
//					r.getContents().add(it);
//					r.save(null);
					
					saveModel(it, selectedFile.getAbsolutePath() + File.separator + toFilePath(it.getName()), statechartDef.getName() + ".gcd");
					
					} catch (IOException e) {
						e.printStackTrace();
					} 
				});
			}	
			
	}
	
	private String toFilePath(String s) {
		return s.replace(".", File.separator);
	}
	
	private void saveModel(EObject rootElem, String parentFolder, String fileName) throws IOException {
		if (rootElem instanceof Package) {
			try {
				// Trying to serialize the model
				serialize(rootElem, parentFolder, fileName);
			} catch (Exception e) {
				e.printStackTrace();
				
				new File(parentFolder + File.separator + fileName).delete();
				// Saving like an EMF model
				String newFileName = fileName.substring(0, fileName.lastIndexOf(".")) + ".gsm";
				normalSave(rootElem, parentFolder, newFileName);
			}
		}
		else {
			// It is not a statechart model, regular saving
			normalSave(rootElem, parentFolder, fileName);
		}
	}

	private void normalSave(EObject rootElem, String parentFolder, String fileName) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource saveResource = resourceSet.createResource(URI.createFileURI(URI.decode(parentFolder + File.separator + fileName)));
		saveResource.getContents().add(rootElem);
		saveResource.save(Collections.EMPTY_MAP);
	}
	
	private void serialize(EObject rootElem, String parentFolder, String fileName) throws IOException {
		
		
		Injector injector = new StatechartLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
		StatechartLanguageSerializer serializer = injector.getInstance(StatechartLanguageSerializer.class);
		
		
		
		serializer.save(rootElem, URI.decode(parentFolder + File.separator + fileName));
   }
}
