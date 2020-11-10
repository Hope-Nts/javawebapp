package model.Beans;
import java.io.Serializable;

public class Professional extends Individual implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String experience, qualifications, industry, employmentStatus;
	
	public Professional() {}

	public Professional(String experience, String qualifications, String industry, String employmentStatus,
			String fName, String lName, String password, String email, String phoneNumber, String address, String description) {
		super(fName, lName, password, email, phoneNumber, address, description);		
		
		this.experience = experience;
		this.qualifications = qualifications;
		this.industry = industry;
		this.employmentStatus = employmentStatus;
	}
	
	//////////////////////////////////////
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	public String getExperience() {
		return this.experience;
	}
	//////////////////////////////////////
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	
	public String getQualifications() {
		return this.qualifications;
	}
	//////////////////////////////////////
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	public String getIndustry() {
		return this.industry;
	}
	//////////////////////////////////////
	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	
	public String getEmploymentStatus() {
		return this.employmentStatus;
	}

}
