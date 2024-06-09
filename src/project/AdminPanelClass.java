package project;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class AdminPanelClass {
	private int ApplicantId;
	private String PassportID;
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
	private String Verification;
	private String PoliceReport;
	private String PassportStatus;
	private JTable JTable;
	
	
	
	public AdminPanelClass() {
		this.ApplicantId=ApplicantId;
		this.PassportID=PassportID;
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
		this.Verification=Verification;
		this.PoliceReport=PoliceReport;
		this.PassportStatus=PassportStatus;
		
	}
	

	public boolean UpdateApplicantDetails(String passportId2, String passportStaus) {
		// TODO Auto-generated method stub
		//database connection
		DbConnectionClass ob = new DbConnectionClass();
		Connection Conn = ob.DbConnection();
		
		
		try {
	        Statement stmt = Conn.createStatement();
	        String query = "UPDATE Application_Form SET  PassportStatus='" + passportStaus + "' WHERE PassportID='" + passportId2 + "'";
	        int rowsAffected = stmt.executeUpdate(query);
	        if (rowsAffected > 0) {
	            System.out.println("Successfully updated applicant details");
	        } else {
	            System.out.println("Failed to update applicant details");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return true;
		
	}
		
	



	public void DisplaydataTable(JTable table) {
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
	        	String policeLocation=rs.getString("PoliceLocation");
	        	String Postalcode=rs.getString("Postalcode");
	        	String Verification=rs.getString("Verification");
	        	String PoliceReport=rs.getString("PoliceReport");
	        	String PassportStatus=rs.getString("PassportStatus");
	        	
	        	
	        	
	        	model.addRow(new Object[] { passportid,name,idnumber,policeLocation,Postalcode,Verification,PoliceReport,PassportStatus,null} );

	        	rowCount++;
	        }

	        
	    }
	    catch(SQLException e){
	    	 System.out.println("insert Faild");
	         System.err.println("SQLExseption:"+e.getMessage());
	        
	    }
		

	}













	// disply the image to verifi fr the 
	public void verifyTodisplayImages(String passportID2, JLabel lblimage_BC, JLabel lblimage_NIC, JLabel lblimage_Applicant) {
		// TODO Auto-generated method stub
		//database connection
				DbConnectionClass ob = new DbConnectionClass();
				Connection Conn = ob.DbConnection();
				
		
		try {
	        // Query to retrieve images based on image_id
	        PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM Application_Form WHERE PassportID = ?");
	        pstmt.setString(1, passportID2);
	        ResultSet rs = pstmt.executeQuery();

	        // Assuming the result set contains exactly 3 images for the given image_id
	        if (rs.next()) {
	            // Convert binary data to BufferedImage
	            InputStream bcIs = rs.getBinaryStream("image_BC");
	            InputStream idIs = rs.getBinaryStream("image_NIC");
	            InputStream appIs = rs.getBinaryStream("image_Applicant");

	            BufferedImage bcImage = ImageIO.read(bcIs);
	            BufferedImage idImage = ImageIO.read(idIs);
	            BufferedImage appImage = ImageIO.read(appIs);

	            // Resize images to 300x400
	            bcImage = resizeImage(bcImage, 300, 400);
	            idImage = resizeImage(idImage, 300, 400);
	            appImage = resizeImage(appImage, 300, 400);

	            // Set images to labels
	            lblimage_BC.setIcon(new ImageIcon(bcImage));
	            lblimage_NIC.setIcon(new ImageIcon(idImage));
	            lblimage_Applicant.setIcon(new ImageIcon(appImage));
	        }

	        rs.close();
	        pstmt.close();
	        Conn.close();
	    } catch (SQLException | IOException e) {
	        System.out.println("Error displaying images: " + e.getMessage());
	    }
	}
 //to reSize the image 
	private BufferedImage resizeImage(BufferedImage bcImage, int i, int j) {
		// TODO Auto-generated method stub
		BufferedImage resizedImage = new BufferedImage(i, j, BufferedImage.TYPE_INT_RGB);
	    Graphics2D graphics2D = resizedImage.createGraphics();
	    graphics2D.drawImage(bcImage, 0, 0, i, j, null);
	    graphics2D.dispose();
	    return resizedImage;
		
	}






	public boolean UpdateDocumentVerification(String passportID2, String verification2) {
		// TODO Auto-generated method stub
		//database connection
				DbConnectionClass ob = new DbConnectionClass();
				Connection Conn = ob.DbConnection();
				
				
				try {
					Statement stmt = Conn.createStatement();
				    String query = "UPDATE Application_Form SET Verification='" + verification2 + "' WHERE PassportID='" + passportID2 + "'";
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

	
	
	
	//search details using button
	public void searchByPassportID(String passportID2, javax.swing.JTable table) {
		// TODO Auto-generated method stub
		// Database connection
        DbConnectionClass ob = new DbConnectionClass();
        Connection conn = ob.DbConnection();
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data from the table
        
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Application_Form WHERE PassportID='" + passportID2 + "'";
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                String passportId = rs.getString("PassportID");
                String fullName = rs.getString("UserFullName");
                String nicNumber = rs.getString("NICNumber");
                String policeLocation = rs.getString("PoliceLocation");
                String postalCode = rs.getString("Postalcode");
                String verification = rs.getString("Verification");
                String policeReport = rs.getString("PoliceReport");
                String passportStatus = rs.getString("PassportStatus");
                
                model.addRow(new Object[]{passportId, fullName, nicNumber, policeLocation, postalCode, verification, policeReport, passportStatus});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
 //search details using user input as UserName in search bar
	public void DisplaydataTable2(javax.swing.JTable table, String searchQuery) {
		// TODO Auto-generated method stub
		//database connection
        DbConnectionClass ob = new DbConnectionClass();
        Connection Conn = ob.DbConnection();

        try {
            Statement stmt = Conn.createStatement();
            String query = "SELECT * FROM Application_Form WHERE UserFullName LIKE '%" + searchQuery + "%'";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Successfully selected");

            //to hold the data
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            //clear existing data from the table
            model.setRowCount(0);

            int rowCount = model.getRowCount();

            while (rs.next()) {
                String passportid = rs.getString("PassportID");
                String name = rs.getString("UserFullName");
                String idnumber = rs.getString("NICNumber");
                String policeLocation = rs.getString("PoliceLocation");
                String Postalcode = rs.getString("Postalcode");
                String Verification = rs.getString("Verification");
                String PoliceReport = rs.getString("PoliceReport");
                String PassportStatus = rs.getString("PassportStatus");

                model.addRow(new Object[]{passportid, name, idnumber, policeLocation, Postalcode, Verification, PoliceReport, PassportStatus, null});

                rowCount++;
            }

        } catch (SQLException e) {
            System.out.println("Insert Failed");
            System.err.println("SQLException: " + e.getMessage());
        }
	}






	
		





	//retrive the image foe user View Status
		public void retrieveDataFromDatabase(String nICNum, JLabel lblimage_Applicant1) {
			// TODO Auto-generated method stub
			//database connection
			DbConnectionClass ob = new DbConnectionClass();
			Connection Conn = ob.DbConnection();
			
	
	try {
        // Query to retrieve images based on image_id
        PreparedStatement pstmt = Conn.prepareStatement("SELECT * FROM Application_Form WHERE  NICNumber = ?");
        pstmt.setString(1, nICNum);
        ResultSet rs = pstmt.executeQuery();

        // Assuming the result set contains exactly 3 images for the given image_id
        if (rs.next()) {
        	InputStream appIs = rs.getBinaryStream("image_Applicant");
        	BufferedImage appImage = ImageIO.read(appIs);
        	appImage = resizeImage1(appImage, 300, 300);
        	lblimage_Applicant1.setIcon(new ImageIcon(appImage));
        	 System.out.println("displaying image ");
		}} 
		catch (SQLException | IOException e) {
	        System.out.println("Error displaying images: " + e.getMessage());
	    }}
        private BufferedImage resizeImage1(BufferedImage bcImage, int i, int j) {
			// TODO Auto-generated method stub
			BufferedImage resizedImage = new BufferedImage(i, j, BufferedImage.TYPE_INT_RGB);
		    Graphics2D graphics2D = resizedImage.createGraphics();
		    graphics2D.drawImage(bcImage, 0, 0, i, j, null);
		    graphics2D.dispose();
		    return resizedImage;
			
		}
        
        
        
        
       //get the details from data base 
		public void reretrieveDetailsFromDatabase(String nICNum, JTextField textFieldPassportID,
				JTextField textFieldusername, JTextField textFieldDateOfBirth, JTextField textFieldGender,
				JTextField textFieldAddress, JTextField textFieldMobilNumber, JTextField textFieldDocumentdate,
				JTextField textFieldVerification, JTextField textFieldPoliceReport,
				JTextField textFieldPassportStatus, JTextField textFieldAbout) {
			// TODO Auto-generated method stub
			
					//database connection
					DbConnectionClass ob = new DbConnectionClass();
					Connection Conn = ob.DbConnection();
			    try (
			         PreparedStatement statement = Conn.prepareStatement("SELECT * FROM Application_Form WHERE NICNumber = ?")) {
			        statement.setString(1, nICNum);
			        
			        // Execute the query
			        ResultSet resultSet = statement.executeQuery();
			        
			        // If there is a result, update the text fields with the retrieved data
			        if (resultSet.next()) {
			            textFieldPassportID.setText(resultSet.getString("PassportID"));
			            textFieldusername.setText(resultSet.getString("UserFullName"));
			            textFieldDateOfBirth.setText(resultSet.getString("DateOfBirth"));
			            textFieldGender.setText(resultSet.getString("Gender"));
			            textFieldAddress.setText(resultSet.getString("Address"));
			            textFieldMobilNumber.setText(resultSet.getString("MobilNumber"));
			            textFieldDocumentdate.setText(resultSet.getString("DocumentDate"));
			            textFieldVerification.setText(resultSet.getString("Verification"));
			            textFieldPoliceReport.setText(resultSet.getString("PoliceReport"));
			            textFieldPassportStatus.setText(resultSet.getString("PassportStatus"));
			            textFieldAbout.setText(resultSet.getString("About"));
			            
			            // You can add more fields if needed
			        } else {
			            // If no data is found for the given NIC number, you can display a message or perform any other action
			            // For example:
			            textFieldPassportID.setText("");
			            textFieldusername.setText("");
			            // Set other fields to empty or display a message
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			        // Handle any potential errors, such as displaying an error message dialog
			    }
			}





//delete data using PassportID
		public void DeteleUserData(String passporrtID, javax.swing.JTable table) {
			// TODO Auto-generated method stub
			
			// Database connection
	        DbConnectionClass ob = new DbConnectionClass();
	        Connection conn = ob.DbConnection();

	        try {
	            Statement stmt = conn.createStatement();
	            String query = "DELETE FROM Application_Form WHERE PassportID='" + passporrtID + "'";
	            int rowsAffected = stmt.executeUpdate(query);
	            if (rowsAffected > 0) {
	                System.out.println("Record deleted successfully");
	            } else {
	                System.out.println("No record found for deletion");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }






		}
		
		
		
		
		
		
		
		
		
		

	

	
	
  


	






	






	


	






	




	
	
	
	

	


	
	
	
	

