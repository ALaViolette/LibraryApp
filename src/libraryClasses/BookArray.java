package libraryClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BookArray {

	
	private ArrayList<BookClass> bookList = new ArrayList<>();
	
	public ArrayList<BookClass> getListofBooks()
	
	{ 
		String filetext = Book.readFile();// get the text from the text file
		
		String[] lines = filetext.split("\n"); // split by lines 
		String [] info=null;
		
		for (String str : lines)
		{
			info = str.split(",");// split by , 
			
			BookClass n = new BookClass(info[2],info[1],info[0]);
			
			bookList.add(n);
			
			
		}
		
		return bookList;
	}

	// readFile(myConfigFile);

}
