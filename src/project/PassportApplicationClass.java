package project;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PassportApplicationClass {
	
	private String UserFullName;
	private String DateOfBirth;
	private String Gender;
	private String NICNumber;
	private String Address;
	private int MobilNumber;
	private String E_mail;
	private String PoliceLocation;
	private int Postalcode;
	private String DoCumentVerifingDate;
	private Object textFieldPassportID;
	
	
	public PassportApplicationClass() {
		this.UserFullName=UserFullName;
		this.DateOfBirth=DateOfBirth;
		this.Gender=Gender;
		this.NICNumber=NICNumber;
		this.Address=Address;
		this.MobilNumber=MobilNumber;
		this.E_mail=E_mail;
		this.PoliceLocation=PoliceLocation;
		this.Postalcode=Postalcode;
		this.DoCumentVerifingDate=DoCumentVerifingDate;
	}


	public boolean Applicationinsertdata(String fullName, String dateofBirth2, String gender2, String iDnum,
			String address2, int i, String e_mail2, String policeLocation2, int p, String documentVerifivationDate) {
		// TODO Auto-generated method stub
		//database connection
				DbConnectionClass ob = new DbConnectionClass();
				Connection Conn = ob.DbConnection();
				
			//try & catch for insert Apllication details into database
		try {
		       Statement stmt = Conn.createStatement();
		       String query = "INSERT INTO Application_Form (UserFullName, DateOfBirth, Gender, NICNumber, Address, MobilNumber, E_mail, PoliceLocation, Postalcode,Documentdate) " +
                       "VALUES ('" + fullName + "','" + dateofBirth2 + "','" + gender2 + "','" + iDnum + "','" + address2 + "'," + i + ",'" + e_mail2 + "','" + policeLocation2 + "'," + p + ",'"+ documentVerifivationDate +"')";
		        stmt.execute(query);
		        System.out.println("successfully insert");
		        
		        
		        
		    }
		    catch(SQLException e){
		    	 System.out.println("insert Faild");
		         System.err.println("SQLExseption:"+e.getMessage());
		         
		    }
		return true;
	}


	

	
		
	
		
	
	

}
