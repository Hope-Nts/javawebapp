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
			PreparedStatement pstmt = con.prepareStatement("select id,email,password from BusinessAdvisor");
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
	
	//insert Company DB method
	public Boolean insertAdvisor(BusinessAdvisor businessAdvisor){
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement("insert into BusinessAdvisor(id,fName, lName, advisorType, status, email, password, phoneNumber, address, description ) "
					+ "VALUES(?,?, ?, ?, ?, ?, ?, ?, ?,?)");
			pstmt.setString(1, "");//TO-DO id generator
			pstmt.setString(2, businessAdvisor.getFirstName());
			pstmt.setString(3, businessAdvisor.getLastName());
			pstmt.setString(4, businessAdvisor.getAdvisorType());
			pstmt.setString(5, businessAdvisor.getEmploymentStatus());
			pstmt.setString(6, businessAdvisor.getEmail());
			pstmt.setString(7, businessAdvisor.getPassword());
			pstmt.setString(8, businessAdvisor.getPhoneNumber());
			pstmt.setString(9, businessAdvisor.getAddress()); 
			pstmt.setString(10,businessAdvisor.getDescription());
			
			//execute the preparedStatement
			return pstmt.execute();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	//searching advisor method
	public ArrayList<BusinessAdvisor>  searchAdvisor(String name) {
	
		ArrayList<BusinessAdvisor> list = new ArrayList<>();
		
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM BusinessAdvisor WHERE name = ?");
			pstmt.setString(1,  name);
			String advisorType, employmentStatus, fName, lName, password, email, phoneNumber, address, description;
			InputStream displayPicture ;
			
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) {
				fName = result.getString(2);
				lName = result.getString(3);
				advisorType = result.getString(4);
				employmentStatus = result.getString(5);
				email = result.getString(6);
				password = result.getString(7);
				phoneNumber = result.getString(8);
				address = result.getString(9);
				description = result.getString(10);
				displayPicture = (InputStream) result.getBlob(11);
				
				BusinessAdvisor advisor = new BusinessAdvisor(advisorType, employmentStatus,
						fName, lName, password, email, phoneNumber, address, description, displayPicture);
				list.add(advisor);
			}
			
			//Company foundCompany = (Company)list.get(0);
			return list;
		}catch(Exception e) {
			return null;
		}
	}
	
	// method returns advisor list to be displayed in the directory
	public ArrayList<BusinessAdvisor> getCompanies(){

		ArrayList<BusinessAdvisor> list = new ArrayList<>();
		String advisorType, employmentStatus, fName, lName, password, email, phoneNumber, address, description;
		InputStream displayPicture = null;


        try{
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("select * from company");

            while(result.next()){
            	fName = result.getString(2);
				lName = result.getString(3);
				advisorType = result.getString(4);
				employmentStatus = result.getString(5);
				email = result.getString(6);
				password = result.getString(7);
				phoneNumber = result.getString(8);
				address = result.getString(9);
				description = result.getString(10);
				displayPicture = (InputStream) result.getBlob(11);
				BusinessAdvisor advisor = new BusinessAdvisor(advisorType, employmentStatus,
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
