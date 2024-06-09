package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminLoginClass {
	private String UserName;
	private String Password;
	
	public AdminLoginClass() {
		this.UserName=UserName;
		this.Password=Password;
	}

	
	//admin signin 
	public boolean signinAdmin(String userName2, String password2) {
		// TODO Auto-generated method stub
		//database connection
		DbConnectionClass ob = new DbConnectionClass();
		Connection Conn = ob.DbConnection();
			
			
		try {
			
			 String query = "SELECT * FROM AdminUser WHERE UserName=? AND Password=?";
			 PreparedStatement pst = Conn.prepareStatement(query);
	         pst.setString(1, userName2);
	         pst.setString(2, password2);

	         ResultSet rs = pst.executeQuery();
	         System.out.println("Executed success");
	         return rs.next(); // Returns true if a row is found (valid credentials)
	        
	     } catch (SQLException e) {
	    	 System.err.println("SQLExseption:"+e.getMessage());
		        System.out.println("INPUT FAILD");
		        
	     } 
		return true;
	}

}
