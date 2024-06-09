package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;

public class AdminPanelFram extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textPassID;
	private JTextField textUsername;
	private JTextField textNICnum;
	private JTextField textPoliceLocation;
	private JTextField textPostalcode;
	private JTextField textVerification;
	private JTextField textPoliceReport;
	private JTextField textFieldSearch;
	private JComboBox comboBoxPS;
	private JTextField textFieldPassStatus;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanelFram frame = new AdminPanelFram();
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

	public AdminPanelFram() {setTitle("Admin Panel");
	setBackground(new Color(240, 240, 240));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1194, 689);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(192, 192, 192));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel_2 = new JLabel("Search Bar");
	lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_2.setBounds(601, 19, 89, 25);
	contentPane.add(lblNewLabel_2);
	
	textFieldSearch = new JTextField();
	textFieldSearch.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			AdminPanelClass apc=new AdminPanelClass();
			String searchQuery = textFieldSearch.getText();
            apc.DisplaydataTable2(table, searchQuery);
		}
	});
	textFieldSearch.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			

		}
	});
	textFieldSearch.setBounds(697, 16, 323, 27);
	contentPane.add(textFieldSearch);
	textFieldSearch.setColumns(10);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(434, 48, 835, 410);
	contentPane.add(scrollPane);
	
	table = new JTable();
	table.setFont(new Font("Tahoma", Font.BOLD, 14));
	table.setModel(new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"PassportID", "UserFullName", "NICNumber", "PoliceLocation", "Postalcode", "Verification", "PoliceReport", "PassportStatus"
		}
	) {
		Class[] columnTypes = new Class[] {
			String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class
		};
		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
	});
	table.getColumnModel().getColumn(1).setPreferredWidth(87);
	table.getColumnModel().getColumn(3).setPreferredWidth(89);
	table.getColumnModel().getColumn(7).setPreferredWidth(91);
	scrollPane.setViewportView(table);
	table.setCellSelectionEnabled(true);
	table.setColumnSelectionAllowed(true);
	//if click auto generate for texfeild
	 table.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
         public void valueChanged(ListSelectionEvent e) {
             if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                 int selectedRow = table.getSelectedRow();
                 fillFieldsFromSelectedRow(selectedRow);
             }
         }

         private void fillFieldsFromSelectedRow(int selectedRow) {
             textPassID.setText(getValueAsString(selectedRow, 0)); // PassportID
             textUsername.setText(getValueAsString(selectedRow, 1)); // UserFullName
             textNICnum.setText(getValueAsString(selectedRow, 2)); // NICNumber
             textPoliceLocation.setText(getValueAsString(selectedRow, 3)); // PoliceLocation
             textPostalcode.setText(getValueAsString(selectedRow, 4)); // Postalcode
             textVerification.setText(getValueAsString(selectedRow, 5)); // Verification
             textPoliceReport.setText(getValueAsString(selectedRow, 6)); // PoliceReport
             textFieldPassStatus.setText(getValueAsString(selectedRow, 7)); // PassportStatus
         }

         private String getValueAsString(int row, int column) {
             Object value = table.getValueAt(row, column);
             return (value != null) ? value.toString() : "";
         }
     });
	
		
	
	JLabel lblNewLabel = new JLabel("   Admin Panel");
	lblNewLabel.setBounds(0, 0, 224, 44);
	lblNewLabel.setBackground(new Color(192, 192, 192));
	lblNewLabel.setForeground(new Color(255, 255, 255));
	lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
	contentPane.add(lblNewLabel);
	
	JButton btnNewButton = new JButton("Back");
	btnNewButton.setBounds(1150, 11, 89, 30);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			AdminFram alp=new AdminFram();
			alp.setBounds(-8, 0, 1500, 690);
			alp.setVisible(true);
			dispose();
		
		}
		
	});
	contentPane.add(btnNewButton);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBounds(0, 0, 224, 44);
	panel_1.setBackground(new Color(0, 0, 0));
	contentPane.add(panel_1);
	
	JButton btnApDisplay = new JButton("Display");
	btnApDisplay.setBounds(444, 469, 101, 30);
	btnApDisplay.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			//to display the data to table 
			AdminPanelClass apc=new AdminPanelClass();
			apc.DisplaydataTable(table);
			
	    
		}
	});
	contentPane.add(btnApDisplay);
	
	JPanel panel = new JPanel();
	panel.setBounds(10, 48, 396, 650);
	contentPane.add(panel);
	panel.setLayout(null);
	
	JButton btnUpdate = new JButton("Update");
	btnUpdate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String PassportId=textPassID.getText();
			String PassportStaus = comboBoxPS.getSelectedItem().toString();
			
			
			AdminPanelClass apc=new AdminPanelClass();
			if (apc.UpdateApplicantDetails(PassportId,  PassportStaus)) {
	            int choice = JOptionPane.showConfirmDialog(rootPane, "Update Available! Do you want to update now?", "Update", JOptionPane.YES_NO_OPTION);
	            if (choice == JOptionPane.YES_OPTION) {
	                // User clicked Yes, proceed with update logic
	                // Add your update logic here
	            } else {
	                // User clicked No or closed the dialog, do nothing or handle accordingly
	            }
			}
		}
	});
	btnUpdate.setBounds(44, 443, 87, 34);
	panel.add(btnUpdate);
	
	JButton btnApDelete = new JButton("Delete");
	btnApDelete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String PassporrtID=textPassID.getText();
			
			 int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the record?", "Confirmation", JOptionPane.YES_NO_OPTION);
		        
		        if (option == JOptionPane.YES_OPTION) {
		            AdminPanelClass apc = new AdminPanelClass();
		            apc.DeteleUserData(PassporrtID, table);
		            
		             textPassID.setText(""); // PassportID
		             textUsername.setText(""); // UserFullName
		             textNICnum.setText(""); // NICNumber
		             textPoliceLocation.setText(""); // PoliceLocation
		             textPostalcode.setText(""); // Postalcode
		             textVerification.setText(""); // Verification
		             textPoliceReport.setText(""); // PoliceReport
		             textFieldPassStatus.setText(""); // PassportStatus
		            
		        }
		    }
			
		
	});
	btnApDelete.setBounds(164, 443, 87, 34);
	panel.add(btnApDelete);
	
	JButton btnApSearch = new JButton("Search");
	btnApSearch.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			 String passportID = textPassID.getText(); // Assuming textPassportID is the JTextField where user inputs Passport ID
		        AdminPanelClass apc = new AdminPanelClass();
		        apc.searchByPassportID(passportID, table); // Assuming yourTable is the JTable where you want to display search results
		    }
			
			
		
	});
	btnApSearch.setBounds(283, 443, 87, 34);
	panel.add(btnApSearch);
	
	JButton btnDOCverify = new JButton("Document Verification");
	btnDOCverify.setBounds(10, 488, 179, 34);
	panel.add(btnDOCverify);
	
	JButton btnReportCheck = new JButton("Police Report Check");
	btnReportCheck.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PoliceReportFrame prf=new PoliceReportFrame();
			prf.setVisible(true);
			prf.setBounds(-8, 0, 1500, 690);
			dispose();
			
		}
	});
	btnReportCheck.setBounds(217, 488, 169, 34);
	panel.add(btnReportCheck);
	
	textPoliceLocation = new JTextField();
	textPoliceLocation.setFont(new Font("Tahoma", Font.BOLD, 14));
	textPoliceLocation.setColumns(10);
	textPoliceLocation.setBounds(179, 170, 191, 38);
	panel.add(textPoliceLocation);
	
	textPostalcode = new JTextField();
	textPostalcode.setFont(new Font("Tahoma", Font.BOLD, 14));
	textPostalcode.setColumns(10);
	textPostalcode.setBounds(179, 225, 191, 38);
	panel.add(textPostalcode);
	
	textVerification = new JTextField();
	textVerification.setFont(new Font("Tahoma", Font.BOLD, 14));
	textVerification.setColumns(10);
	textVerification.setBounds(179, 277, 191, 38);
	panel.add(textVerification);
	
	textPoliceReport = new JTextField();
	textPoliceReport.setFont(new Font("Tahoma", Font.BOLD, 14));
	textPoliceReport.setColumns(10);
	textPoliceReport.setBounds(179, 325, 191, 38);
	panel.add(textPoliceReport);
	
	JLabel lblPolicelocation = new JLabel("PoliceLocation");
	lblPolicelocation.setForeground(new Color(0, 0, 0));
	lblPolicelocation.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblPolicelocation.setBounds(10, 169, 140, 38);
	panel.add(lblPolicelocation);
	
	JLabel PassportID_1_1 = new JLabel("Postalcode");
	PassportID_1_1.setForeground(new Color(0, 0, 0));
	PassportID_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	PassportID_1_1.setBounds(10, 224, 140, 38);
	panel.add(PassportID_1_1);
	
	JLabel PassportID_1_1_1 = new JLabel("Verification");
	PassportID_1_1_1.setForeground(new Color(0, 0, 0));
	PassportID_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	PassportID_1_1_1.setBounds(10, 277, 140, 38);
	panel.add(PassportID_1_1_1);
	
	JLabel PassportID_1_1_1_1 = new JLabel("PoliceReport");
	PassportID_1_1_1_1.setForeground(new Color(0, 0, 0));
	PassportID_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	PassportID_1_1_1_1.setBounds(10, 325, 140, 38);
	panel.add(PassportID_1_1_1_1);
	
	JLabel PassportID_1_1_1_1_1 = new JLabel("Passport Status");
	PassportID_1_1_1_1_1.setForeground(new Color(0, 0, 0));
	PassportID_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	PassportID_1_1_1_1_1.setBounds(10, 374, 140, 38);
	panel.add(PassportID_1_1_1_1_1);
	
	JLabel PassportID = new JLabel("PassportID");
	PassportID.setBounds(10, 22, 140, 38);
	panel.add(PassportID);
	PassportID.setForeground(new Color(0, 0, 0));
	PassportID.setFont(new Font("Tahoma", Font.BOLD, 16));
	
	JLabel lblNewLabel_2_1_1 = new JLabel("UserFullName");
	lblNewLabel_2_1_1.setBounds(10, 71, 140, 38);
	panel.add(lblNewLabel_2_1_1);
	lblNewLabel_2_1_1.setForeground(new Color(0, 0, 0));
	lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	
	textPassID = new JTextField();
	textPassID.setBounds(179, 23, 191, 38);
	panel.add(textPassID);
	textPassID.setFont(new Font("Tahoma", Font.BOLD, 14));
	textPassID.setColumns(10);
	
	textUsername = new JTextField();
	textUsername.setBounds(179, 70, 191, 42);
	panel.add(textUsername);
	textUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
	textUsername.setColumns(10);
	
	textNICnum = new JTextField();
	textNICnum.setBounds(179, 121, 191, 38);
	panel.add(textNICnum);
	textNICnum.setFont(new Font("Tahoma", Font.BOLD, 14));
	textNICnum.setColumns(10);
	
	JLabel lblNewLabel_2_1_1_2 = new JLabel("NICNumber");
	lblNewLabel_2_1_1_2.setBounds(10, 120, 140, 38);
	panel.add(lblNewLabel_2_1_1_2);
	lblNewLabel_2_1_1_2.setForeground(new Color(0, 0, 0));
	lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
	
	JButton btnSMS_MAIL = new JButton("Send Information");
	btnSMS_MAIL.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			InformationFrame in=new InformationFrame();
			in.setVisible(true);
			in.setBounds(-8, 0, 1500, 690);
			dispose();
		}
	});
	btnSMS_MAIL.setBounds(106, 533, 169, 34);
	panel.add(btnSMS_MAIL);
	
	 comboBoxPS = new JComboBox();
	comboBoxPS.setModel(new DefaultComboBoxModel(new String[] {"", "", "pending", "Issued", "submit the report"}));
	comboBoxPS.setBounds(179, 399, 191, 22);
	panel.add(comboBoxPS);
	
	textFieldPassStatus = new JTextField();
	textFieldPassStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
	textFieldPassStatus.setColumns(10);
	textFieldPassStatus.setBounds(179, 366, 191, 33);
	panel.add(textFieldPassStatus);
	btnDOCverify.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			DocumentVerificationFram dv=new DocumentVerificationFram();
			dv.setVisible(true);
			dv.setBounds(-8, 0, 1500, 690);
			dispose();
			}
	});
	
	JLabel lblNewLabel_1 = new JLabel("");
	lblNewLabel_1.setBounds(-100, 0, 1550, 690);
	lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\E  ZONE\\Desktop\\passsport\\Untitled-5.png"));
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
	contentPane.add(lblNewLabel_1);
}
}
