package libraryClasses;

public class BookClass {

	private String firstName;
	public BookClass(String firstName, String lastName, String title) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
	}
	private String lastName;
	private String title;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	} 
	
	
}
