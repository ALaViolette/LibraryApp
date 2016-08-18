package mainApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import libraryClasses.BookArray;
import libraryClasses.BookClass;
import libraryClasses.PatronIO;
import libraryClasses.*;

public class libraryDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		boolean authorFound = false;
		String cont = "yes";

		System.out.println("Welcome to the Library Application!");

		while (cont.equalsIgnoreCase("yes") || cont.equalsIgnoreCase("y")) {
			System.out.println(
					"\tMAIN MENU\n1. See the list of books in our library.\n2. Search for a book by author.\n3. Search for a book by title.\n4. "
							+ "Check out a book.\n5. Return a book.\n6. Donate a book \nEnter menu number: ");

			int userInput = scan1.nextInt();
			scan1.nextLine();

			switch (userInput) {
			case 1:

				getBookTitleAndNumber(myList);
				break;

			case 2:

				System.out.println("Enter the last name of the author whose books you would like to see: ");
				String userInput2 = scan1.nextLine();

				for (int i = 0; i < myList.size(); i++) {
					if (userInput2.equalsIgnoreCase(myList.get(i).getALastName())) {
						authorFound = true;
						System.out.println(myList.get(i).getTitle());
					}
				}

				if (authorFound == false) {
					System.out.println("We currently do not have any books by this author");
					break;
				} else {
					System.out.println("Would you like to check it out? (y/n)");
					userChoice = scan1.nextLine();
					if (userChoice.equalsIgnoreCase("y") || userChoice.equalsIgnoreCase("yes")) {
						userInput = 4;
					}
				}

			case 3:
				System.out.println("Enter the title of the book you would like to see: ");
				userChoice = scan1.nextLine();

				for (int i = 0; i < myList.size(); i++) {
					if (myList.get(i).getTitle().toLowerCase().contains(userChoice.toLowerCase())) {
						bookFound = true;
						System.out.println("Our library contains " + myList.get(i).getTitle() + " written by "
								+ myList.get(i).getAFirstName() + " " + myList.get(i).getALastName());

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
				while (checkout.equalsIgnoreCase("y")) {
					checkBookOut(myBookFile, scan1, myList);
					System.out.println("Would you like to check out another book? y/n");
					checkout = scan1.nextLine();
				}
				break;

			case 5:
				String return1 = "y";
				while (return1.equalsIgnoreCase("y")) {
					returnBookOut(myBookFile, scan1, myList);
					System.out.println("Would you like to return another book? y/n");
					return1 = scan1.nextLine();
				}
				break;
			case 6:
				System.out.println("Thank you for donating to the library");
				String donate = "y";
				while (donate.equalsIgnoreCase("y")) {
					donateBook(myBookFile, scan1);
					System.out.println("Would you like to donate another book? y/n");
					donate = scan1.nextLine();
				}
				break;

			}
			System.out.println("Would you like to do another search?");
			cont = scan1.nextLine();
		}
		System.out.println("Goodbye!");
	}

	public static void donateBook(File myBookFile, Scanner scan1) {
		System.out.println("Please input the title");
		String title = scan1.nextLine();
		System.out.println("Please input the Author's First Name");
		String aFirstName = scan1.nextLine();
		System.out.println("Please input the Author's Last Name");
		String aLastName = scan1.nextLine();

		FileWriter wrt = null;
		try {
			wrt = new FileWriter(myBookFile, true);
			wrt.append(aFirstName + "," + aLastName + "," + title + "," + "Checked In");

			wrt.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

		}
	}

	public static void getBookTitleAndNumber(ArrayList<BookClass> myList) {
		for (int i = 0; i < myList.size(); i++) {
			System.out.println("Book number: " + myList.get(i).getBookNumber() + " Title: " + myList.get(i).getTitle());

		}
	}

	public static void checkBookOut(File myBookFile, Scanner scan1, ArrayList<BookClass> myList) {
		LocalDate Today = LocalDate.now();
		System.out.println("Which book would you like to check out? Please enter the Book Number");

		int input = scan1.nextInt();
		scan1.nextLine();

		if (myList.get(input - 1).getCheckedIn().equalsIgnoreCase("Checked In")) {

			System.out.println("You checked out " + myList.get(input - 1).getTitle());
			myList.get(input - 1).setCheckedIn("Checked Out");// changes status
																// in array
			myList.get(input - 1).setDueDate(Today);
			System.out.println("This book is due back: " + myList.get(input - 1).getDueDate());

			rewriteList(myBookFile, myList);
		} else
			System.out.println("This book is checked out until " + myList.get(input - 1).getDueDate());
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
		} finally {
			wrt.close();
		}
	}

	public static void returnBookOut(File myBookFile, Scanner scan1, ArrayList<BookClass> myList) {

		System.out.println("Which book would you like to return? Please enter the Book Number");
		int input = scan1.nextInt();
		scan1.nextLine();

		if (myList.get(input - 1).getCheckedIn().equalsIgnoreCase("Checked Out")) {

			System.out.println(myList.get(input - 1).getTitle() + " is now returned");
			myList.get(input - 1).setCheckedIn("Checked In");// changes status
																// in array

			rewriteList(myBookFile, myList);
		} else
			System.out.println("This book has already been returned");
	}

}
