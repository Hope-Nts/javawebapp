package model.DAO;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;



public class DbConnection {
	Connection conn  = null;
	
	//TO-DO change the database pointer
	String url = "jdbc:mysql://localhost:3306/francistowndigitalcity?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	//
	public Connection getConnection() {
		System.out.println("Test Connection");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "");
			System.out.println("Driver loaded");
		} catch (ClassNotFoundException | SQLException e){
			// TODO  Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public void Close() {
		try{
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
