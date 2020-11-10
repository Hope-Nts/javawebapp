package model.Beans;
import java.io.Serializable;

public class LoginToken {
	private String id;
	private Boolean isLoggedIn;
	
	public LoginToken() {}
	
	public LoginToken(String id, Boolean isLoggedIn) {
		this.id = id; 
		this.isLoggedIn = isLoggedIn;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setLoggedIn(Boolean loggedIn) {
		this.isLoggedIn = loggedIn;
	}
	
	public Boolean isLoggedIn() {
		return this.isLoggedIn;
	}
}
