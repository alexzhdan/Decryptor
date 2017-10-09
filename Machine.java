package CryptMachine;

import java.io.*;
import java.util.*;

public class Machine {
	
	private static Machine instance;
	private File file;
	private String path;
	private String newPath;
	
	private Machine (String path) throws IOException {
		this.path = path;
		this.newPath = path.substring(0, path.lastIndexOf("\\"));
		String name = path.substring(path.lastIndexOf("\\")+1, path.lastIndexOf("."));
		File directory = new File(newPath);
		if (directory.isDirectory())
		this.file = File.createTempFile(name, ".txt", directory); 
		
		
		
	}
	
	public static Machine getInstance (String path) throws IOException {
		instance = new Machine(path);
		return instance;
	}
	
	public File getFile() {
		return this.file;
	}
	
	public String getPath () {
		return this.path;
	}
	public void encrypt () throws IOException {
		Crypt crypt = new Crypt (this.path, this.file);
		crypt.processFile();
		System.out.println("File successfuly encrypt: " + this.file.getPath());
	}
	
	public void decrypt () throws IOException {
		Decrypt decrypt = new Decrypt (this.path, this.file);
		decrypt.processFile();
		System.out.println("File successfuly encrypt: " + this.file.getPath());
	}
}
