package model.Beans;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Base64;

public class Company extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String companyName, industry, base64portfolio, id;
	private InputStream portfolio;
	public Company() {}
		
	public Company(String id, String companyName, String industry, InputStream portfolio,String password, String email, String phoneNumber, String address, String description, InputStream displayPicture) {
		super(id, password, email, phoneNumber, address, description, displayPicture);
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
	
	public void setPortfolio(InputStream portfolio) {
		this.portfolio = portfolio;
	}
	
	public InputStream getPortfolio() {
		return this.portfolio;
	}
	
	//method used when displaying the diplay picture in the jstl tag
		public String getStringBase64TypePortfolio() {
			ByteArrayOutputStream outputStream  = new ByteArrayOutputStream();
			byte [] buffer = new byte[4096];
			int bytesRead = -1;
			try {
				while((bytesRead = portfolio.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				
				byte [] imageBytes = outputStream.toByteArray();
				base64portfolio = Base64.getEncoder().encodeToString(imageBytes);
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return base64portfolio;
		}
}
