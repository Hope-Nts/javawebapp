package model.Beans;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

public class Prospect extends Individual implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//TO-DO change the expectedDateOfCompletion to date type
	private String level, currentQualification, obtainedQualification, expectedDateOfCompletion;
	
	public Prospect() {}
	
	public Prospect(String id, String level, String currentQualification, String obtainedQualification, String expectedDateOfCompletion,
			String fName, String lName, String password, String email, String phoneNumber, String address, String description, InputStream displayPicture) {
		super(id, fName, lName, password, email, phoneNumber, address, description, displayPicture);		
		
		this.level = level;
		this.currentQualification = currentQualification;
		this.obtainedQualification = obtainedQualification;
		this.expectedDateOfCompletion = expectedDateOfCompletion;
	}
	
	public Prospect(String id, String level, String currentQualification, String obtainedQualification, String expectedDateOfCompletion,
			String fName, String lName, String password, String email, String phoneNumber, String address, String description) {
		super(id, fName, lName, password, email, phoneNumber, address, description);		
		
		this.level = level;
		this.currentQualification = currentQualification;
		this.obtainedQualification = obtainedQualification;
		this.expectedDateOfCompletion = expectedDateOfCompletion;
	}
	
	//getters and setters
	/////////////////////////////////////
	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getLevel() {
		return this.level ;
	}
	/////////////////////////////////////
	public void setCurrentQualification(String currentQualification ) {
		this.currentQualification = currentQualification;
	}
	
	public String getCurrentQualification() {
		return this.currentQualification ;
	}
	/////////////////////////////////////
	public void setExpectedDateOfCompletion(String expectedDateOfCompletion) {
		this.expectedDateOfCompletion = expectedDateOfCompletion;
	}
	
	public String getExpectedDateOfCompletion() {
		return this.expectedDateOfCompletion ;
	}
	/////////////////////////////////////
	public void setObtainedQualification(String obtainedQualification) {
		this.obtainedQualification = obtainedQualification;
	}
	
	public String getObtainedQualification() {
		return this.obtainedQualification;
	}
	
}
