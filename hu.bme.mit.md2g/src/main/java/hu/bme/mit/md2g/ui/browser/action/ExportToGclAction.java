package hu.bme.mit.md2g.ui.browser.action;

import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.StringInputStream;

import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.ui.MainFrame;
import com.nomagic.uml2.ext.jmi.helpers.ModelHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;

import hu.bme.mit.md2g.serialization.StatechartLanguageSerializer;
import hu.bme.mit.md2g.util.OpaqueExpressoinToRawConverter;
import hu.bme.mit.md2g.util.profile.Gamma;

public class ExportToGclAction extends NMAction {

	private static final Logger LOGGER = Logger.getLogger(ExportToGclAction.class);
	
	private Package workspace;
	
	public ExportToGclAction(Package workspace) {
		super("GAMMA_TO_GCL", "Export models as .gcl...", null, null);
		this.workspace = workspace;
	}
	
	@Override
	public boolean isEnabled() {
		return Gamma.GammaWorkspace.getGammaStatechartModel(workspace) != null && Gamma.GammaWorkspace.getGammaInterfaceModel(workspace) != null;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		MainFrame mainFrame = Application.getInstance().getMainFrame();

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Select output directory for models");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		int status = fileChooser.showOpenDialog(mainFrame);
		
		if (status == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			
			String workspaceUri = Gamma.GammaWorkspace.getWorkspaceUri(workspace);
			
			Class gammaStatechartModel = (Class) Gamma.GammaWorkspace.getGammaStatechartModel(workspace);
			Class interfaces = (Class) Gamma.GammaWorkspace.getGammaInterfaceModel(workspace);
			
			String statechartsString = ModelHelper.getComment(gammaStatechartModel);
			String interfaceString = ModelHelper.getComment(interfaces);
			
			ResourceSetImpl resourceSet = new ResourceSetImpl();
			
			String modelnameWithExt = gammaStatechartModel.getName();
			String modelNameWithoutExt = getModelNameWithoutExtension(modelnameWithExt);
			
			String interfaceNameWithExt = interfaces.getName();
			String interfacesNameWithoutExt = getModelNameWithoutExtension(interfaceNameWithExt);
			
			
			Resource gammaModelsResource = resourceSet.createResource(URI.createFileURI(workspaceUri + File.separator + modelnameWithExt));
			Resource gammaInterfacesResource = resourceSet.createResource(URI.createFileURI(workspaceUri + File.separator + interfaceNameWithExt));
			
			try {
				gammaInterfacesResource.load(new StringInputStream(interfaceString), Collections.emptyMap());
				gammaModelsResource.load(new StringInputStream(statechartsString), Collections.emptyMap());
				
				EObject modelPackage = EcoreUtil2.copy(gammaModelsResource.getContents().get(0));
				EObject interfacePackage =  EcoreUtil2.copy(gammaInterfacesResource.getContents().get(0));
				
				Map<URI, EObject> exportMap = new HashMap<>();
				
				exportMap.put(URI.createFileURI(file.getAbsolutePath() + File.separator + interfacesNameWithoutExt + ".gcd"), interfacePackage);
				exportMap.put(URI.createFileURI(file.getAbsolutePath() + File.separator + modelNameWithoutExt + ".gcd"), modelPackage);
				
				StatechartLanguageSerializer.serialize(exportMap);
				
				OpaqueExpressoinToRawConverter converter = new OpaqueExpressoinToRawConverter();
				
				String convertFile = converter.convertFile(file.getAbsolutePath() + File.separator + modelNameWithoutExt + ".gcd");
				
				try(RandomAccessFile raf = new RandomAccessFile(file.getAbsolutePath() + File.separator + modelNameWithoutExt + "_escaped.gcd", "rw")){
					raf.write(convertFile.getBytes());
				}
				
			} catch (IOException e) {
				Application.getInstance().getGUILog().showError("Failed to export models");
				LOGGER.error(e);
			}
		}
	}

	private String getModelNameWithoutExtension(String modelnameWithExt) {
		return modelnameWithExt.substring(0, modelnameWithExt.lastIndexOf('.'));
	}

}
