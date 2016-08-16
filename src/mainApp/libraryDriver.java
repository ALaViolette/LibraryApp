package mainApp;

import java.util.ArrayList;
import java.util.Scanner;

import libraryClasses.BookArray;
import libraryClasses.BookClass;

public class libraryDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
				"Welcome to the Library Application!\n1. See the list of books in our library.\n2. Search for a book by author.\n3. Search for a book by title.\n4. Check out a book.\n5. Return a book. \nEnter menu number: ");
		Scanner scan1 = new Scanner(System.in);
		int userInput = scan1.nextInt();
		BookArray list = new BookArray();
		ArrayList<BookClass> myList = list.getListofBooks();// Factory DP
		if (userInput == 1) {

			for (int i = 0; i < myList.size(); i++) {
				System.out.println(myList.get(i).getTitle());
			}
		}

		else if (userInput == 2) {
			for (int i = 0; i < myList.size(); i++) {
				System.out.println(myList.get(i).getLastName() + ", " + myList.get(i).getFirstName());
			}
		System.out.println("Enter the last name of the author whose books you would like to see: ");
		String userInput2 = scan1.nextLine();
		
		
		}
		
	}
}
