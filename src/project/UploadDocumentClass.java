package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UploadDocumentClass {
	private String image_BC;
	private String image_NIC;
	private String image_Applicant;
	
	
	public UploadDocumentClass() {
		this.image_BC=image_BC;
		this.image_NIC=image_NIC;
		this.image_Applicant=image_Applicant;
		
	}


	public void uploadImageToDataBase(String nICNum, File bcFile, File idImageFile, File appImageFile) {
		// TODO Auto-generated method stub
		//database connection
				DbConnectionClass ob = new DbConnectionClass();
				Connection Conn = ob.DbConnection();
				
		try {
	        FileInputStream bcFis = new FileInputStream(bcFile);
	        FileInputStream idFis = new FileInputStream(idImageFile);
	        FileInputStream appFis = new FileInputStream(appImageFile);

	        
	        
	        
	        PreparedStatement pstmt = Conn.prepareStatement("UPDATE Application_Form SET image_BC = ?, image_NIC = ?, image_Applicant = ? WHERE NICNumber = ?");
	        pstmt.setBinaryStream(1, bcFis, (int) bcFile.length()); // Update image_BC
	        pstmt.setBinaryStream(2, idFis, (int) idImageFile.length()); // Update image_NIC
	        pstmt.setBinaryStream(3, appFis, (int) appImageFile.length()); // Update image_Applicant
	        pstmt.setString(4, nICNum);
	        pstmt.executeUpdate();
	        
	        pstmt.close();
	        bcFis.close();
	        idFis.close();
	        appFis.close();
	        
	        System.out.println("Images uploaded successfully");
	    } catch (SQLException | IOException e) {
	        System.out.println("Error uploading images: " + e.getMessage());
	    }
	}

}
