package model.DAO;

import java.sql.Connection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
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
			
			PreparedStatement pstmt = con.prepareStatement("insert into BusinessAdvisor(fName, lName, adisorType, status, email, password, phoneNumber, address, description ) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?,?)");
			pstmt.setString(1, businessAdvisor.getFirstName());
			pstmt.setString(2, businessAdvisor.getLastName());
			pstmt.setString(3, businessAdvisor.getAdvisorType());
			pstmt.setString(4, businessAdvisor.getEmploymentStatus());
			pstmt.setString(5, businessAdvisor.getEmail());
			pstmt.setString(6, businessAdvisor.getPassword());
			pstmt.setString(7, businessAdvisor.getPhoneNumber());
			pstmt.setString(8, businessAdvisor.getAddress()); 
			pstmt.setString(9,businessAdvisor.getDescription());
			
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
			
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) {
				fName = result.getString(1);
				lName = result.getString(2);
				advisorType = result.getString(3);
				employmentStatus = result.getString(4);
				email = result.getString(5);
				password = result.getString(6);
				phoneNumber = result.getString(7);
				address = result.getString(8);
				description = result.getString(9);
				BusinessAdvisor advisor = new BusinessAdvisor(advisorType, employmentStatus,
						fName, lName, password, email, phoneNumber, address, description);
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


        try{
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("select * from company");

            while(result.next()){
            	fName = result.getString(1);
				lName = result.getString(2);
				advisorType = result.getString(3);
				employmentStatus = result.getString(4);
				email = result.getString(5);
				password = result.getString(6);
				phoneNumber = result.getString(7);
				address = result.getString(8);
				description = result.getString(9);
				BusinessAdvisor advisor = new BusinessAdvisor(advisorType, employmentStatus,
						fName, lName, password, email, phoneNumber, address, description);
				list.add(advisor);
            }
            
        }catch(Exception e){     	
            e.printStackTrace();        
        }finally{
            return list;
        }
    }
	
	
}
