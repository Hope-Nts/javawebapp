package model.Beans;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

public class Individual extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName, lastName;
	
	public Individual() {}
	
	public Individual(String id, String fName, String lName,String password, String email, String phoneNumber, String address, String description, InputStream displayPicture ) {
		super(id, password, email, phoneNumber, address, description, displayPicture);
		this.firstName = fName; 
		this.lastName = lName;
	}
	
	///getters and setters
	public void setFirstName(String fName) {
		this.firstName = fName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String lName) {
		this.lastName = lName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
}
