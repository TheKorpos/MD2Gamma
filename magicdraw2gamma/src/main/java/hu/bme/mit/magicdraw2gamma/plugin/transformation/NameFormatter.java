package hu.bme.mit.magicdraw2gamma.plugin.transformation;

public class NameFormatter {
	
public String fomratName(String name){
		
		char[] out = new char[name.length()];
		
		int i = 0;
		for (char c: name.toCharArray()) {
			switch(c){
				case 'á': out[i]='a';break;
				case 'é': out[i]='e';break;
				case 'í': out[i]='i';break;
				case 'ó': out[i]='o';break;
				case 'ö': out[i]='o';break;
				case 'õ': out[i]='o';break;
				case 'ú': out[i]='u';break;
				case 'ü': out[i]='u';break;
				case 'Á': out[i]='A';break;
				case 'É': out[i]='E';break;
				case 'Í': out[i]='I';break;
				case 'Ó': out[i]='O';break;
				case 'Ö': out[i]='O';break;
				case 'Õ': out[i]='O';break;
				case 'Ú': out[i]='U';break;
				case 'Ü': out[i]='U';break;
				case 'Û': out[i]='U';break;
				case ' ': out[i]='_';break;
				case '(': out[i]='b';break;
				case ')': out[i]='b';break;
				default: out[i]= c ;
			}
			i++;
		}
		
		return new String(out);
	}

}
