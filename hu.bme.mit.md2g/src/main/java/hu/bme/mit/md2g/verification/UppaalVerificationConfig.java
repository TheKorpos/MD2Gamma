package hu.bme.mit.md2g.verification;

public class UppaalVerificationConfig {
	
	private String searchOrder;
	private String statespaceReduction;
	private String diagnosticTrace;
	private String reuseSafespace;
	private boolean memoryReduction = false;
	
	
	public UppaalVerificationConfig() {
		searchOrder = getSearchOrder("Breadth First", "Sortest");
		statespaceReduction = getStateSpaceReduction("None");
		diagnosticTrace = getDiagnosticTrace("Shortest");
		reuseSafespace = getResuseStateSpace(false);
	}

	public UppaalVerificationConfig(String searchMode, String selectedTrace, String statespaceReduction, String diagnosticTrace, boolean reuseSafespace) {
		this.searchOrder = getSearchOrder(searchMode, selectedTrace);
		this.statespaceReduction = getStateSpaceReduction(statespaceReduction);
		this.diagnosticTrace = getDiagnosticTrace(diagnosticTrace);
		this.reuseSafespace = getResuseStateSpace(reuseSafespace);
	}
	
	
	public String getParameters() {
		return searchOrder + " " + diagnosticTrace + " " + reuseSafespace + " " +
				getMemoryReductionTechniques() + " " + getHashtableSize() + " " + statespaceReduction;
	}
		
	private String getSearchOrder(String searchMode, String selectedTrace) {
		final String paremterName = "-o ";
		switch (searchMode) {
		case "Breadth First":
			return paremterName + "0";
		case "Depth First":
			return paremterName + "1";
		case "Random Depth First":
			return paremterName + "2";
		case "Optimal First":
			if (selectedTrace.equals("Shortest") || selectedTrace.equals("Fastest")) {
				return paremterName + "3";	
			}
			// BFS
			return paremterName + "0"; 
		case "Random Optimal Depth First":
			if (selectedTrace.equals("Shortest") || selectedTrace.equals("Fastest")) {
				return paremterName + "4";
			}
			// BFS
			return paremterName + "0"; 
		default:
			throw new IllegalArgumentException();
		}
	}
	
	private String getStateSpaceReduction(String statespaceReduction) {
		final String paremterName = "-S ";
		switch (statespaceReduction) {
		case "None":
			// BFS
			return paremterName + "0";
		case "Conservative":
			// DFS
			return paremterName + "1";
		case "Aggressive":
			// Random DFS
			return paremterName + "2";			
		default:
			throw new IllegalArgumentException();
		}
	}
	
	private String getMemoryReductionTechniques() {
		if (memoryReduction ) {
			return "-C";
		}
		return "";
	}
	
	private String getResuseStateSpace(boolean isReuseStateSpace) {
		if (isReuseStateSpace) {
			return "-T";
		}
		return "";
	}
	
	private String getDiagnosticTrace(String selectedTrace) {
		switch (selectedTrace) {
		case "Some":
			// Some trace
			return "-t0";
		case "Shortest":
			// Shortest trace
			return "-t1";
		case "Fastest":
			// Fastest trace
			return "-t2";			
		default:
			throw new IllegalArgumentException();
		}
	}
	
	
	private String getHashtableSize() {
		/* -H n
	      Set hash table size for bit state hashing to 2**n
	      (default = 27)
		 */
		final String paremterName = "-H ";
		final int value = 27;
		final int exponent = 20 + (int) Math.floor(Math.log10(value) / Math.log10(2)); // log2(value)
		return paremterName + exponent;
	}

}
