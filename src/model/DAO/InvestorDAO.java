package model.DAO;

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
			PreparedStatement pstmt = con.prepareStatement("select id,email,password from Investor");
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
	public Boolean insertInvestor(Investor investor){
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement("insert into Investor(id, fName, lName, industry, firmName, email, password, phoneNumber, address, description ) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
			pstmt.setString(1, "");//TO-DO create an id generator
			pstmt.setString(2, investor.getFirstName());
			pstmt.setString(3, investor.getLastName());
			pstmt.setString(4, investor.getIndustry());
			pstmt.setString(5, investor.getFirmName());
			pstmt.setString(6, investor.getEmail());
			pstmt.setString(7, investor.getPassword());
			pstmt.setString(8, investor.getPhoneNumber());
			pstmt.setString(9, investor.getAddress()); 
			pstmt.setString(10,investor.getDescription());
			
			//execute the preparedStatement
			return pstmt.execute();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	//searching advisor method
	public ArrayList<Investor>  searchAdvisor(String name) {
	
		ArrayList<Investor> list = new ArrayList<>();
		
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM BusinessAdvisor WHERE name = ?");
			pstmt.setString(1,  name);
			String industry, firmName, fName, lName, password, email, phoneNumber,  address, description;
			String displayPicture = "";
			
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) {
				fName = result.getString(2);
				lName = result.getString(3);
				industry = result.getString(4);
				firmName = result.getString(5);
				email = result.getString(6);
				password = result.getString(7);
				phoneNumber = result.getString(8);
				address = result.getString(9);
				description = result.getString(10);
				Investor investor = new Investor(industry, firmName,
						fName, lName, password, email, phoneNumber, address, description, displayPicture);
				list.add(investor);
			}
			
			//Company foundCompany = (Company)list.get(0);
			return list;
		}catch(Exception e) {
			return null;
		}
	}
	
	// method returns advisor list to be displayed in the directory
	public ArrayList<Investor> getCompanies(){

		ArrayList<Investor> list = new ArrayList<>();
		String industry, firmName, fName, lName, password, email, phoneNumber,  address, description;
		String displayPicture = "";


        try{
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("select * from investor");

            while(result.next()){
            	fName = result.getString(2);
				lName = result.getString(3);
				industry = result.getString(4);
				firmName = result.getString(5);
				email = result.getString(6);
				password = result.getString(7);
				phoneNumber = result.getString(8);
				address = result.getString(9);
				description = result.getString(10);
				Investor investor = new Investor(industry, firmName,
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
