package hu.bme.mit.md2g.ui.browser.action;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.google.inject.Injector;
import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.ui.MagicDrawProgressStatusRunner;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;

import hu.bme.mit.gamma.statechart.language.StatechartLanguageStandaloneSetup;
import hu.bme.mit.gamma.statechart.model.Package;
import hu.bme.mit.md2g.serialization.StatechartLanguageSerializer;
import hu.bme.mit.md2g.transformation.CompositeTransformation;
import hu.bme.mit.md2g.util.NameSanitizer;

public class TransformCompositeStatemachineAction extends NMAction {

	private static final long serialVersionUID = -391974153578591338L;

	private Class target;

	public TransformCompositeStatemachineAction(String id, String name, Class target) {
		super(id, name, 0, null);
		this.target = target;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		MagicDrawProgressStatusRunner.runWithProgressStatus(progress -> {

			ArrayList<Class> targetList = new ArrayList<>();
			targetList.add(target);

			JFileChooser filechooser = new JFileChooser();
			filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			int state = filechooser.showSaveDialog(Application.getInstance().getMainFrame());

			if (state == JFileChooser.APPROVE_OPTION) {

				File selectedFile = filechooser.getSelectedFile();

				CompositeTransformation transformation = new CompositeTransformation();
				List<Package> packages = transformation.transform(target);
				NameSanitizer nameSanitizer = new NameSanitizer();
				Map<URI, EObject> uriMap = packages.stream().collect(
						Collectors.toMap(p -> StatechartLanguageSerializer.createURI(selectedFile.getAbsolutePath(),
								nameSanitizer.getSenitizedName(target) + ".gcd"), p -> p));

				try {
					StatechartLanguageSerializer.serialize(uriMap);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			
		}, "Exporting models", false, 0);
	}

	private String toFilePath(String s) {
		return s.replace(".", File.separator);
	}

}