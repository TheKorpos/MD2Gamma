package hu.bme.mit.md2g.verification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.python.google.common.io.Files;

import com.google.inject.Injector;

import hu.bme.mit.gamma.trace.language.TraceLanguageStandaloneSetup;
import hu.bme.mit.gamma.trace.model.ExecutionTrace;
import hu.bme.mit.gamma.uppaal.backannotation.EmptyTraceException;
import hu.bme.mit.gamma.uppaal.backannotation.StringTraceBackAnnotator;
import hu.bme.mit.gamma.uppaal.transformation.traceability.TraceabilityPackage;

public class UppaalVerification {
	
	private boolean needsBackAnnotation = true;
	private boolean isCancelled;
	private String uppaalXmlFile;
	private String parentFolder;
	private String tracebilityFile;
	private String originalUppaalQueries;
	private boolean isSingleTraceModelFromMultipleQueries;
	private String workspace;
	
	
	public UppaalVerification(String workspaceUri, String uppaalXmlFile, String tracebilityFile, String query) {
		this.uppaalXmlFile = uppaalXmlFile;
		this.tracebilityFile = tracebilityFile;
		this.workspace = workspaceUri;
		this.originalUppaalQueries = query;
	}

	public ThreeStateBoolean doInBackground() throws Exception {
		try {
			// Common traceability and execution trace
			ResourceSet traceabilitySet = loadTraceability();
			ExecutionTrace traceModel = null;
			// Verification starts
			if (isSingleTraceModelFromMultipleQueries) {
				String[] uppaalQueries = originalUppaalQueries.split(System.lineSeparator());
				for (String uppaalQuery : uppaalQueries) {
					try {
						if (traceModel == null) {
							traceModel = verifyQuery(uppaalQuery, traceabilitySet);
						}
						else {
							ExecutionTrace additionalTrace = verifyQuery(uppaalQuery, traceabilitySet);
							traceModel.getSteps().addAll(additionalTrace.getSteps());
						}
					} catch (NotBackannotatedException e) {
					
					}
					catch (Exception e) {
						
					}
				}
			}
			else {
				traceModel = verifyQuery(originalUppaalQueries, traceabilitySet);
			}
			if (traceModel == null) {
				throw new IllegalArgumentException("None of the specified queries resulted in a trace.");
			}
			serializeTestCode(traceModel, traceabilitySet);
			// There is a generated trace, so the result is the opposite of the empty trace
			return handleEmptyLines(originalUppaalQueries).opposite();
		} catch (EmptyTraceException e) {
			return handleEmptyLines(originalUppaalQueries);
		} catch (NotBackannotatedException e) {
			return e.getThreeStateBoolean();
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Error! The generated UPPAAL file cannot be found.");
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Error! The generated UPPAAL file cannot be found.");
		} catch (Throwable e) {
			final String errorMessage = "Cannot handle deadlock predicate for models with priorities or guarded broadcast receivers.";
			if (e.getMessage().contains(errorMessage)) {
				// Not a big problem
				return ThreeStateBoolean.UNDEF;
			}
			else {
				IllegalArgumentException ex = new IllegalArgumentException("Error! " + e.getMessage());
				ex.initCause(e);
				throw ex;
			}
		}
	}
	
	private void serializeTestCode(ExecutionTrace traceModel, ResourceSet traceabilitySet) throws IOException {
		Entry<String, Integer> fileNameAndId = getFileName("get"); // File extension could be gtr or get
		fileNameAndId = saveModel(traceModel, fileNameAndId);
	}
	
	 private Map.Entry<String, Integer> getFileName(String fileExtension) {
	    	final String TRACE_FILE_NAME = "ExecutionTrace";
	    	List<Integer> usedIds = new ArrayList<Integer>();
	    	File traceFile = new File(getTraceFolder());
	    	traceFile.mkdirs();
	    	// Searching the trace folder for highest id
	    	for (File file: new File(getTraceFolder()).listFiles()) {
	    		if (file.getName().matches(TRACE_FILE_NAME + "[0-9]+\\..*")) {
	    			String id = file.getName().substring(TRACE_FILE_NAME.length(), file.getName().length() - ("." + fileExtension).length());
	    			usedIds.add(Integer.parseInt(id));
	    		}
	    	}
	    	if (usedIds.isEmpty()) {
	    		return new AbstractMap.SimpleEntry<String, Integer>(
	    				TRACE_FILE_NAME + "0." + fileExtension, 0);
	    	}
	    	Collections.sort(usedIds);
	    	Integer biggestId = usedIds.get(usedIds.size() - 1);
	    	return new AbstractMap.SimpleEntry<String, Integer>(
	    			TRACE_FILE_NAME + (biggestId + 1) + "." + fileExtension, (biggestId + 1));
	    }
	 
