package model.Beans;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String password, email, phoneNumber, address, description;
	
	public User() {
		
	}
	
	//constructor to be inherited by subclasses
	public User(String password, String email, String phoneNumber, String address, String description) {
		this.password = password;
		this.email = email;
		this.phoneNumber =phoneNumber;
		this.address = address;
		this.description = description;
	}
	
	//getters and setters	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
