package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionClass {
	private String username;
	private String password;
	private String hostname;
	private String dbname;
	
	
	public DbConnectionClass() {
		this.username="root";
		this.password="1234";
		this.hostname="localhost";
		this.dbname="Paport_System";
		
	}
	
	
	public Connection DbConnection() {
		Connection Conn= null;
		try{
		    
		    Conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Paport_System","root","1234");
		        System.out.println("connection done");
		        return Conn;
		    }
		    catch( SQLException e){
		    	System.err.println("SQLExseption:"+e.getMessage());
		        System.out.println("connection Faild");
		        return Conn;
		    }
		
	}

}
