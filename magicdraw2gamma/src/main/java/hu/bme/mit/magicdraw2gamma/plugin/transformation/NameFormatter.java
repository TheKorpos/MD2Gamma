package hu.bme.mit.magicdraw2gamma.plugin.transformation;

public class NameFormatter {
	
public String fomratName(String name){
		
		char[] out = new char[name.length()];
		
		int i = 0;
		for (char c: name.toCharArray()) {
			switch(c){
				case '�': out[i]='a';break;
				case '�': out[i]='e';break;
				case '�': out[i]='i';break;
				case '�': out[i]='o';break;
				case '�': out[i]='o';break;
				case '�': out[i]='o';break;
				case '�': out[i]='u';break;
				case '�': out[i]='u';break;
				case '�': out[i]='A';break;
				case '�': out[i]='E';break;
				case '�': out[i]='I';break;
				case '�': out[i]='O';break;
				case '�': out[i]='O';break;
				case '�': out[i]='O';break;
				case '�': out[i]='U';break;
				case '�': out[i]='U';break;
				case '�': out[i]='U';break;
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
