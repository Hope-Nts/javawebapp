package model.Beans;
import java.io.Serializable;

public class Prospect extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String level, currentQualification, obtainedQualification, expectedDateOfCompletion;
	
	public Prospect() {}
	
	public Prospect(String level, String currentQualification, String obtainedQualification, String expectedDateOfCompletion,
			String username, String password, String email, String phoneNumber, String address, String description) {
		super(username, password, email, phoneNumber, address, description);
		
		this.level = level;
		this.currentQualification = currentQualification;
		this.expectedDateOfCompletion = expectedDateOfCompletion;
		if(obtainedQualification.equals("NA")) {
			this.currentQualification = "";
		}
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
		return this.obtainedQualification ;
	}
	
}
