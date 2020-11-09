package model.Beans;

import java.io.Serializable;

public class Company extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String companyName, industry, portfolio;
	public Company() {}
	
	public Company(String companyName, String industry, String portfolio, String username, String password, String email, String phoneNumber, String address, String description) {
		super(username, password, email, phoneNumber, address, description);
		this.companyName = companyName;
		this.industry = industry;
		this.portfolio = portfolio;
	}
	
	//getters and setters;
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getCompanyName() {
		return this.companyName;
	}
	
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	public String getIndustry() {
		return this.industry;
	}
	
	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}
	
	public String getPortfolio() {
		return this.portfolio;
	}
}
