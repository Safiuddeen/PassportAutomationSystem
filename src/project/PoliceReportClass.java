package project;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class PoliceReportClass {
	private String PassportID;
	private String NICNumber;
	private String UserFullName;
	private String PoliceReport_image;
	private String PoliceReport;
	
	
	
	public PoliceReportClass() {
		this.PassportID=PassportID;
		this.NICNumber=NICNumber;
		this.UserFullName=UserFullName;
		this.PoliceReport_image=PoliceReport_image;
		this.PoliceReport=PoliceReport;
	}
	
	
	
	
	// Submit  police report on databse 
	public void submitData(String iD, String userName, String nICnum, File pR_FilePath) {
		// TODO Auto-generated method stub
		//database connection
		DbConnectionClass ob = new DbConnectionClass();
		Connection Conn = ob.DbConnection();
		
			try {
			    FileInputStream p_reportFile = new FileInputStream(pR_FilePath);
			    
			    PreparedStatement pstmt = Conn.prepareStatement("INSERT INTO Police_report (PassportID, NICNumber, UserFullName, PoliceReport_image) VALUES (?, ?, ?, ?)");
			  
			    pstmt.setString(1, iD);
			    pstmt.setString(2, nICnum);
			    pstmt.setString(3, userName);
			    pstmt.setBinaryStream(4, p_reportFile, (int) pR_FilePath.length()); // Upload police report image
			    pstmt.executeUpdate();
			    
			    pstmt.close();
			    
			    
			    System.out.println("Images uploaded successfully");
			} catch (SQLException | IOException e) {
			    System.out.println("Error uploading images: " + e.getMessage());
			}
			}



	//search the report if its in system
	public boolean SearchReport(String nICNumber2, JTextField textFieldPassID, JTextField textFieldUsername,JLabel lblPoliceReport) {
		// TODO Auto-generated method stub
		
					
							//database connection
							DbConnectionClass ob = new DbConnectionClass();
							Connection Conn = ob.DbConnection();
					    try (
					         PreparedStatement statement = Conn.prepareStatement("SELECT * FROM Police_report WHERE NICNumber = ?")) {
					        statement.setString(1, nICNumber2);
					        
					        // Execute the query
					        ResultSet rs = statement.executeQuery();
					        
					        // If there is a result, update the text fields with the retrieved data
					        if (rs.next()) {
					        	//to display the image
					        	InputStream Policereport = rs.getBinaryStream("PoliceReport_image");
					        	BufferedImage PRImage = ImageIO.read(Policereport);
					        	PRImage = resizeImage1(PRImage, 300, 300);
					        	lblPoliceReport.setIcon(new ImageIcon(PRImage));
					        	
					        	//and to display the details
					        	textFieldPassID.setText(rs.getString("PassportID"));
					        	textFieldUsername.setText(rs.getString("UserFullName"));
					        	
					            
					            
					            
					            // You can add more fields if needed
					        } else {
					            // If no data is found for the given NIC number, you can display a message or perform any other action
					            // For example:
					        	textFieldPassID.setText("");
					        	textFieldUsername.setText("");
					        	lblPoliceReport.setText("");
					            // Set other fields to empty or display a message
					        }
					    } catch (SQLException | IOException e) {
					        e.printStackTrace();
					        // Handle any potential errors, such as displaying an error message dialog
					    }
						return true;
					}
	private BufferedImage resizeImage1(BufferedImage Policereport, int i, int j) {
		// TODO Auto-generated method stub
		BufferedImage resizedImage = new BufferedImage(i, j, BufferedImage.TYPE_INT_RGB);
	    Graphics2D graphics2D = resizedImage.createGraphics();
	    graphics2D.drawImage(Policereport, 0, 0, i, j, null);
	    graphics2D.dispose();
	    return resizedImage;
		
	}




	public boolean updateReportStatus(String nICNum, String pverification) {
		// TODO Auto-generated method stub
		//database connection
		DbConnectionClass ob = new DbConnectionClass();
		Connection Conn = ob.DbConnection();
		
		
		try {
			Statement stmt = Conn.createStatement();
		    String query = "UPDATE Application_Form SET PoliceReport='" + pverification + "' WHERE NICNumber='" + nICNum + "'";
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
