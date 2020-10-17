package hu.bme.mit.md2g.propertylanguage;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

import hu.bme.mit.gamma.statechart.statechart.StateNode;
import hu.bme.mit.md2g.transformation.TraceModelManager;

public class CustomQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	
	private TraceModelManager manager;
	
	
	public void setManager(TraceModelManager manager) {
		this.manager = manager;
	}


	@Override
	protected QualifiedName qualifiedName(Object ele) {
		return super.qualifiedName(ele);
	}

}
