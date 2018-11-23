package hu.bme.mit.magicdraw2gamma.plugin.ui.action;

import java.awt.event.ActionEvent;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;

import com.google.inject.Injector;
import com.nomagic.magicdraw.actions.MDAction;

import akka.dispatch.AbstractBoundedNodeQueue.Node;
import hu.bme.mit.gamma.constraint.language.ConstraintLanguageStandaloneSetup;
import hu.bme.mit.gamma.constraint.language.parser.antlr.ConstraintLanguageParser;
import hu.bme.mit.gamma.constraint.model.ConstraintModelPackage;

public class TestVerificationAction extends MDAction {

	public TestVerificationAction(String id, String name) {
		super(id, name, null, null);
		
		
	}
		

	@Override
	public void actionPerformed(ActionEvent event) {
		
		Token token;
		
		ConstraintModelPackage.eINSTANCE.getNsURI();
		
		
		Injector injector = new ConstraintLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
		//XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		
		String proba = "specification something() {constraint true}";
		InputStreamReader ips = new InputStreamReader(new ByteArrayInputStream(proba.getBytes()));
		
		IParseResult ps = injector.getInstance(ConstraintLanguageParser.class).parse(ips);
		
		for (INode node: ps.getSyntaxErrors()) {
			System.err.println(node.getText());
		}
		
		ps.getRootNode().getFirstChild();
		
		EObject object = ps.getRootASTElement();
			
		return;
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
