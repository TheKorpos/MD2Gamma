package hu.bme.mit.md2g.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement;

public class NameSanitizer {
	
	private final Map<EClass, Integer> nexUnnamedIndexes = new HashMap<>();
	
	public String getSenitizedName(NamedElement namedElement) {
		String name = namedElement.getName();
		
		if (name == null || name.isEmpty()) {
			Integer nextIndex = nexUnnamedIndexes.getOrDefault(namedElement.eClass(), 0);
			name = namedElement.eClass().getName() + "_" + nextIndex;
			nexUnnamedIndexes.replace(namedElement.eClass(), new Integer(nextIndex + 1));
		}
		
		name = name.replace(" ", "_");
		
		return name;
		
	}
	
}
