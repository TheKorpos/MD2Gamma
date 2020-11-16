package hu.bme.mit.md2g.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OpaqueExpressoinToRawConverter {
	
	public String convertFile(String uri) throws FileNotFoundException, IOException {
		
		StringBuilder sb = new StringBuilder();
		String tmp = "";
		
		try(FileInputStream newFile = new FileInputStream(uri)){
			int r;
			boolean guard =  false;
			while ((r = newFile.read()) != -1) {
				char ch = (char) r;
				
				if (sb.length() > 0) {
					int lastIdx = sb.codePointAt(sb.length() - 1);
					char codePointAt = (char) lastIdx;
					
					if (codePointAt == '[' && ch == '"') {
						guard = true;					
					} else if (guard && !tmp.isEmpty() && 
							tmp.charAt(tmp.length()  - 1) == '"' && 
							ch == ']') {
						guard = false;
					}
					
					if (guard) {
						tmp += ch;
					} else {
						if (!tmp.isEmpty()) {
							String newTmp = tmp.replace("\\n", "\n");
							//get rid of the last "
							sb.append(newTmp.subSequence(1, newTmp.length()  - 1));
							sb.append("]");
							tmp = "";
						} else {
							sb.append(ch);
						}
					}
				} else {
					sb.append(ch);
				}
			}
		};
		
		return sb.toString();
	}
}
