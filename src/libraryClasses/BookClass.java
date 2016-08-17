package libraryClasses;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BookClass {

	private String aFirstName;
	private String aLastName;
	private String title;
	private String checkedIn;
	private LocalDate dueDate;
	private String patronFirstName;
	private int bookNumber;

	public BookClass(String firstName, String lastName, String title, String checkedIn, int bookNumber ) {
		setAFirstName(firstName);
		setALastName(lastName);
		setTitle(title);
		setCheckedIn(checkedIn);
		setBookNumber(bookNumber);
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}

	public BookClass(String firstName, String lastName, String title, Boolean checkedIn,
			LocalDate dueDate) {
		setAFirstName(firstName);
		setALastName(lastName);
		setTitle(title);
		setCheckedIn(checkedIn);
		//setPatronFirstName(patronFirstName);
		setDueDate(dueDate);

	}

	public String getPatronFirstName() {
		return patronFirstName;
	}

	public void setPatronFirstName(String patronFirstName) {
		this.patronFirstName = patronFirstName;
	}

	public String getCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(String checkedIn) {
		this.checkedIn = checkedIn;
	}

	public String getAFirstName() {
		return aFirstName;
	}

	public void setAFirstName(String firstName) {
		this.aFirstName = firstName;
	}

	public String getALastName() {
		return aLastName;
	}

	public void setALastName(String lastName) {
		this.aLastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		LocalDate Today = LocalDate.now();
		LocalDate returnDate = Today.plus(2, ChronoUnit.WEEKS);

		this.dueDate = returnDate;
	}

}
