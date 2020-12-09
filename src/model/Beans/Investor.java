package model.Beans;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

public class Investor extends Individual implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String industry, firmName;
	
	public Investor() {}
	
	public Investor(String id, String industry, String firmName,
			String fName, String lName, String password, String email, String phoneNumber, String address, String description, InputStream displayPicture) {
		super(id,fName, lName, password, email, phoneNumber, address, description, displayPicture);		
		this.industry = industry;
		this.firmName = firmName;
	} 
	
	public Investor(String id, String industry, String firmName,
			String fName, String lName, String password, String email, String phoneNumber, String address, String description) {
		super(id,fName, lName, password, email, phoneNumber, address, description);		
		this.industry = industry;
		this.firmName = firmName;
	} 
	
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	public String getIndustry() {
		return this.industry;
	}
	
	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
	
	public String getFirmName() {
		return this.firmName;
	}

}
