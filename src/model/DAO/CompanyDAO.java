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

import model.Beans.Company;
import model.Beans.LoginToken;

public class CompanyDAO {
	
	DbConnection dbc = new DbConnection();
	Connection con = dbc.getConnection();
	
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
	
	//insert Company DB method
	public Boolean insertCompany(Company company) throws FileNotFoundException {
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement("insert into company(name, industry, email, password, phone, address, description, portfolio ) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
			
			File portfolio = company.getPortfolio(); //getting the portfolio of file type
			int fileLength = (int)portfolio.length(); //getting the length of the file for the inputStream
			FileInputStream fileInputStream = new FileInputStream(portfolio); //used for reading byte-oriented data (streams of raw bytes) such as image data
			
			pstmt.setString(1, company.getCompanyName());
			pstmt.setString(2, company.getIndustry());
			pstmt.setString(3, company.getEmail());
			pstmt.setString(4, company.getPassword());
			pstmt.setString(5, company.getPhoneNumber());
			pstmt.setString(6, company.getAddress());
			pstmt.setString(7, company.getDescription());
			pstmt.setBinaryStream(8, fileInputStream, fileLength); 
			
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
			String username,password, email, phoneNumber, address, description, companyName, industry;
			File portfolio;

			ResultSet result = pstmt.executeQuery();
			
			if(result.next()) {
				companyName = result.getString(1);
				industry = result.getString(2);
				email = result.getString(3);
				password = result.getString(4);
				phoneNumber = result.getString(5);
				address = result.getString(6);
				description = result.getString(7);
				Company company = new Company(companyName,industry,password, email, phoneNumber, address, description);
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
		String username,password, email, phoneNumber, address, description, companyName, industry;


        try{
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("select * from company");

            while(result.next()){
            	companyName = result.getString(1);
				industry = result.getString(2);
				email = result.getString(3);
				password = result.getString(4);
				phoneNumber = result.getString(5);
				address = result.getString(6);
				description = result.getString(7);
				Company company = new Company(companyName,industry,password, email, phoneNumber, address, description);
				list.add(company);
            }
            
        }catch(Exception e){     	
            e.printStackTrace();        
        }finally{
            return list;
        }
    }
}
