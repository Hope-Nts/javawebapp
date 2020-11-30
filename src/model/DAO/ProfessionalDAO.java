package model.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Beans.Professional;
import model.Beans.LoginToken;

public class ProfessionalDAO {
	
	DbConnection dbc = new DbConnection();
	Connection con = dbc.getConnection();
	
	public ProfessionalDAO(){}
	
	//Company login method
	public LoginToken login(String email, String password) {
		String dbId = "";
		LoginToken token =  new LoginToken(dbId, false);
		try {
			PreparedStatement pstmt = con.prepareStatement("select id,email,password from Professional");
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
			PreparedStatement pstmt = con.prepareStatement("Select count(*) from professional");
			ResultSet count = pstmt.executeQuery();
			count.next();
			userCount = count.getInt(1);
			userCount += 1;
			if((userCount % 10) > 1) {
				id = "PF00"+ userCount;
			}else if((userCount % 100) > 1) {
				id = "PF0"+ userCount;
			}else if((userCount % 1000) > 1) {
				id = "PF"+ userCount;
			}else {
				id = "PF000"+ userCount;
			}
			System.out.print(id);

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	
	//insert Company DB method
	public Boolean insertProfessional(Professional professional){
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement("insert into Professional(id, fName, lName, industry, qualification, experience, status, email, password, phoneNumber, address, description, displayPicture ) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, "");//TO-DO create an id generator
			pstmt.setString(2, professional.getFirstName());
			pstmt.setString(3, professional.getLastName());
			pstmt.setString(4, professional.getIndustry());
			pstmt.setString(5, professional.getQualifications());
			pstmt.setString(6, professional.getExperience());
			pstmt.setString(7, professional.getEmploymentStatus());
			pstmt.setString(8, professional.getEmail());
			pstmt.setString(9, professional.getPassword());
			pstmt.setString(10, professional.getPhoneNumber());
			pstmt.setString(11, professional.getAddress()); 
			pstmt.setString(12,professional.getDescription());
			pstmt.setBlob(13, professional.getDisplayPicture());
			
			//execute the preparedStatement
			return pstmt.execute();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	//searching advisor method
	public ArrayList<Professional>  searchProffesional(String name) {
	
		ArrayList<Professional> list = new ArrayList<>();
		
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Professional WHERE name = ?");
			pstmt.setString(1,  name);
			String experience, qualifications, industry, employmentStatus, fName, lName, password, email, phoneNumber, address, description, id;
			InputStream displayPicture = null;
			
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) {
				id = result.getString(1);
				fName = result.getString(2);
				lName = result.getString(3);
				industry = result.getString(4);
				qualifications = result.getString(5);
				experience =result.getString(6);
				employmentStatus = result.getString(7);
				email = result.getString(8);
				password = result.getString(9);
				phoneNumber = result.getString(10);
				address = result.getString(11);
				description = result.getString(12);
				displayPicture = (InputStream) result.getBlob(13);
				Professional professional = new Professional(id, experience, qualifications, industry, employmentStatus,
						fName, lName, password, email, phoneNumber, address, description, displayPicture);
				list.add(professional);
			}
			
			//Company foundCompany = (Company)list.get(0);
			return list;
		}catch(Exception e) {
			return null;
		}
	}
	
	// method returns advisor list to be displayed in the directory
	public ArrayList<Professional> getCompanies(){

		ArrayList<Professional> list = new ArrayList<>();
		String experience, qualifications, industry, employmentStatus, fName, lName, password, email, phoneNumber, address, description,id;
		InputStream displayPicture = null;

        try{
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("select * from Professional");

            while(result.next()){
            	id = result.getString(1);
            	fName = result.getString(2);
				lName = result.getString(3);
				industry = result.getString(4);
				qualifications = result.getString(5);
				experience =result.getString(6);
				employmentStatus = result.getString(7);
				email = result.getString(8);
				password = result.getString(9);
				phoneNumber = result.getString(10);
				address = result.getString(11);
				description = result.getString(12);
				displayPicture = (InputStream) result.getBlob(13);
				Professional professional = new Professional(id,experience, qualifications, industry, employmentStatus,
						fName, lName, password, email, phoneNumber, address, description, displayPicture);
				list.add(professional);
            }
            
        }catch(Exception e){     	
            e.printStackTrace();        
        }finally{
            return list;
        }
    }
	
	
}
