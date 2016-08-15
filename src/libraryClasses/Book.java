package libraryClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Book {
	
	Path filePath = Paths.get("Book.txt");

	File myBookFile = filePath.toFile();
	
	writeToFileAppend(myBookFile);
	writeToFile(myBookFile);
	readFile(myBookFile);
}

/**
 * @param myConfigFile
 */
public static void readFile(File myBookFile) {
	try {
		FileReader reader = new FileReader(myBookfile);
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
public static void writeToFile(File myBookFile) {
	PrintWriter wrt = null;
	try {
		wrt = new PrintWriter(myBookFile);

		wrt.println("Hello world");
		

	} catch (FileNotFoundException e) {

		e.printStackTrace();
	} // checked exception
	finally {
		wrt.close();
	}
}

public static void writeToFileAppend(File myBookFile) {
	FileWriter wrt = null;
	try {
		wrt = new FileWriter(myBookFile,true);

		wrt.append("\nHello\n"); 
		wrt.append("world");
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


}
