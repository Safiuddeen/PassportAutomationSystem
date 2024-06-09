package project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InformationClass {
	private String ApplicantId;
	private String PassportID;
	private String UserFullName;
	private String NICNumber;
	private int MobilNumber;
	private String PassportStatus;
	private String About;
	private JTable JTable;
	
	
	public InformationClass() {
		this.ApplicantId=ApplicantId;
		this.PassportID=PassportID;
		this.UserFullName=UserFullName;
		this.NICNumber=NICNumber;
		this.MobilNumber=MobilNumber;
		this.PassportStatus=PassportStatus;
		this.About=About;
	}
	

	//TO display data into Jtable(to send SMS)
	public void DisplayInfodataTable(JTable table) {
		// TODO Auto-generated method stub
		//database connection
		DbConnectionClass ob = new DbConnectionClass();
		Connection Conn = ob.DbConnection();

			try {
			    Statement stmt = Conn.createStatement();
			    String query = "Select * from Application_Form";
			    ResultSet rs=stmt.executeQuery(query);
			    System.out.println("successfully Selected");
			    
			    
			   //to hold the data 
			    DefaultTableModel model=(DefaultTableModel) table.getModel();
			    
			    //clear exisiting data from the table 
			    model.setRowCount(0);
			    
			    int rowCount=model.getRowCount();
			    
			    
			    while(rs.next()) {
			    	String passportid=rs.getString("PassportID");
			    	String name=rs.getString("UserFullName");
			    	String idnumber=rs.getString("NICNumber");
			    	String MobilNumber=rs.getString("MobilNumber");
			    	String PassportStatus=rs.getString("PassportStatus");
			    	String About=rs.getString("About");
			    	
			    	
			    	model.addRow(new Object[] { passportid,name,idnumber,MobilNumber,PassportStatus,About,null} );
			
			    	rowCount++;
			    }
			
			    
					}
					catch(SQLException e){
						 System.out.println("insert Faild");
					     System.err.println("SQLExseption:"+e.getMessage());
			    
			}
			
				}


	public boolean SendSMS(String passportId2, String about2) {
		// TODO Auto-generated method stub
		//database connection
		DbConnectionClass ob = new DbConnectionClass();
		Connection Conn = ob.DbConnection();
		
		
		try {
			Statement stmt = Conn.createStatement();
		    String query = "UPDATE Application_Form SET About='" + about2 + "' WHERE PassportID='" + passportId2 + "'";
		    int rowsAffected = stmt.executeUpdate(query);
	        
	        if (rowsAffected > 0) {
	            System.out.println("Successfully updated applicant details");
	        } else {
	            System.out.println("Failed to update applicant details");
	           
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error displaying images: " + e.getMessage());
	    }
		return true;
		


	}

}