	 private void serialize(EObject rootElem, String parentFolder, String fileName) throws IOException {
			// This is how an injected object can be retrieved
			Injector injector = new TraceLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
			TraceLanguageSerializer serializer = injector.getInstance(TraceLanguageSerializer.class);
			serializer.save(rootElem, URI.decode(parentFolder + File.separator + fileName));
	   }
	 
	 private Entry<String, Integer> saveModel(ExecutionTrace traceModel, Entry<String, Integer> fileNameAndId)
				throws IOException {
			try {
				// Trying to serialize the model
				serialize(traceModel, getTraceFolder(), fileNameAndId.getKey());
			} catch (Exception e) {
					//"Possibly you have two more model elements with the same name specified in the previous error message.");
				new File(getTraceFolder() + File.separator + fileNameAndId.getKey()).delete();
				// Saving like an EMF model
				fileNameAndId = getFileName("gtr");
				serialize(traceModel, getTraceFolder(), fileNameAndId.getKey());
			}
			return fileNameAndId;
		}

	private String getTraceFolder() {
		return workspace + File.separator + "trace";
	}

	private ResourceSet loadTraceability() {
		TraceabilityPackage.eINSTANCE.getNsURI();
		ResourceSet resSet = new ResourceSetImpl();
		URI fileURI = URI.createFileURI(getTraceabilityFile());
		try {
			resSet.getResource(fileURI, true);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
		return resSet;
	}

	private String getTraceabilityFile() {
		return this.tracebilityFile;
	}

	private ExecutionTrace verifyQuery(String actualUppaalQuery, ResourceSet traceabilitySet)
			throws IOException, NotBackannotatedException, EmptyTraceException {
		Scanner traceReader = null;
		try {
			// Writing the query to a temporary file
			File tempQueryfile = writeToFile(actualUppaalQuery, getParentFolder(), ".temporary_query.q");
			// Deleting the file on the exit of the JVM
			tempQueryfile.deleteOnExit();
			// verifyta -t0 -T TestOneComponent.xml asd.q 
			StringBuilder command = new StringBuilder();
			command.append("verifyta " + getParameters() + " \"" + getUppaalXmlFile() + "\" \"" + tempQueryfile.getCanonicalPath() + "\"");
			// Executing the command
			Process process = Runtime.getRuntime().exec(command.toString());
			InputStream ips = process.getErrorStream();
			// Reading the result of the command
			traceReader = new Scanner(ips);
			if (isCancelled) {
				// If the process is killed, this is where it can be checked
				throw new NotBackannotatedException(ThreeStateBoolean.UNDEF);
			}
			if (!traceReader.hasNext()) {
				// No back annotation of empty lines
				throw new NotBackannotatedException(handleEmptyLines(originalUppaalQueries));
			}
			// Warning lines are now deleted if there was any
			StringTraceBackAnnotator backAnnotator = new StringTraceBackAnnotator(traceabilitySet, traceReader);
			ExecutionTrace traceModel = backAnnotator.execute();
			if (!needsBackAnnotation) {
				// If back-annotation is not needed, we return after checking if it is an empty trace (watching out for warning lines)
				throw new NotBackannotatedException(handleEmptyLines(originalUppaalQueries).opposite());
			} 
			return traceModel;
		} finally {
			traceReader.close();
		}
	}
	
	private File writeToFile(String actualUppaalQuery, String parentFolder, String fileName) throws IOException {
		File file = new File(parentFolder, fileName);
		Files.write(actualUppaalQuery.getBytes(), file);
		return new File(parentFolder, fileName);
	}

	private String getParameters() {
		return new UppaalVerificationConfig().getParameters();
	}

	private String getUppaalXmlFile() {
		return this.uppaalXmlFile;
	}

	private String getParentFolder() {
		return workspace;
	}
	

	public class NotBackannotatedException extends Exception {
		private ThreeStateBoolean threeStateBoolean;
		
		NotBackannotatedException(ThreeStateBoolean threeStateBoolean) {
			this.threeStateBoolean = threeStateBoolean;
		}
		
		public ThreeStateBoolean getThreeStateBoolean() {
			return threeStateBoolean;
		}
	}
	
	private ThreeStateBoolean handleEmptyLines(String uppaalQuery) {
		if (uppaalQuery.startsWith("A[]") || uppaalQuery.startsWith("A<>")) {
			// In case of A, empty trace means the requirement is met
			return ThreeStateBoolean.TRUE;
		}
		// In case of E, empty trace means the requirement is not met
		return ThreeStateBoolean.FALSE;
	}

	public enum ThreeStateBoolean {
		FALSE, TRUE, UNDEF;
		
		public ThreeStateBoolean opposite() {
			switch (this) {
				case FALSE:
					return TRUE;
				case TRUE:
					return FALSE;
				default:
					return UNDEF;
			}		
		}
		
	}
}
