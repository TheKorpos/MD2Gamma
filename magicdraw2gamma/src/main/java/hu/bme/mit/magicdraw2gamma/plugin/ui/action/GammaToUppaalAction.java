package hu.bme.mit.magicdraw2gamma.plugin.ui.action;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.Optional;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.jdesktop.swingx.plaf.nimbus.NimbusTaskPaneUI;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.options.ProjectOptions;
import com.nomagic.magicdraw.properties.Property;

import hu.bme.mit.gamma.statechart.model.Package;
import hu.bme.mit.gamma.statechart.model.StatechartModelPackage;
import hu.bme.mit.gamma.uppaal.serializer.UppaalModelSerializer;
import hu.bme.mit.gamma.uppaal.transformation.batch.StatechartToUppaalTransformer;
import hu.bme.mit.gamma.uppaal.transformation.traceability.G2UTrace;
import hu.bme.mit.magicdraw2gamma.plugin.options.GammaProjectOptionsConfigurator;
import uppaal.NTA;

public class GammaToUppaalAction extends MDAction{
	
	public GammaToUppaalAction(String id, String name) {
		super(id, name, null, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		StatechartModelPackage.eINSTANCE.getNsURI();
		
		
		Property prop = Application.getInstance().getProject().getOptions().getProperty(
				ProjectOptions.PROJECT_GENERAL_PROPERTIES,
				GammaProjectOptionsConfigurator.GAMMA_WORK_DIR_ID
				);
		
		String workdirPath = prop.getValueStringRepresentation();
		
		JFileChooser filechooser = new JFileChooser();
		filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);	
		filechooser.setMultiSelectionEnabled(false);
		filechooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Gamma files";
			}
			
			@Override
			public boolean accept(File f) {
				return f.getName().endsWith(".gsm");
			}
		});
		
		if (!"".equals(prop.getValueStringRepresentation())) {
			filechooser.setCurrentDirectory(new File(prop.getValueStringRepresentation()));
		}
		
		int state = filechooser.showOpenDialog(Application.getInstance().getMainFrame());
		
		try {
			if (state == JFileChooser.APPROVE_OPTION) {
				File selected = filechooser.getSelectedFile();
				String filePath = selected.getAbsolutePath();
				
				
				String name = selected.getAbsolutePath().substring(filePath.lastIndexOf(File.separator) + 1, filePath.lastIndexOf("."));
				
				ResourceSet rs = new ResourceSetImpl();
				Resource r = rs.getResource(URI.createFileURI(selected.getPath()), true);
				
				Optional<Package> optO = r.getContents().stream().filter(Package.class::isInstance).map(Package.class::cast).findFirst();
				
				if (optO.isPresent()) {
					Package p = optO.get();
					StatechartToUppaalTransformer transformer = new StatechartToUppaalTransformer(p);
					SimpleEntry<NTA, G2UTrace> entry = transformer.execute();
					
					Resource nta = rs.createResource(URI.createFileURI(workdirPath + "/" + name + ".nta"));
					nta.getContents().add(entry.getKey());
					nta.save(Collections.EMPTY_MAP);
					
					Resource trace = rs.createResource(URI.createFileURI(workdirPath + "/./" + name + ".g2u"));
					trace.getContents().add(entry.getValue());
					trace.save(Collections.EMPTY_MAP);
					
					UppaalModelSerializer.saveToXML(entry.getKey(), workdirPath , name +".xml");
				}
			
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
