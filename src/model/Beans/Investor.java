package model.Beans;

import java.io.Serializable;

public class Investor extends User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String industry, firmName;
	
	public Investor() {}
	
	public Investor(String industry, String firmName,
			String username, String password, String email, String phoneNumber, String address, String description) {
		super(username, password, email, phoneNumber, address, description);
		
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
