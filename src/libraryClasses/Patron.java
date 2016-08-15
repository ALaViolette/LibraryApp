package libraryClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.nio.file.Path;
//import java.nio.file.Paths;

public class Patron {
	
//	Path filePath = Paths.get("Patron.txt");
//
//	File myBookFile = filePath.toFile();
//	
//	//writeToFileAppend(myPatronFile);
//	//writeToFile(myPatronFile);
//	readFile(myPatronFile);
//}

/**
 * @param myConfigFile
 */
public static void readFile(File myPatronFile) {
	try {
		FileReader reader = new FileReader(myPatronFile);
		BufferedReader bReader = new BufferedReader(reader);
		String newLine = bReader.readLine();
		
		while(newLine != null){
			
			System.out.println(newLine);
			newLine = bReader.readLine();
			
		}
		
	} catch (FileNotFoundException e ) {

		e.printStackTrace();
		
	}catch (IOException e){
		
	}
}

/*
 * @param myConfigFile
 */
public static void writeToFile(File myPatronFile) {
	PrintWriter wrt = null;
	try {
		wrt = new PrintWriter(myPatronFile);

		wrt.println("Phone number, Brown, Blair ");
		wrt.println("Phone number, La Violette, Ambyr");
		wrt.println("810-922-9329, Morse, Grace");
		

	} catch (FileNotFoundException e) {

		e.printStackTrace();
	} // checked exception
	finally {
		wrt.close();
	}
}

public static void writeToFileAppend(File myPatronFile) {
	FileWriter wrt = null;
	try {
		wrt = new FileWriter(myPatronFile,true);

	//	wrt.append("\nHello\n"); 
		//wrt.append("world");
		wrt.close();
		

	} catch (FileNotFoundException e) {

		e.printStackTrace();
	} 
	catch(IOException e){
		
	}
//	finally {
//		wrt.close();
//	}
}


}





