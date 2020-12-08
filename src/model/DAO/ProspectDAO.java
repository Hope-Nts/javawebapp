package model.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Beans.Prospect;
import model.Beans.LoginToken;

public class ProspectDAO {
	
	DbConnection dbc = new DbConnection();
	Connection con = dbc.getConnection();
	
	public ProspectDAO(){}
	
	//Company login method
	public LoginToken login(String email, String password) {
		String dbId = "";
		LoginToken token =  new LoginToken(dbId, false);
		try {
			PreparedStatement pstmt = con.prepareStatement("select id,email,password from prospect");
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
			PreparedStatement pstmt = con.prepareStatement("Select count(*) from prospect");
			ResultSet count = pstmt.executeQuery();
			count.next();
			userCount = count.getInt(1);
			userCount += 1;
			if((userCount % 10) > 1) {
				id = "PR00"+ userCount;
			}else if((userCount % 100) > 1) {
				id = "PR0"+ userCount;
			}else if((userCount % 1000) > 1) {
				id = "PR"+ userCount;
			}else {
				id = "PR000"+ userCount;
			}
			System.out.print(id);

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	
	//insert Company DB method
	public Boolean insertProspect(Prospect prospect){
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement("insert into prospect(id, fName, lName, industry, qualification, experience, status, email, password, phoneNumber, address, description, displayPicture ) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, "");//TO-DO create an id generator
			pstmt.setString(2, prospect.getFirstName());
			pstmt.setString(3, prospect.getLastName());
			pstmt.setString(4, prospect.getLevel());
			pstmt.setString(5, prospect.getCurrentQualification());
			pstmt.setString(6, prospect.getObtainedQualification());
			pstmt.setString(7, prospect.getExpectedDateOfCompletion());
			pstmt.setString(8, prospect.getEmail());
			pstmt.setString(9, prospect.getPassword());
			pstmt.setString(10, prospect.getPhoneNumber());
			pstmt.setString(11, prospect.getAddress()); 
			pstmt.setString(12,prospect.getDescription());
			pstmt.setBlob(13, prospect.getDisplayPicture());
			
			//execute the preparedStatement
			return pstmt.execute();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	//searching advisor method
	public Prospect  searchProspect(String idNo) {
	
		ArrayList<Prospect> list = new ArrayList<>();
		
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM prospect WHERE id = ?");
			pstmt.setString(1,  idNo);
			String level, id, currentQualification, obtainedQualification, expectedDateOfCompletion, fName, lName, password, email, phoneNumber, address, description;
			InputStream displayPicture = null;
			
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) {
				id = result.getString(1);
				fName = result.getString(2);
				lName = result.getString(3);
				level = result.getString(4);
				currentQualification = result.getString(5);
				obtainedQualification =result.getString(6);
				expectedDateOfCompletion = result.getString(7);
				email = result.getString(8);
				password = result.getString(9);
				phoneNumber = result.getString(10);
				address = result.getString(11);
				description = result.getString(12);
				displayPicture = (InputStream) result.getBlob(13).getBinaryStream();
				Prospect professional = new Prospect(id, level, currentQualification, obtainedQualification, expectedDateOfCompletion,
						fName, lName, password, email, phoneNumber, address, description, displayPicture);
				list.add(professional);
			}
			
			//Company foundCompany = (Company)list.get(0);
			return list.get(0);
		}catch(Exception e) {
			return null;
		}
	}
	
	// method returns advisor list to be displayed in the directory
	public ArrayList<Prospect> getProspects(){

		ArrayList<Prospect> list = new ArrayList<>();
		String level, id, currentQualification, obtainedQualification, expectedDateOfCompletion, fName, lName, password, email, phoneNumber, address, description;
		InputStream displayPicture = null;

        try{
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("select * from prospect");

            while(result.next()){
            	id = result.getString(1);
            	fName = result.getString(2);
				lName = result.getString(3);
				level = result.getString(4);
				currentQualification = result.getString(5);
				obtainedQualification =result.getString(6);
				expectedDateOfCompletion = result.getString(7);
				email = result.getString(8);
				password = result.getString(9);
				phoneNumber = result.getString(10);
				address = result.getString(11);
				description = result.getString(12);
				displayPicture = (InputStream) result.getBlob(13).getBinaryStream();
				Prospect professional = new Prospect(id,level, currentQualification, obtainedQualification, expectedDateOfCompletion,
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
