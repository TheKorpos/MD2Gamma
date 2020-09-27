package hu.bme.mit.md2g.ui.browser.action;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.util.StringInputStream;

import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.uml2.ext.jmi.helpers.ModelHelper;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;


import hu.bme.mit.gamma.uppaal.serializer.UppaalModelSerializer;
import hu.bme.mit.md2g.util.profile.Gamma;
import hu.bme.mit.md2g.util.profile.Gamma.GammaWorkspace;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import uppaal.NTA;

public class SerializeUppaalModelAction extends NMAction {
	
	private final Package workspace;


	public SerializeUppaalModelAction(Package workspace) {
		super("GAMMA_SAVE_UPPAAL", "Persist UPPAAL XML - Required for verification", null, null);
		this.workspace = workspace;
	}
	
	@Override
	public boolean isEnabled() {
		return GammaWorkspace.getUppaalModel(workspace) != null;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Class uppaalModel = (Class) GammaWorkspace.getUppaalModel(workspace);
		Class target = (Class) GammaWorkspace.getTarget(workspace);
		String workspaceUri = GammaWorkspace.getWorkspaceUri(workspace);
		
		Project project = Project.getProject(workspace);
		
		ResourceSet rs = new ResourceSetImpl();
		
		try {
			Resource r = loadModel(rs, workspaceUri, uppaalModel);
			
			EObject eObject = r.getContents().get(0);
			
			if (eObject instanceof NTA) {
				NTA nta = (NTA) eObject;
				
				SessionManager.getInstance().executeInsideSession(project, "Exporting UPPAAL XML", () -> {
					Class uppaalXML = project.getElementsFactory().createClassInstance();
					uppaalXML.setOwner(workspace);
					GammaWorkspace.setUppaalXML(workspace, uppaalXML);
					
					StereotypesHelper.addStereotype(uppaalXML, Gamma.getInstance(project).getGammaWorkspaceFile());
					
					uppaalXML.setName(workspaceUri + File.separator + target.getName() + ".xml");
					
					UppaalModelSerializer.saveToXML(nta, workspaceUri, target.getName() + ".xml");
				});
				
			}
			
		} catch (IOException e) {
			Application.getInstance().getGUILog().log("Could not load resource");
		}
		
	}
	
	private Resource loadModel(ResourceSet resourceSet, String workspaceUri, Class model) throws IOException {
		String gammaModel = ModelHelper.getComment(model);
		
		Resource resource = resourceSet.createResource(URI.createFileURI(workspaceUri + File.separator + model.getName()));

		resource.load(new StringInputStream(gammaModel), Collections.emptyMap());
		
		return resource;
	}
}
