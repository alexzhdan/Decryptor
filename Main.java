package CryptMachine;

import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*char a = ':';
		char b = (char)(a+10);
		System.out.println(b);
		System.out.println((char)(b-10));*/
		String path;
		
		System.out.println("Please enter file path");			
		Scanner filePath =  new Scanner(System.in); 
		while (filePath.hasNext()) { 
			path = filePath.next();
			File temp = new File(path);
			
			if(temp.exists()) {
			Machine mach = Machine.getInstance(path);
		
			System.out.println("Please choose encrypt or decrypt your file (e/d)?");
		
			Scanner work = new Scanner(System.in);
			while(work.hasNext()) {
				String comand = work.next().toLowerCase();
		
				while (!(comand.equals("e") || comand.equals("d"))) {
					System.out.println("Please enter correct variant: e or d");
					Scanner updateWork = new Scanner(System.in);
					
					if(updateWork.hasNext()) {
						comand = updateWork.next().toLowerCase();
						updateWork.close();
						}
					}
				if (comand.equals("e")) { 
					mach.encrypt();
					break;
					}
				
				else if (comand.equals("d")) {
					mach.decrypt();
					break;
					} 
			}
		work.close();
		}
		else {
			System.out.println("File not found");
			break;
			}
		}
	filePath.close();
			
	}
}

