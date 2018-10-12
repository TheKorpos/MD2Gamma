package hu.bme.mit.magicdraw2gamma.plugin.ui.action;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.options.ProjectOptions;
import com.nomagic.magicdraw.properties.Property;

import hu.bme.mit.magicdraw2gamma.plugin.options.GammaProjectOptionsConfigurator;

public class SetGammaWorkdirAction extends MDAction{
	public SetGammaWorkdirAction(String id, String name) {
		super(id, name, null, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser filechooser = new JFileChooser();
		filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		Property prop = Application.getInstance().getProject().getOptions().getProperty(
				ProjectOptions.PROJECT_GENERAL_PROPERTIES,
				GammaProjectOptionsConfigurator.GAMMA_WORK_DIR_ID
				);
		
		if (!"".equals(prop.getValueStringRepresentation())) {
			filechooser.setCurrentDirectory(new File(prop.getValueStringRepresentation()));
		}
		
		
		int state = filechooser.showOpenDialog(Application.getInstance().getMainFrame());
		
		if (state == JFileChooser.APPROVE_OPTION) {
			File file = filechooser.getSelectedFile();
			prop.setValue(file.getAbsolutePath());
		}
			
	}
}
