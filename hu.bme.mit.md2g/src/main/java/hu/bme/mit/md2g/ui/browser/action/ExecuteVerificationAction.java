package hu.bme.mit.md2g.ui.browser.action;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Injector;
import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.task.ProgressStatus;
import com.nomagic.ui.ProgressStatusRunner;
import com.nomagic.uml2.ext.jmi.helpers.ModelHelper;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.OpaqueBehavior;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;

import hu.bme.mit.gamma.property.model.PropertyPackage;
import hu.bme.mit.gamma.querygenerator.serializer.UppaalPropertySerializer;
import hu.bme.mit.gamma.trace.model.ExecutionTrace;
import hu.bme.mit.gamma.uppaal.transformation.traceability.G2UTrace;
import hu.bme.mit.gamma.uppaal.verification.UppaalVerifier;
import hu.bme.mit.gamma.uppaal.verification.settings.UppaalSettings;
import hu.bme.mit.gamma.uppaal.verification.settings.UppaalSettingsSerializer;
import hu.bme.mit.gamma.verification.result.ThreeStateBoolean;
import hu.bme.mit.md2g.propertylanguage.CustomPropertyLanguageStandaloneSetup;
import hu.bme.mit.md2g.propertylanguage.CustomPropertyScopeProvider;
import hu.bme.mit.md2g.serialization.PropertySerializer;
import hu.bme.mit.md2g.transformation.parse.GammaExpression;
import hu.bme.mit.md2g.util.profile.Gamma;
import hu.bme.mit.md2g.util.profile.Gamma.GammaWorkspace;
import hu.bme.mit.md2g.util.profile.Gamma.ResultTypeEnum;

public class ExecuteVerificationAction extends NMAction {
	
	private OpaqueBehavior expression;
	
	public ExecuteVerificationAction(OpaqueBehavior ob) {
		super("GAMMA_EXECUTE_VERIF", "Execute", null, null);
		expression = ob;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ProgressStatusRunner.runWithProgressStatus(this::actionPerformed, "Verifying model", false, 1);
	}
	
	private void actionPerformed(ProgressStatus status) {
		Element container = expression.getOwner();
		Package workspace = (Package) container.getOwner();
		
		String workspaceUri = GammaWorkspace.getWorkspaceUri(workspace);
		
		Class uppaalModel = (Class) GammaWorkspace.getUppaalModel(workspace);
		Class gammaInterfaceModel = (Class) GammaWorkspace.getGammaInterfaceModel(workspace);
		Class gammaModel = (Class) GammaWorkspace.getGammaStatechartModel(workspace);
		Class trace = (Class) GammaWorkspace.getGammToUppaalTrace(workspace);
		Class uppaalXML = (Class) GammaWorkspace.getUppaalXML(workspace);
		
		ResourceSet resourceSet = new ResourceSetImpl();
		
		PropertySerializer propSerializer = new PropertySerializer(expression);
		
		try {
			loadModel(resourceSet, workspaceUri, uppaalModel);
			loadModel(resourceSet, workspaceUri, gammaInterfaceModel);
			loadModel(resourceSet, workspaceUri, gammaModel);
			Resource traceResource = loadModel(resourceSet, workspaceUri, trace);
			
			EObject eObject = traceResource.getContents().get(0);
			
			if (eObject instanceof G2UTrace) {
				
				G2UTrace traceModel = (G2UTrace) eObject;
				UppaalVerifier uppaalVerifier = new UppaalVerifier();
				
				UppaalSettings settings = new UppaalSettings.Builder()
								  .searchOrder(UppaalSettings.SEARCH_ORDER_DEFAULT)
								  .reuseStateSpace(false)
								  .stateSpaceReduction(UppaalSettings.STATE_SPACE_REDUCTION_DEFAULT)
								  .stateSpaceRepresentation(UppaalSettings.STATE_SPACE_REPRESENTATION_DEFAULT)
								  .trace(UppaalSettings.TRACE_DEFAULT)
								  .hashtableSize(UppaalSettings.HASHTABLE_SIZE_DEFAULT)
								  .build();
				
				UppaalSettingsSerializer serializer = new UppaalSettingsSerializer();
				
				File xmlFile = new File(uppaalXML.getName());
				File query = new File(GammaWorkspace.getWorkspaceUri(workspace) + File.separator + "query.q");
				
				FileWriter fileWriter = new FileWriter(query);
				
				fileWriter.write(propSerializer.serialize());
				fileWriter.close();
				
				ExecutionTrace executionTrace = uppaalVerifier.verifyQuery(traceModel, serializer.serialize(settings), xmlFile, query, true, false);
				
				ThreeStateBoolean result = uppaalVerifier.getResult();
				
				Application.getInstance().getGUILog().log(expression.getName() + " result: " + result.name());
				
				SessionManager.getInstance().executeInsideSession(Project.getProject(expression), "Evaluationg results", () -> {
					if (result == ThreeStateBoolean.TRUE) {
						Gamma.GammaCheckExpression.setResult(expression, ResultTypeEnum.SATISFIED);
					} else if (result == ThreeStateBoolean.FALSE) {
						Gamma.GammaCheckExpression.setResult(expression, ResultTypeEnum.VIOLATED);
					} else if (result == ThreeStateBoolean.UNDEF) {
						Gamma.GammaCheckExpression.setResult(expression, ResultTypeEnum.INDECISIVE);
					}
				});
				
			} else {
				Application.getInstance().getGUILog().log("Trace model is corrupted");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Resource loadModel(ResourceSet resourceSet, String workspaceUri, Class model) throws IOException {
		String gammaModel = ModelHelper.getComment(model);
		
		Resource resource = resourceSet.createResource(URI.createFileURI(workspaceUri + File.separator + model.getName()));

		resource.load(new StringInputStream(gammaModel), Collections.emptyMap());
		
		return resource;
	}

}
