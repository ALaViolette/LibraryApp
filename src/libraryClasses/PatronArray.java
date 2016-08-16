package libraryClasses;

import java.util.ArrayList;

public class PatronArray {
	
private ArrayList<ArrayClass> patronList = new ArrayList<>();
	
	public ArrayList<ArrayClass> getListofPatrons()
	
	{ 
		String filetext = PatronIO.readFile();// get the text from the text file
		String[] lines = filetext.split("\n"); // split by lines 
		String [] info=null;
		
		for (String str : lines)
		{
			info = str.split(",");// split by , 
			PatronClass n = new PatronClass(info[0],info[1],info[2]);
			patronList.add(n);
		}
		return patronList;
	}

	// readFile(myConfigFile);

}
