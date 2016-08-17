package mainApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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

		// Path filePath = Paths.get("Patron.txt");
		// File myPatronFile = filePath.toFile();
		// PatronIO p1 = new PatronIO();
		// p1.writeToFile(myPatronFile);
		// p1.readFile(myPatronFile);
		Path filePath = Paths.get("Book.txt");
		File myBookFile = filePath.toFile();
		Scanner scan1 = new Scanner(System.in);
		BookArray list = new BookArray();
		String userChoice = "";
		ArrayList<BookClass> myList = list.getListofBooks();// Factory DP
		boolean bookFound = false;
		
		System.out.println(
				"Welcome to the Library Application!\n1. See the list of books in our library.\n2. Search for a book by author.\n3. Search for a book by title.\n4. Check out a book.\n5. Return a book. \nEnter menu number: ");
		
		int userInput = scan1.nextInt();
		scan1.nextLine();


		switch (userInput) {
		case 0:
			System.out.println(
					"Welcome to the Library Application!\n1. See the list of books in our library.\n2. Search for a book by author.\n3. Search for a book by title.\n4. Check out a book.\n5. Return a book. \nEnter menu number: ");
			userInput = scan1.nextInt();
			scan1.nextLine();
			
		case 1:

			for (int i = 0; i < myList.size(); i++) {
					System.out.println(
							"Book number: " + myList.get(i).getBookNumber() + " Title: " + myList.get(i).getTitle());
				
			}
			break;

		case 2:
			for (int i = 0; i < myList.size(); i++) {
				System.out.println(myList.get(i).getALastName() + ", " + myList.get(i).getAFirstName());
			}
			System.out.println("Enter the last name of the author whose books you would like to see: ");
			String userInput2 = scan1.nextLine();

			for (int i = 0; i < myList.size(); i++) {
				if (userInput2.equalsIgnoreCase(myList.get(i).getALastName())) {

					System.out.println(myList.get(i).getTitle());
				}
				
			}
			break;

		case 3:
			System.out.println("Enter the book you would like to see: ");
			userChoice = scan1.nextLine();

			for (int i = 0; i < myList.size(); i++) {
				if (myList.get(i).getTitle().toLowerCase().contains(userChoice.toLowerCase())) {
					bookFound = true;
					System.out.println("Our library contains " + myList.get(i).getTitle() + " written by "
							+ myList.get(i).getAFirstName() + " " + myList.get(i).getALastName());
					//
				}
			}
			if (bookFound == false) {
				System.out.println("We do not have that book");
				} else {
				System.out.println("Would you like to check it out? (y/n)");
				userChoice = scan1.nextLine();
				if (userChoice.equalsIgnoreCase("y")) {
					userInput = 4;
				} else {
					userInput = 0;
					break;
			
				}
			}
			

		case 4:
			String checkout = "y";
			while(checkout.equalsIgnoreCase("y")){
			checkBookOut(myBookFile, scan1, myList);
			System.out.println("Would you like to check out another book? y/n");
			checkout=scan1.nextLine();}
		
		case 5:
			String return1 = "y";
			while(return1.equalsIgnoreCase("y")){
			returnBookOut(myBookFile, scan1, myList);
			System.out.println("Would you like to check out another book? y/n");
			return1=scan1.nextLine();}
		
		}

			
			}


	public static void checkBookOut(File myBookFile, Scanner scan1, ArrayList<BookClass> myList) {
		
		System.out.println("Which book would you like to check out? Please enter the Book Number");
		int input = scan1.nextInt();
		scan1.nextLine();

		if (myList.get(input - 1).getCheckedIn().equalsIgnoreCase("Checked In")) {

			System.out.println("You checked out "+ myList.get(input - 1).getTitle());
			myList.get(input - 1).setCheckedIn("Checked Out");// changes status in array
		
			rewriteList(myBookFile, myList);
		}
		else
			System.out.println("This book is checked out");
	}

	
	public static void rewriteList(File myBookFile, ArrayList<BookClass> myList) {
		PrintWriter wrt = null;
		try {
			wrt = new PrintWriter(myBookFile);
			for (int i = 0; i < myList.size(); i++) {
				wrt.print(myList.get(i).getAFirstName() + ",");
				wrt.print(myList.get(i).getALastName() + ",");
				wrt.print(myList.get(i).getTitle() + ",");
				wrt.println(myList.get(i).getCheckedIn());
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} 
		finally {
			wrt.close();
		}
	}

	
public static void returnBookOut(File myBookFile, Scanner scan1, ArrayList<BookClass> myList) {
		
		System.out.println("Which book would you like to return? Please enter the Book Number");
		int input = scan1.nextInt();
		scan1.nextLine();

		if (myList.get(input - 1).getCheckedIn().equalsIgnoreCase("Checked Out")) {

			System.out.println("This book is now returned");
			myList.get(input - 1).setCheckedIn("Checked In");// changes status in array
		
			rewriteList(myBookFile, myList);
		}
		else
			System.out.println("This book has already been returned");
	}

	
		}
// else if (userInput == 4) {
// System.out.println("4! great.");
	
