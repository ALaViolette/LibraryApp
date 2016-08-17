package libraryClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.nio.file.Paths;

public class BookIO {
	
	Path filePath = Paths.get("Book.txt");

	File myBookFile = filePath.toFile();
//	
//	//writeToFileAppend(myBookFile);
//	//writeToFile(myBookFile);
//	readFile(myBookFile);
//}

/**
 * @param myConfigFile
 */
public static String readFile() {
	Path filePath = Paths.get("Book.txt");
  	File myBookFile = filePath.toFile();
	String newLine="";
	String fileText="";
	try {
		FileReader reader = new FileReader(myBookFile);
		BufferedReader bReader = new BufferedReader(reader);
		 newLine = bReader.readLine();
		
		while(newLine != null){
			fileText+=newLine+"\n"; 
			//System.out.println(newLine);
			newLine = bReader.readLine();
			
			//return newLine; 
		}
		
	} catch (FileNotFoundException e ) {

		e.printStackTrace();
		
	}catch (IOException e){
		
	}
	finally
	{
		return fileText; 
		
	}
}


public static void writeToFile(File myBookFile) {
	PrintWriter wrt = null;
	try {
		wrt = new PrintWriter(myBookFile);

		wrt.println("Anna,Swell,Black Beauty,Checked In");
		wrt.println("Paula,Hawkins,The girl on the train,Checked In");
		wrt.println("Paulo,Coelho,The Alchemist,Checked In");
		wrt.println("author1,lastname,abook,Checked Out");
		

	} catch (FileNotFoundException e) {

		e.printStackTrace();
	} // checked exception
	finally {
		wrt.close();
	}
}

//public static void writeToFileAppend(File myBookFile) {
//	FileWriter wrt = null;
//	try {
//		wrt = new FileWriter(myBookFile,true);
//
//
//		wrt.close();
//		
//
//	} catch (FileNotFoundException e) {
//
//		e.printStackTrace();
//	} 
//	catch(IOException e){
//		
//	}
////	finally {
////		wrt.close();
////	}
//}


}



