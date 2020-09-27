package hu.bme.mit.md2g.listener;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.core.project.ProjectEventListenerAdapter;

import hu.bme.mit.gamma.expression.model.ExpressionModelPackage;
import hu.bme.mit.gamma.statechart.statechart.StatechartModelPackage;
import hu.bme.mit.md2g.transformation.queries.CompositeQueries;
import hu.bme.mit.md2g.transformation.queries.StatechartQueries;

public class ProjectSpecificFeatureInitializer extends ProjectEventListenerAdapter {
	
	@Override
	public void projectOpened(Project project) {
		ViatraQueryAdapter adapter = ViatraQueryAdapter.getOrCreateAdapter(project);
		ViatraQueryEngine engine = adapter.getEngine();
	
		StatechartModelPackage.eINSTANCE.getNsURI();
		ExpressionModelPackage.eINSTANCE.getNsURI();
		
		CompositeQueries.instance().prepare(engine);
		StatechartQueries.instance().prepare(engine);
	}
	
}
