package model.Beans;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

public class BusinessAdvisor extends Individual implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String advisorType, employmentStatus;
	
	public BusinessAdvisor() {}
	
	public BusinessAdvisor(String id,String advisorType, String employmentStatus,
			String fName, String lName, String password, String email, String phoneNumber, String address, String description,InputStream displayPicture) {
		super(id,fName, lName, password, email, phoneNumber, address, description, displayPicture);
		
		this.advisorType = advisorType;
		this.employmentStatus = employmentStatus;
		
	} 
	
	public void setAdvisorType(String advisorType) {
		this.advisorType = advisorType;
	}
	
	public String getAdvisorType() {
		return this.advisorType;
	}
	
	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	
	public String getEmploymentStatus() {
		return this.employmentStatus;
	}

}
