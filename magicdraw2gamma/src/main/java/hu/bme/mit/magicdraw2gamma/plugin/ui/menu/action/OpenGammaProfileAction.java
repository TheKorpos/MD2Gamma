package hu.bme.mit.magicdraw2gamma.plugin.ui.menu.action;

import java.awt.event.ActionEvent;
import java.io.File;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.core.project.ProjectDescriptor;
import com.nomagic.magicdraw.core.project.ProjectDescriptorsFactory;

import hu.bme.mit.magicdraw2gamma.plugin.profilehelper.GammaProfile;
import hu.bme.mit.magicdraw2gamma.plugin.transformation.eventdriven.Test;


public class OpenGammaProfileAction extends MDAction {

	private static final long serialVersionUID = 4672046002106522572L;
	
	private ProjectDescriptor descriptor;
	

	public OpenGammaProfileAction(String id, String name) {
		super(id, name, null, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent evnt) {
		
		Project project = Application.getInstance().getProject();
		
		String profileDir = Application.environment().getProfilesDirectory();
		File file = new File(profileDir + File.separator + "GammaProfile.mdzip");
		
		descriptor = ProjectDescriptorsFactory.createProjectDescriptor(file.toURI());
		
		Application.getInstance().getProjectsManager().useModule(project, descriptor);
		
		GammaProfile.setLoaded(true);
		
		ViatraQueryEngine engine = ViatraQueryAdapter.getOrCreateAdapter(project).getEngine();
		
		//Test test = new Test(engine, new ResourceSetImpl());
		
	}

}
