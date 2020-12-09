package model.DAO;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Beans.BusinessAdvisor;
import model.Beans.LoginToken;

public class BusinessAdvisorDAO {
	
	DbConnection dbc = new DbConnection();
	Connection con = dbc.getConnection();
	
	public BusinessAdvisorDAO(){}
	
	//Company login method
	public LoginToken login(String email, String password) {
		String dbId = "";
		LoginToken token =  new LoginToken(dbId, false);
		try {
			PreparedStatement pstmt = con.prepareStatement("select id,email,password from advisor");
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) {
				dbId = result.getString(1);
				String dbEmail = result.getString(2);
				String dbPassword = result.getString(3);
				if(dbEmail.equals(email) && dbPassword.equals(password)) {
					token = new LoginToken(dbId, true);
					break;
				}else {
					token = new LoginToken(dbId, false);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return token;
	}
	
	//getting a count of objects in the database
	public String createId() {
		int userCount = 0;
		String id = "";
		try {
			PreparedStatement pstmt = con.prepareStatement("Select count(*) from advisor");
			ResultSet count = pstmt.executeQuery();
			count.next();
			userCount = count.getInt(1);
			userCount += 1;
			if((userCount % 10) > 1) {
				id = "BI00"+ userCount;
			}else if((userCount % 100) > 1) {
				id = "BI0"+ userCount;
			}else if((userCount % 1000) > 1) {
				id = "BI"+ userCount;
			}else {
				id = "BI000"+ userCount;
			}
			System.out.print(id);

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}
		
	//insert Company DB method
	public Boolean insertAdvisor(BusinessAdvisor businessAdvisor){
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement("insert into advisor(id,fName, lName, advisorType, status, email, password, phoneNumber, address, description, displayPicture) "
					+ "VALUES(?,?, ?, ?, ?, ?, ?, ?, ?,?, ?)");
			pstmt.setString(1, businessAdvisor.getId());//TO-DO id generator
			pstmt.setString(2, businessAdvisor.getFirstName());
			pstmt.setString(3, businessAdvisor.getLastName());
			pstmt.setString(4, businessAdvisor.getAdvisorType());
			pstmt.setString(5, businessAdvisor.getEmploymentStatus());
			pstmt.setString(6, businessAdvisor.getEmail());
			pstmt.setString(7, businessAdvisor.getPassword());
			pstmt.setString(8, businessAdvisor.getPhoneNumber());
			pstmt.setString(9, businessAdvisor.getAddress()); 
			pstmt.setString(10,businessAdvisor.getDescription());
			pstmt.setBlob(11, businessAdvisor.getDisplayPicture());
			//execute the preparedStatement
			return pstmt.execute();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	//searching advisor method
	public BusinessAdvisor searchAdvisor(String idNo) {
	
		ArrayList<BusinessAdvisor> list = new ArrayList<>();
		
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM advisor WHERE id = ?");
			pstmt.setString(1,  idNo);
			String advisorType, employmentStatus, fName, lName, password, email, phoneNumber, address, description,id;
			InputStream displayPicture ;
			
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) {
				id = result.getString(1);
				fName = result.getString(2);
				lName = result.getString(3);
				advisorType = result.getString(4);
				employmentStatus = result.getString(5);
				email = result.getString(6);
				password = result.getString(7);
				phoneNumber = result.getString(8);
				address = result.getString(9);
				description = result.getString(10);
				displayPicture = (InputStream) result.getBlob(11).getBinaryStream();
				
				BusinessAdvisor advisor = new BusinessAdvisor(id, advisorType, employmentStatus,
						fName, lName, password, email, phoneNumber, address, description, displayPicture);
				list.add(advisor);
			}
			
			//Company foundCompany = (Company)list.get(0);
			return list.get(0);
		}catch(Exception e) {
			return null;
		}
	}
	
	// method returns advisor list to be displayed in the directory
	public ArrayList<BusinessAdvisor> getAdvisors(){

		ArrayList<BusinessAdvisor> list = new ArrayList<>();
		String advisorType, employmentStatus, fName, lName, password, email, phoneNumber, address, description, id;
		InputStream displayPicture = null;


        try{
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("select * from advisor");

            while(result.next()){
            	id = result.getString(1);
            	fName = result.getString(2);
				lName = result.getString(3);
				advisorType = result.getString(4);
				employmentStatus = result.getString(5);
				email = result.getString(6);
				password = result.getString(7);
				phoneNumber = result.getString(8);
				address = result.getString(9);
				description = result.getString(10);
				displayPicture = (InputStream) result.getBlob(11).getBinaryStream();
				BusinessAdvisor advisor = new BusinessAdvisor(id,advisorType, employmentStatus,
						fName, lName, password, email, phoneNumber, address, description,displayPicture);
				list.add(advisor);
            }
            
        }catch(Exception e){     	
            e.printStackTrace();        
        }finally{
            return list;
        }
    }
	
	
}
