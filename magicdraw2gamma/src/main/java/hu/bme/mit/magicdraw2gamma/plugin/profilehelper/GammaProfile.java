package hu.bme.mit.magicdraw2gamma.plugin.profilehelper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Classifier;

import hu.bme.mit.magicdraw2gamma.plugin.profilehelper.queries.GammaProfileQueries;
import hu.bme.mit.magicdraw2gamma.plugin.profilehelper.queries.GammaStereotypeByName;
import hu.bme.mit.magicdraw2gamma.plugin.profilehelper.queries.SuperClasses;

public class GammaProfile {
	
	public static final String PROFILE_NAME = "Gamma";
	
	private static boolean isLoaded = false;
	private static boolean initialized = false;
	private static AdvancedViatraQueryEngine engine;
	private static GammaProfile instance = new GammaProfile();
	
	private GammaProfile() { }
	
	public static GammaProfile getInstance() throws Exception {
		checkInit();
		checkLoaded();
		
		return instance;
	}
	
	public static void initialize(ViatraQueryEngine engine) {
		GammaProfile.engine = (AdvancedViatraQueryEngine) engine;
		GammaProfileQueries.instance().prepare(GammaProfile.engine);
		GammaProfile.initialized = true;
	}
	
	private static void checkInit() throws Exception{
		if (!initialized) throw new Exception("Gamma Profile has not been initialized");
	}
	
	private static void checkLoaded() throws Exception{
		if (!isLoaded) throw new Exception("Gamma Profile has not been loaded");
	}
	
	
	public static void setLoaded(boolean isLoaded) {
		GammaProfile.isLoaded = isLoaded;
	}
	
	private Classifier locateByStereotypeName(String name) throws Exception {
		return engine.getMatcher(GammaStereotypeByName.instance())	
				.getOneArbitraryMatch(name, null)
				.orElseThrow(() -> new Exception(name + " stereotype could not be found"))
				.getStereotype();
	}
	
	public Classifier getGammaCheckStereotype() throws Exception {
		return locateByStereotypeName("GammaCheck");
	}
	
	public List<Classifier> superClassifiers(Classifier classifier) throws Exception{
		checkInit();
		checkLoaded();
		
		return engine.getMatcher(SuperClasses.instance())
				.getAllMatches(classifier, null)
				.stream()
				.map(m -> m.getSuperClass()).collect(Collectors.toList());
	}

	public Classifier gammaStatechartDefinitionStereotype() throws Exception {
		return locateByStereotypeName("StatechartDefinition");
	}
	
}
