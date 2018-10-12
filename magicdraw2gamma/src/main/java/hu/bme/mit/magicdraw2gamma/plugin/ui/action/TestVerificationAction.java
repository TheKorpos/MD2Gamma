package hu.bme.mit.magicdraw2gamma.plugin.ui.action;

import java.awt.event.ActionEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.AbstractMap.SimpleEntry;
import java.util.Scanner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;

import hu.bme.mit.gamma.statechart.model.InitialState;
import hu.bme.mit.gamma.statechart.model.Region;
import hu.bme.mit.gamma.statechart.model.State;
import hu.bme.mit.gamma.statechart.model.StatechartDefinition;
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory;
import hu.bme.mit.gamma.statechart.model.Transition;
import hu.bme.mit.gamma.uppaal.serializer.UppaalModelSerializer;
import hu.bme.mit.gamma.uppaal.transformation.batch.StatechartToUppaalTransformer;
import hu.bme.mit.gamma.uppaal.transformation.queries.internal.ErrorPatternsAll;
import hu.bme.mit.gamma.uppaal.transformation.traceability.G2UTrace;
import uppaal.NTA;

public class TestVerificationAction extends MDAction {

	public TestVerificationAction(String id, String name) {
		super(id, name, null, null);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		StatechartModelFactory f = StatechartModelFactory.eINSTANCE;
		hu.bme.mit.gamma.statechart.model.Package p = f.createPackage();
		StatechartDefinition def = f.createStatechartDefinition();
		p.getComponents().add(def);
		p.setName("main");
		
		
		Region region = f.createRegion();
		region.setName("MainRegion");
		
		def.getRegions().add(region);
		
		InitialState is = f.createInitialState();
		region.getStateNodes().add(is);
		
		State state = f.createState();
		state.setName("First State");
		
		region.getStateNodes().add(state);
		
		Transition trans = f.createTransition();
		
		trans.setSourceState(is);
		trans.setTargetState(state);
		
		def.getTransitions().add(trans);
		
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("gammastatechart"));
		r.getContents().add(p);
		
		StatechartToUppaalTransformer transformer = new StatechartToUppaalTransformer(p);
		SimpleEntry<NTA, G2UTrace> entry = transformer.execute();
		
		final String mdHome = Application.environment().getInstallRoot();
		
		UppaalModelSerializer.saveToXML(entry.getKey(), mdHome + "\\gammaOut", "something.xml");
		
		
		String query = "A[] not deadlock";

		
		Process process;
		try {
			FileWriter fw = new FileWriter(new File(mdHome + "\\gammaOut\\query.q"));
			fw.write(query);
			fw.close();
			
			StringBuilder command = new StringBuilder();
			// verifyta -t1 TestOneComponent.xml asd.q 
			command.append("verifyta " + getParameters() + " \"" + mdHome + "\\gammaOut\\something.xml" + "\" \"" + mdHome + "\\gammaOut\\query.q" + "\"");
			// Executing the command
			
			process = Runtime.getRuntime().exec(command.toString());
			InputStream ips = process.getErrorStream();
			Scanner scanner = new Scanner(ips);
			scanner.forEachRemaining(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
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
