package model.Beans;

import java.io.File;
import java.io.Serializable;

public class Company extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String companyName, industry;
	private File portfolio;
	public Company() {}
	
	public Company(String companyName, String industry, File portfolio,String password, String email, String phoneNumber, String address, String description) {
		super(password, email, phoneNumber, address, description);
		this.companyName = companyName;
		this.industry = industry;
		this.portfolio = portfolio;
	}
	
	public Company(String companyName, String industry, String password, String email, String phoneNumber, String address, String description) {
		super(password, email, phoneNumber, address, description);
		this.companyName = companyName;
		this.industry = industry;
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
	
	public void setPortfolio(File portfolio) {
		this.portfolio = portfolio;
	}
	
	public File getPortfolio() {
		return this.portfolio;
	}
}
