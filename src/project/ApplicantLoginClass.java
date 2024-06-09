package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApplicantLoginClass {
	private String UserName;
	private int MobilNumber;
	private String E_mail;
	private String Password;
	
	public ApplicantLoginClass() {
		this.UserName=UserName;
		this.MobilNumber=MobilNumber;
		this.E_mail  = E_mail;
		this.Password=Password;
		
	}
	
	
	//Applicant create Acoount for login 
	public boolean CreateAccount(String userName2, int i, String e_mail2, String password2) {
		// TODO Auto-generated method stub
		//database connection
		DbConnectionClass ob = new DbConnectionClass();
		Connection Conn = ob.DbConnection();
		
		try {
		       Statement stmt = Conn.createStatement();
		        String query = "INSERT INTO CreateAccount (UserName, MobilNumber,E_mail,Password) VALUES ('" + userName2 + "',"+i+",'"+e_mail2+"', '" + password2 + "')";
		        stmt.execute(query);
		        System.out.println("successfully insert");

		        
		    }
		    catch(SQLException e){
		         System.err.println("SQLExseption:"+e.getMessage());
		        System.out.println("insert Faild");
		    }
		return true;
	}


	
	//using Create Account Login to system
	public boolean applicantsignin(String userName2, String password2) {
		// TODO Auto-generated method stub
		//database connection
				DbConnectionClass ob = new DbConnectionClass();
				Connection Conn = ob.DbConnection();
					
					
				try {
					
					 String query = "SELECT * FROM CreateAccount WHERE UserName=? AND Password=?";
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
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
