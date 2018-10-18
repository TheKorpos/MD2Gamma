package hu.bme.mit.magicdraw2gamma.plugin.ui.action;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.options.ProjectOptions;
import com.nomagic.magicdraw.properties.Property;

import hu.bme.mit.magicdraw2gamma.plugin.options.GammaProjectOptionsConfigurator;

public class UppaalVerificationAction extends MDAction {
	
	public UppaalVerificationAction(String id, String name) {
		super(id, name, null, null);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String queryString = JOptionPane.showInputDialog(Application.getInstance().getMainFrame(), "Upaal Query");
		
		JFileChooser filechooser = new JFileChooser();
		filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		Property prop = Application.getInstance().getProject().getOptions().getProperty(
				ProjectOptions.PROJECT_GENERAL_PROPERTIES,
				GammaProjectOptionsConfigurator.GAMMA_WORK_DIR_ID
				);
		
		String workdir = prop.getValueStringRepresentation();
		
		if (!"".equals(prop.getValueStringRepresentation())) {
			filechooser.setCurrentDirectory(new File(prop.getValueStringRepresentation()));
		}
		
		
		int state = filechooser.showOpenDialog(Application.getInstance().getMainFrame());
		
		if (state == JFileChooser.APPROVE_OPTION) {
			try {
				FileWriter fw = new FileWriter(new File(workdir + "\\temp.q"));
				fw.write(queryString);
				fw.close();
				
				StringBuilder command = new StringBuilder();
				// verifyta -t1 TestOneComponent.xml asd.q 
				command.append("verifyta " + getParameters() + " \"" + filechooser.getSelectedFile().getAbsolutePath() + "\" \"" + workdir + "\\temp.q" + "\"");
				// Executing the command
				
				Process process = Runtime.getRuntime().exec(command.toString());
				InputStream ips = process.getErrorStream();
				Scanner scanner = new Scanner(ips);
				
				scanner.forEachRemaining(System.out::println);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private String getParameters() {
		return getSearchOrder("Breadth First") + " " + getDiagnosticTrace("Some");
	}
	
	private String getSearchOrder(String type) {
		switch (type) {
		case "Breadth First":
			// BFS
			return "-o 0";
		case "Depth First":
			// DFS
			return "-o 1";
		default: //"Random Depth First":
			// Random DFS
			return "-o 2";
		}
	}
	
	private String getDiagnosticTrace(String type) {
		switch (type) {
		case "Some":
			// Some trace
			return "-t0";
		case "Shortest":
			// Shortest trace
			return "-t1";
		default:// "Fastest":
			// Fastest trace
			return "-t2";
		}
	}
}
