package hu.bme.mit.md2g.ui.browser.action;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.JFileChooser;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Classifier;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port;

import hu.bme.mit.gamma.statechart.interface_.InterfaceModelFactory;
import hu.bme.mit.gamma.statechart.statechart.StatechartModelFactory;
import hu.bme.mit.md2g.serialization.StatechartLanguageSerializer;
import hu.bme.mit.md2g.transformation.BatchInterfaceTransformation;
import hu.bme.mit.md2g.transformation.BatchInterfaceTransformation.TransformedElements;
import hu.bme.mit.md2g.transformation.StatechartTransformation;
import hu.bme.mit.md2g.util.NameSanitizer;
import hu.bme.mit.gamma.statechart.interface_.Package;

public class TransfromSingleStatemachineAction extends NMAction{
	
	private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class target;

	public TransfromSingleStatemachineAction(String id, String name, com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class target) {
		super(id, name, 0, null);
		this.target = target;
	}

	@Override
	public void actionPerformed(ActionEvent evnt) {

		JFileChooser filechooser = new JFileChooser();
		filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		int state = filechooser.showSaveDialog(Application.getInstance().getMainFrame());
		
		if (state == JFileChooser.APPROVE_OPTION) {
			
			NameSanitizer nameSanitizer = new NameSanitizer();
			
			File selectedFile = filechooser.getSelectedFile();
			
			String packageName = nameSanitizer.getSenitizedName(target);
			
			Package gPackage = InterfaceModelFactory.eINSTANCE.createPackage();
			gPackage.setName(packageName);
			
			Package gInterfacePackage = InterfaceModelFactory.eINSTANCE.createPackage();
			gInterfacePackage.setName("Interfaces");
			
			gPackage.getImports().add(gInterfacePackage); 
			
			Set<Classifier> classifiers = target.getOwnedPort().stream().map(Port::getType).map(Classifier.class::cast).collect(Collectors.toSet());
			
			BatchInterfaceTransformation interfaceTrafo = new BatchInterfaceTransformation(classifiers);
			
			TransformedElements traces = interfaceTrafo.transform(gInterfacePackage);
			
			StatechartTransformation transformation = new StatechartTransformation(target);
			transformation.transform(gPackage, traces.getSignalTraces(), traces.getInterfaceTraces());
				
			Map<URI,EObject> rootObjects = new HashMap<URI, EObject>();
			
			rootObjects.put(URI.createURI("Interfaces.gcd")
					.resolve(URI.createFileURI(selectedFile.getAbsolutePath() 
							+ File.separator + packageName + File.separator + packageName)), gInterfacePackage);
			rootObjects.put(URI.createURI(packageName + ".gcd")
					.resolve(URI.createFileURI(selectedFile.getAbsolutePath()
						+ File.separator + packageName + File.separator + packageName)), gPackage);
			
			try {
				StatechartLanguageSerializer.serialize(rootObjects);
			} catch (IOException e) {
				e.printStackTrace();
			}
						
		}	
	}
}
