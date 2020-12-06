package model.DAO;

import java.sql.Connection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Beans.Company;
import model.Beans.LoginToken;

public class CompanyDAO {
	
	DbConnection dbc = new DbConnection();
	Connection con = dbc.getConnection();
	
	public CompanyDAO() {}
	
	//Company login method
	public LoginToken login(String email, String password) {
		String dbId = "";
		LoginToken token =  new LoginToken(dbId, false);
		try {
			PreparedStatement pstmt = con.prepareStatement("select id,email,password from company");
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
			PreparedStatement pstmt = con.prepareStatement("Select count(*) from company");
			ResultSet count = pstmt.executeQuery();
			count.next();
			userCount = count.getInt(1);
			userCount += 1;
			if((userCount % 10) > 1) {
				id = "CO00"+ userCount;
			}else if((userCount % 100) > 1) {
				id = "CO0"+ userCount;
			}else if((userCount % 1000) > 1) {
				id = "CO"+ userCount;
			}else {
				id = "CO000"+ userCount;
			}
			System.out.print(id);

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	//insert Company DB method
	public Boolean insertCompany(Company company) throws FileNotFoundException {
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement("insert into company(id, name, industry, email, password, phoneNumber, address, description, portfolio, displayPicture ) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			pstmt.setString(1, company.getId()); // TO-DO id generator
			pstmt.setString(2, company.getCompanyName());
			pstmt.setString(3, company.getIndustry());
			pstmt.setString(4, company.getEmail());
			pstmt.setString(5, company.getPassword());
			pstmt.setString(6, company.getPhoneNumber());
			pstmt.setString(7, company.getAddress());
			pstmt.setString(8, company.getDescription());
			pstmt.setBlob(9, company.getPortfolio());
			pstmt.setBlob(10, company.getDisplayPicture()); 
			
			//execute the preparedStatement
			return pstmt.execute();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	//searching company method
	public Company searchCompany(String name) {
	
		ArrayList<Company> list = new ArrayList<>();
		
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM company WHERE name = ?");
			pstmt.setString(1,  name);
			String username,password, email, phoneNumber, address, description, companyName, industry, id;
			InputStream portfolio = null;
			InputStream displayPicture = null;

			ResultSet result = pstmt.executeQuery();
			
			if(result.next()) {
				id = result.getString(1);
				companyName = result.getString(2);
				industry = result.getString(3);
				email = result.getString(4);
				password = result.getString(5);
				phoneNumber = result.getString(6);
				address = result.getString(7);
				description = result.getString(8);
				portfolio =  result.getBlob(9).getBinaryStream();
				displayPicture = (InputStream) result.getBlob(10).getBinaryStream();
				Company company = new Company(id,companyName,industry, portfolio, password, email, phoneNumber, address, description,displayPicture);
				list.add(company);
			}
			
			//Company foundCompany = (Company)list.get(0);
			return list.get(0);
		}catch(Exception e) {
			return null;
		}
	}
	
	//TO-DO get portfolio method
	/*    public void getPDFData(Connection conn) {
	    
	    byte[] fileBytes;
	    String query;
	    try {
	        query = 
	          "select data from tableimage where filename like '%.pdf%'";
	        Statement state = conn.createStatement();
	        ResultSet rs = state.executeQuery(query);
	        if (rs.next()) {
	            fileBytes = rs.getBytes(1);
	            OutputStream targetFile=  new FileOutputStream(
	                    "d://servlet//jdbc//newtest.pdf");
	            targetFile.write(fileBytes);
	            targetFile.close();
	        }
	         
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    ////////////////////////////////
	    File someFile = new File("java2.pdf");
	    FileOutputStream fos = new FileOutputStream(someFile);
	    fos.write(bytes);
	    fos.flush();
	    fos.close();
	}
	
	
		/////////////
		 * byte[] fileBytes = result.getBytes(8);
					FileOutputStream targetFile=  new FileOutputStream("d://servlet//jdbc//newtest.pdf");
	                targetFile.write(fileBytes);
	                targetFile.close();
	                
	                portfolio = targetFile;
	 * */

	// method returns company list to be displayed in the directory
	public ArrayList<Company> getCompanies(){

        ArrayList<Company> list = new ArrayList<>();
		String username,password, email, phoneNumber, address, description, companyName, industry,id;
		InputStream displayPicture = null;
		InputStream portfolio = null;


        try{
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("select * from company");

            while(result.next()){
            	id = result.getString(1);
            	companyName = result.getString(2);
				industry = result.getString(3);
				email = result.getString(4);
				password = result.getString(5);
				phoneNumber = result.getString(6);
				address = result.getString(7);
				description = result.getString(8);
				portfolio = (InputStream) result.getBlob(9).getBinaryStream();
				displayPicture = (InputStream) result.getBlob(10).getBinaryStream();
				Company company = new Company(id,companyName,industry,portfolio, password, email, phoneNumber, address, description, displayPicture);
				list.add(company);
            }
            
        }catch(Exception e){     	
            e.printStackTrace();        
        }finally{
            return list;
        }
    }
	
}
