package CryptMachine;

import java.io.*;

public class Crypt {
	
	
	private String path;
	private File file;
	private int deltaKey = 6;
	
	public Crypt (String path, File file) {
		
		this.path = path;
		this.file = file; 
	}
	
	public String getPath() {
		return path;
	}
	
	public void processFile () throws IOException {
		try(BufferedReader bf = new BufferedReader ( new FileReader(this.path));
				FileWriter fw = new FileWriter (this.file, true)) {  
			String reader;
			while((reader = bf.readLine()) != null) {
				char symbol [] = reader.toCharArray();
				char encryptSymbol[] = new char [symbol.length];
				for (int i =0 ;i<symbol.length; i++) {
					encryptSymbol[i] = (char)(symbol[i] + deltaKey);
					fw.write(encryptSymbol[i]);
				}
				fw.write("\n\r");
			}
		}
		
	}
}
