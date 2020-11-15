package model.Beans;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Base64;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String password, email, phoneNumber, address, description;
	private String base64DisplayPicture;
	private InputStream displayPicture;
	
	public User() {
		
		this.password = "";
		this.email = "";
		this.phoneNumber ="";
		this.address = "";
		this.description = "";
		this.displayPicture = null;
		this.base64DisplayPicture = "";
	}
	
	//constructor to be inherited by subclasses
	public User(String password, String email, String phoneNumber, String address, String description, InputStream displayPicture) {
		this.password = password;
		this.email = email;
		this.phoneNumber =phoneNumber;
		this.address = address;
		this.description = description;
		this.displayPicture = displayPicture;
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
	
	public InputStream getDisplayPicture() {
		return this.displayPicture;
	}
	
	public void setDisplayPicture(InputStream displayPicture) {
		this.displayPicture = displayPicture;
	}
	
	//method used when displaying the diplay picture in the jstl tag
	public String getStringBase64TypeDisplayPicture() {
		ByteArrayOutputStream outputStream  = new ByteArrayOutputStream();
		byte [] buffer = new byte[4096];
		int bytesRead = -1;
		try {
			while((bytesRead = displayPicture.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			
			byte [] imageBytes = outputStream.toByteArray();
			base64DisplayPicture = Base64.getEncoder().encodeToString(imageBytes);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return base64DisplayPicture;
	}
		
}
