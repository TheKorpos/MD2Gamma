package hu.bme.mit.md2g.ui.browser.action;

import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.Optional;

import javax.swing.JOptionPane;

import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.uml.Finder;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.OpaqueBehavior;

import hu.bme.mit.md2g.util.ModelHelper;
import hu.bme.mit.md2g.util.profile.Gamma;
import hu.bme.mit.md2g.verification.UppaalVerification;
import hu.bme.mit.md2g.verification.UppaalVerification.ThreeStateBoolean;

public class PerformFormalVerificationAction extends NMAction {
	
	private OpaqueBehavior checkExpression;
	
	public PerformFormalVerificationAction(OpaqueBehavior checkExpression) {
		super("GAMMA_WORKSPACE_PERFORM_VERIF", "Perform Formal Verification", null, null);
		this.checkExpression = checkExpression;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Package workspace = ModelHelper.findNearesParentPackage(checkExpression);
		
		Collection<Class> classes = Finder.byType().find(workspace, Class.class);
		
		Optional<Class> uppaalXML = classes.stream().filter(Gamma::isGammaWorkspaceFile).filter(c -> c.getName().endsWith("xml")).findFirst();
		Optional<Class> g2u = classes.stream().filter(Gamma::isGammaWorkspaceFile).filter(c -> c.getName().endsWith("g2u")).findFirst();
		
		if (g2u.isPresent() && uppaalXML.isPresent()) {
			String workspaceUri = Gamma.GammaWorkspace.getWorkspaceUri(workspace);
			String query = checkExpression.getBody().get(0);
			UppaalVerification uppaalVerification = new UppaalVerification(workspaceUri, uppaalXML.get().getName(), g2u.get().getName(), query);
			try {
				ThreeStateBoolean result = uppaalVerification.doInBackground();
				switch (result) {
					case TRUE : {
						JOptionPane.showMessageDialog(Application.getInstance().getMainFrame(), "The property holds");
						break;
					}
					case FALSE : {
						JOptionPane.showMessageDialog(Application.getInstance().getMainFrame(), "The property does not hold");
						break;
					}
					default:
						JOptionPane.showMessageDialog(Application.getInstance().getMainFrame(), "");
						break;
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	

}
