package hu.bme.mit.md2g.listener;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.core.project.ProjectEventListenerAdapter;

import hu.bme.mit.gamma.expression.model.ExpressionModelPackage;
import hu.bme.mit.gamma.property.model.PropertyModelPackage;
import hu.bme.mit.gamma.property.model.PropertyPackage;
import hu.bme.mit.gamma.statechart.statechart.StatechartModelPackage;
import hu.bme.mit.gamma.trace.model.TraceModelPackage;
import hu.bme.mit.gamma.uppaal.transformation.traceability.TraceabilityPackage;
import hu.bme.mit.md2g.transformation.queries.CompositeQueries;
import hu.bme.mit.md2g.transformation.queries.StatechartQueries;
import uppaal.UppaalPackage;

public class ProjectSpecificFeatureInitializer extends ProjectEventListenerAdapter {
	
	@Override
	public void projectOpened(Project project) {
		ViatraQueryAdapter adapter = ViatraQueryAdapter.getOrCreateAdapter(project);
		ViatraQueryEngine engine = adapter.getEngine();
	
		StatechartModelPackage.eINSTANCE.getNsURI();
		ExpressionModelPackage.eINSTANCE.getNsURI();
		UppaalPackage.eINSTANCE.getNsURI();
		TraceModelPackage.eINSTANCE.getNsURI();
		TraceabilityPackage.eINSTANCE.getNsURI();
		PropertyModelPackage.eINSTANCE.getNsURI();
		
		CompositeQueries.instance().prepare(engine);
		StatechartQueries.instance().prepare(engine);
	}
	
}
