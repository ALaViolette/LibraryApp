package libraryClasses;

public class PatronClass {
	//constructor
	public PatronClass(String phoneNo, String lastName, String firstName) {
		this.phoneNo = phoneNo;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	private String phoneNo;
	private String lastName;
	private String firstName;
	
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}
