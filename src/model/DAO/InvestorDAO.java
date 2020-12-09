package model.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Beans.Investor;
import model.Beans.LoginToken;

public class InvestorDAO {
	
	DbConnection dbc = new DbConnection();
	Connection con = dbc.getConnection();
	
	public InvestorDAO(){}
	
	//Company login method
	public LoginToken login(String email, String password) {
		String dbId = "";
		LoginToken token =  new LoginToken(dbId, false);
		try {
			PreparedStatement pstmt = con.prepareStatement("select id,email,password from investor");
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
			PreparedStatement pstmt = con.prepareStatement("Select count(*) from investor");
			ResultSet count = pstmt.executeQuery();
			count.next();
			userCount = count.getInt(1);
			userCount += 1;
			if((userCount % 10) > 1) {
				id = "IN00"+ userCount;
			}else if((userCount % 100) > 1) {
				id = "IN0"+ userCount;
			}else if((userCount % 1000) > 1) {
				id = "IN"+ userCount;
			}else {
				id = "IN000"+ userCount;
			}
				System.out.print(id);

			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return id;
		}
	
	//insert Company DB method
	public Boolean insertInvestor(Investor investor){
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement("insert into investor(id, fName, lName, industry, firmName, email, password, phoneNumber, address, description, displayPicture ) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?)");
			pstmt.setString(1, investor.getId());//TO-DO create an id generator
			pstmt.setString(2, investor.getFirstName());
			pstmt.setString(3, investor.getLastName());
			pstmt.setString(4, investor.getIndustry());
			pstmt.setString(5, investor.getFirmName());
			pstmt.setString(6, investor.getEmail());
			pstmt.setString(7, investor.getPassword());
			pstmt.setString(8, investor.getPhoneNumber());
			pstmt.setString(9, investor.getAddress()); 
			pstmt.setString(10,investor.getDescription());
			pstmt.setBlob(11,  investor.getDisplayPicture());
			
			//execute the preparedStatement
			return pstmt.execute();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	//insert Company DB method
		public Boolean updateInvestor(Investor investor){
			
			try {
				
				PreparedStatement pstmt = con.prepareStatement("update investor set fName= ?, lName= ?, industry= ?, firmName= ?, email= ?, password= ?, phoneNumber= ?, address= ?, description= ? where id= ? ");
				pstmt.setString(1, investor.getId());//TO-DO create an id generator
				pstmt.setString(2, investor.getFirstName());
				pstmt.setString(3, investor.getLastName());
				pstmt.setString(4, investor.getIndustry());
				pstmt.setString(5, investor.getFirmName());
				pstmt.setString(6, investor.getEmail());
				pstmt.setString(7, investor.getPassword());
				pstmt.setString(8, investor.getPhoneNumber());
				pstmt.setString(9, investor.getAddress()); 
				pstmt.setString(10,investor.getDescription());
				pstmt.setBlob(11,  investor.getDisplayPicture());
				
				//execute the preparedStatement
				return pstmt.execute();
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			return false;
		}
	//searching advisor method
	public Investor searchAdvisor(String idNo) {
	
		ArrayList<Investor> list = new ArrayList<>();
		
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM investor WHERE id = ?");
			pstmt.setString(1,  idNo);
			String industry, firmName, fName, lName, password, email, phoneNumber,  address, description,id;
			InputStream displayPicture = null;
			
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) {
				id = result.getString(1);
				fName = result.getString(2);
				lName = result.getString(3);
				industry = result.getString(4);
				firmName = result.getString(5);
				email = result.getString(6);
				password = result.getString(7);
				phoneNumber = result.getString(8);
				address = result.getString(9);
				description = result.getString(10);
				displayPicture = (InputStream) result.getBlob(11).getBinaryStream();
				Investor investor = new Investor(id, industry, firmName,
						fName, lName, password, email, phoneNumber, address, description, displayPicture);
				list.add(investor);
			}
			
			//Company foundCompany = (Company)list.get(0);
			return list.get(0);
		}catch(Exception e) {
			return null;
		}
	}
	
	// method returns advisor list to be displayed in the directory
	public ArrayList<Investor> getInvestors(){

		ArrayList<Investor> list = new ArrayList<>();
		String industry, firmName, fName, lName, password, email, phoneNumber,  address, description, id;
		InputStream displayPicture = null;


        try{
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("select * from investor");

            while(result.next()){
            	id = result.getString(1);
            	fName = result.getString(2);
				lName = result.getString(3);
				industry = result.getString(4);
				firmName = result.getString(5);
				email = result.getString(6);
				password = result.getString(7);
				phoneNumber = result.getString(8);
				address = result.getString(9);
				description = result.getString(10);
				displayPicture = result.getBlob(11).getBinaryStream();
				Investor investor = new Investor(id, industry, firmName,
						fName, lName, password, email, phoneNumber, address, description, displayPicture);
				list.add(investor);
            }
            
        }catch(Exception e){     	
            e.printStackTrace();        
        }finally{
            return list;
        }
    }
	
	
}
