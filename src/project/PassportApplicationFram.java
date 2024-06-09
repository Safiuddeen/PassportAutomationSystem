package project;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;





public class PassportApplicationFram extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputName;
	private JTextField inputID;
	private JTextField inputAddress;
	private JTextField inputMobilnumber;
	private JTextField inputEmail;
	private JTextField inputlocation;
	private JTextField inputpostal;
	private final ButtonGroup genderButtonGroup = new ButtonGroup();
	private JRadioButton MaleRadioButton;
    private JRadioButton FemaleRadioButton_1;
    private Component inputdateChooser;
	private JDateChooser ChooseDate;
	private PreparedStatement countStmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassportApplicationFram frame = new PassportApplicationFram();
					frame.setVisible(true);
					frame.setBounds(-8, 0, 1500, 690);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PassportApplicationFram() {
		setTitle("Pasport Rejistration form");
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1044, 690);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(128, 128, 128,100));
		panel.setBackground(new Color(128, 128, 128,100));
		panel.setBounds(260, 33, 760, 620);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Passport Application Form");
		lblNewLabel_2.setBounds(23, 11, 628, 51);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 40));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			
				String FullName=inputName.getText();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dateofBirth = dateFormat.format(((JDateChooser) inputdateChooser).getDate());
				
				String Gender=" ";
						if (MaleRadioButton.isSelected()){
								Gender="male";
						}
							else if(FemaleRadioButton_1.isSelected()){
								Gender="female";
							}
				String IDnum=inputID.getText();
				String Address=inputAddress.getText();
				String Mobilnumber=inputMobilnumber.getText();
				String E_mail=inputEmail.getText();
				String PoliceLocation=inputlocation.getText();
				String Postalcode=inputpostal.getText();
				
				SimpleDateFormat CdateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String DocumentVerifivationDate = CdateFormat.format(((JDateChooser) ChooseDate).getDate());
				
				
				try {
					//to check taht date slot have free in databse 
					Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Paport_System","root","1234");
			        countStmt = Conn.prepareStatement("SELECT COUNT(*) FROM Application_Form WHERE Documentdate = ?");
		            // Check if the maximum number of applicants for the selected date has been reached
			        // in here only maxsimum 3 applicant inly verifid by addministrator
		            countStmt.setString(1, DocumentVerifivationDate);
		            ResultSet rs = countStmt.executeQuery();
		            rs.next();
		            int count = rs.getInt(1);
		            if (count >= 3) {
		                JOptionPane.showMessageDialog(rootPane, "Sorry, the maximum number of applicants for this date has been reached.");
		                JOptionPane.showMessageDialog(rootPane, "Please Choose another date.");
		                return;
		            }
		        } catch (SQLException ex) {
		        	ex.printStackTrace(); // Handle exception Or log the error
			        
		            JOptionPane.showMessageDialog(rootPane, "Error: " + ex.getMessage());
		            return;
		        }
				
				
				
				int I=Integer.parseInt(Mobilnumber);
				int P=Integer.parseInt(Postalcode);
				
				PassportApplicationClass pac=new PassportApplicationClass();
				
                if(pac.Applicationinsertdata(FullName, dateofBirth, Gender, IDnum, Address, I, E_mail, PoliceLocation, P,DocumentVerifivationDate)) {
                    JOptionPane.showMessageDialog(rootPane, "Successfully submitted the application ");
                    UploaddocumentFram dt=new  UploaddocumentFram (IDnum);
					dt.setVisible(true);
					dt.setBounds(-8, 0, 1500, 690);
					dispose();
                    inputName.setText("");
                    inputdateChooser.update(null);
                    genderButtonGroup.clearSelection();
                    inputID.setText("");
                    inputAddress.setText("");
                    inputMobilnumber.setText("");
                    inputEmail.setText("");
                    inputlocation.setText("");
                    inputpostal.setText("");
                    ChooseDate.update(null);
                    
                }
                else {
                	JOptionPane.showMessageDialog(rootPane, " submition faild ");
                }
               
				
				
			}
		});
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBackground(new Color(0, 0, 160));
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSubmit.setBounds(589, 570, 126, 43);
		panel.add(btnSubmit);
		
		JButton btnNewButton_1_1 = new JButton("Back");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePageFram hm=new HomePageFram();
				hm.setBounds(-8, 0, 1500, 690);
				hm.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.setBounds(661, 11, 89, 28);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("Full Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(88, 90, 142, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Date of birth");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(88, 129, 142, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Gender");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1.setBounds(88, 175, 142, 20);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("ID Number");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_1.setBounds(88, 225, 142, 20);
		panel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Address");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_1_1.setBounds(88, 270, 142, 20);
		panel.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Mobil number");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_1_1_1.setBounds(88, 315, 142, 20);
		panel.add(lblNewLabel_3_1_1_1_1);
		
		JLabel inputE_mail = new JLabel("E-mail");
		inputE_mail.setFont(new Font("Tahoma", Font.BOLD, 18));
		inputE_mail.setBounds(88, 362, 142, 20);
		panel.add(inputE_mail);
		
		JLabel inputPlocation = new JLabel("Police Location");
		inputPlocation.setFont(new Font("Tahoma", Font.BOLD, 18));
		inputPlocation.setBounds(88, 414, 142, 20);
		panel.add(inputPlocation);
		
		JLabel inputPostalcode = new JLabel("Postalcode");
		inputPostalcode.setFont(new Font("Tahoma", Font.BOLD, 18));
		inputPostalcode.setBounds(88, 462, 142, 20);
		panel.add(inputPostalcode);
		
		inputName = new JTextField();
		inputName.setBounds(240, 90, 298, 20);
		panel.add(inputName);
		inputName.setColumns(10);
		
		  MaleRadioButton = new JRadioButton("Male");
        MaleRadioButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        MaleRadioButton.setBackground(new Color(255, 255, 255));
        MaleRadioButton.setBounds(244, 175, 72, 28);
        panel.add(MaleRadioButton);
        genderButtonGroup.add(MaleRadioButton);
		
        	FemaleRadioButton_1 = new JRadioButton("Female");
	        FemaleRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	        FemaleRadioButton_1.setBackground(new Color(255, 255, 255));
	        FemaleRadioButton_1.setBounds(427, 175, 93, 28);
	        panel.add(FemaleRadioButton_1);
	        genderButtonGroup.add(FemaleRadioButton_1);
		
		inputID = new JTextField();
		inputID.setColumns(10);
		inputID.setBounds(240, 228, 298, 20);
		panel.add(inputID);
		
		inputAddress = new JTextField();
		inputAddress.setColumns(10);
		inputAddress.setBounds(240, 273, 298, 20);
		panel.add(inputAddress);
		
		inputMobilnumber = new JTextField();
		inputMobilnumber.setColumns(10);
		inputMobilnumber.setBounds(240, 318, 298, 20);
		panel.add(inputMobilnumber);
		
		inputEmail = new JTextField();
		inputEmail.setColumns(10);
		inputEmail.setBounds(240, 365, 298, 20);
		panel.add(inputEmail);
		
		inputlocation = new JTextField();
		inputlocation.setColumns(10);
		inputlocation.setBounds(240, 417, 298, 20);
		panel.add(inputlocation);
		
		inputpostal = new JTextField();
		inputpostal.setColumns(10);
		inputpostal.setBounds(240, 462, 298, 20);
		panel.add(inputpostal);
		
		inputdateChooser = new JDateChooser();
		inputdateChooser.setBounds(240, 129, 298, 20);
		panel.add(inputdateChooser);
		
		JLabel lblNewLabel_4 = new JLabel("**Chose date for Document Verification");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(49, 493, 350, 20);
		panel.add(lblNewLabel_4);
		
		JLabel lblChooseDate = new JLabel("Chose Date ");
		lblChooseDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChooseDate.setBounds(88, 514, 142, 28);
		panel.add(lblChooseDate);
		
		 ChooseDate = new JDateChooser();
		ChooseDate.setBounds(240, 514, 298, 28);
		panel.add(ChooseDate);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(-100, 0, 1550, 690);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\E  ZONE\\Desktop\\passsport\\Untitled-5.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		JLabel label = new JLabel("New label");
		label.setBounds(81, 549, 49, 14);
		contentPane.add(label);
	}
}
