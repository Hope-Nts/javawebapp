package model.Beans;

import java.io.Serializable;

public class BusinessAdvisor extends User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String advisorType, employmentStatus;
	
	public BusinessAdvisor() {}
	
	public BusinessAdvisor(String advisorType, String employmentStatus,
			String username, String password, String email, String phoneNumber, String address, String description) {
		super(username, password, email, phoneNumber, address, description);
		
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
