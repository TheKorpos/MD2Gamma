package hu.bme.mit.gamma.querygenerator.application;

import java.io.File;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

// Application class
// This class includes the entry point of the application
public class AppMain  {
	
	public void start(ResourceSet resourceSet, File file, boolean needsBackAnnotation, String projectFolderName) {
		try {
			View frame = new View(resourceSet, file, needsBackAnnotation, projectFolderName);
			frame.setTitle("UPPAAL Query Generator");
			frame.setVisible(true);
			frame.setResizable(false);
		} catch (ViatraQueryException e) {
			e.printStackTrace();
		}
	}

}
