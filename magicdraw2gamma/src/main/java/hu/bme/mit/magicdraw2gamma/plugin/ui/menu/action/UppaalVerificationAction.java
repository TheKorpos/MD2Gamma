package hu.bme.mit.magicdraw2gamma.plugin.ui.menu.action;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.options.ProjectOptions;
import com.nomagic.magicdraw.properties.Property;

import hu.bme.mit.gamma.querygenerator.application.AppMain;
import hu.bme.mit.magicdraw2gamma.plugin.options.GammaProjectOptionsConfigurator;

public class UppaalVerificationAction extends MDAction {
	
	private static final long serialVersionUID = 20181120L;

	public UppaalVerificationAction(String id, String name) {
		super(id, name, null, null);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//String queryString = JOptionPane.showInputDialog(Application.getInstance().getMainFrame(), "Upaal Query");
		
		JFileChooser filechooser = new JFileChooser();
		filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		
		Property prop = Application.getInstance().getProject().getOptions().getProperty(
				ProjectOptions.PROJECT_GENERAL_PROPERTIES,
				GammaProjectOptionsConfigurator.GAMMA_WORK_DIR_ID
				);
		
		String workdir = prop.getValueStringRepresentation();
		
		AppMain gammaVerificationApp = new AppMain();
		
		
		
		if (!"".equals(prop.getValueStringRepresentation())) {
			filechooser.setCurrentDirectory(new File(prop.getValueStringRepresentation()));
		}
		
		
		int state = filechooser.showOpenDialog(Application.getInstance().getMainFrame());
		
		if (state == JFileChooser.APPROVE_OPTION) {
			

		File selectedFile = filechooser.getSelectedFile();
		String gsmPath = selectedFile.getAbsolutePath() + "/" + selectedFile.getName() + ".gsm";
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.getResource(URI.createFileURI(gsmPath), true);
		Resource interfaces = rs.getResource(URI.createFileURI(workdir + "/interfaces.gsm"), true);

		
		gammaVerificationApp.start(rs, new File(gsmPath), false, workdir);			
			
			/*FileWriter fw = new FileWriter(new File(workdir + "\\temp.q"));
			fw.write(queryString);
			fw.close();
			
			StringBuilder command = new StringBuilder();
			// verifyta -t1 TestOneComponent.xml asd.q 
			command.append("verifyta " + getParameters() + " \"" + filechooser.getSelectedFile().getAbsolutePath() + "\" \"" + workdir + "\\temp.q" + "\"");
			// Executing the command
			
			Process process = Runtime.getRuntime().exec(command.toString());
			InputStream ips = process.getErrorStream();
			Scanner scanner = new Scanner(ips);
			
			scanner.forEachRemaining(System.out::println);*/
				
		
		}
		
	}
	
}
