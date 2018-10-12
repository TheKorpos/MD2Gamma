package hu.bme.mit.magicdraw2gamma.plugin.options;

import com.nomagic.magicdraw.core.options.ProjectOptions;
import com.nomagic.magicdraw.core.options.ProjectOptionsConfigurator;
import com.nomagic.magicdraw.properties.Property;
import com.nomagic.magicdraw.properties.PropertyResourceProvider;
import com.nomagic.magicdraw.properties.StringProperty;

public class GammaProjectOptionsConfigurator implements ProjectOptionsConfigurator {
	
	private static final String GROUP_NAME = "MagicDraw to Gamma";
	public static final String GAMMA_WORK_DIR_ID = "GAMMA_WORK_DIR";
	private static final String GAMMA_WORK_DIR_NAME = "Gamma Work Directory";
	protected static final String GROUP_ID = "MD2G";

	@Override
	public void afterLoad(ProjectOptions projectOptions) {
		return;
		
	}

	@Override
	public void configure(ProjectOptions projectOptions) {
		
		Property property =  projectOptions.getProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES, GAMMA_WORK_DIR_ID);
		if (property == null) {
			property = new StringProperty(GAMMA_WORK_DIR_ID, "");
			property.setGroup(GROUP_NAME);
			
			property.setResourceProvider(new PropertyResourceProvider() {
				
				@Override
				public String getString(String string, Property property) {
					switch(string) {
						case GAMMA_WORK_DIR_ID: return GAMMA_WORK_DIR_NAME;
						case GROUP_ID: return GROUP_NAME;
						case GAMMA_WORK_DIR_ID+"_DESCRIPTION": return "Working directory for MD2G Plugin";
						default: return string;						
					}
				}
			});
			
			projectOptions.addProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES, property);
		}
		
	}

}
