package mainApp;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import libraryClasses.BookArray;
import libraryClasses.BookClass;
import libraryClasses.PatronIO;
import libraryClasses.*;

public class libraryDriver {

	public static void main(String[] args) {
	
//		Path filePath = Paths.get("Patron.txt");
//		File myPatronFile = filePath.toFile();
//		PatronIO p1 = new PatronIO();
//		p1.writeToFile(myPatronFile);
//		p1.readFile(myPatronFile);
		
		
		System.out.println(
				"Welcome to the Library Application!\n1. See the list of books in our library.\n2. Search for a book by author.\n3. Search for a book by title.\n4. Check out a book.\n5. Return a book. \nEnter menu number: ");
		Scanner scan1 = new Scanner(System.in);
		int userInput = scan1.nextInt();
		BookArray list = new BookArray();
		String userChoice = "";
		ArrayList<BookClass> myList = list.getListofBooks();// Factory DP
		boolean bookFound = false;
		
		switch (userInput) {
		case 1:

			for (int i = 0; i < myList.size(); i++) {
				System.out.println(myList.get(i).getTitle());
			}
			break;
			//CASE 15
//			System.out.println("Do you want to check out a book?");
//			userChoice = scan1.nextLine();
//			if (userChoice.equalsIgnoreCase("yes")) {
//				userInput = 4;
//			} else if (userChoice.equalsIgnoreCase("no")) {
//				userInput = 0;
//			}

		case 2: 
			for (int i = 0; i < myList.size(); i++) {
				System.out.println(myList.get(i).getLastName() + ", " + myList.get(i).getFirstName());
			}
			System.out.println("Enter the last name of the author whose books you would like to see: ");
			scan1.nextLine();
			String userInput2 = scan1.nextLine();

			for (int i = 0; i < myList.size(); i++) {
				if (userInput2.equalsIgnoreCase(myList.get(i).getLastName())) {

					System.out.println(myList.get(i).getTitle());
				}
				//case 15:
			}
			break;
	
		case 3: 
			System.out.println("Enter the book you would like to see: ");
			scan1.nextLine();
			userChoice = scan1.nextLine();

			for (int i = 0; i < myList.size(); i++) {
				if (myList.get(i).getTitle().toLowerCase().contains(userChoice.toLowerCase())) {
					bookFound = true;
					System.out.println("Our library contains " + myList.get(i).getTitle() +" written by " + myList.get(i).getFirstName() + " " + myList.get(i).getLastName());
//				
					}
			}
			if(bookFound==false)
				System.out.println("We do not have that book");
//			else
				System.out.println("Would you like to check it out?");
		
		case 4:
			
		}
		//else if (userInput == 4) {
		//	System.out.println("4! great.");
		}
	
	}

