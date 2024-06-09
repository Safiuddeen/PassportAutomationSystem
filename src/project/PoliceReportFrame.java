package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PoliceReportFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNICNum;
	private JTextField textFieldPassID;
	private JTextField textFieldUsername;
	private JComboBox comboBox;
	private JLabel lblPoliceReport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PoliceReportFrame frame = new PoliceReportFrame();
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
	public PoliceReportFrame() {
		setTitle("Police Report");
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1262, 658);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setBounds(1159, 25, 89, 34);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanelFram apf=new AdminPanelFram();
				apf.setVisible(true);
				apf.setBounds(-8, 0, 1500, 690);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Police Report Check");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(23, 11, 284, 39);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 295, 59);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("NIC Number");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(325, 82, 152, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Passport ID");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(325, 143, 152, 34);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("User Name");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_1.setBounds(325, 210, 152, 34);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Police Report");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_1_1.setBounds(325, 269, 152, 34);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		textFieldNICNum = new JTextField();
		textFieldNICNum.setBounds(508, 82, 241, 34);
		contentPane.add(textFieldNICNum);
		textFieldNICNum.setColumns(10);
		
		textFieldPassID = new JTextField();
		textFieldPassID.setColumns(10);
		textFieldPassID.setBounds(508, 143, 241, 34);
		contentPane.add(textFieldPassID);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(508, 210, 241, 34);
		contentPane.add(textFieldUsername);
		
		JButton btnserchReport = new JButton("Search");
		btnserchReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String NICNumber = textFieldNICNum.getText();

		        // Create an object of the PoliceReportClass
		        PoliceReportClass prc = new PoliceReportClass();

		        // Search for the report // Display a popup message based on whether the report was found or not
		        if ( prc.SearchReport(NICNumber, textFieldPassID, textFieldUsername, lblPoliceReport)) {
		            JOptionPane.showMessageDialog(null, "Report found for NIC number: " + NICNumber, "Search Result", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            JOptionPane.showMessageDialog(null, "No report found for NIC number: " + NICNumber, "Search Result", JOptionPane.WARNING_MESSAGE);
		        }
		    }
		});
		btnserchReport.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnserchReport.setBounds(811, 82, 104, 33);
		contentPane.add(btnserchReport);
		
		 lblPoliceReport = new JLabel("");
		lblPoliceReport.setBounds(508, 269, 480, 270);
		contentPane.add(lblPoliceReport);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(217, 217, 217));
		panel_1.setBounds(291, 80, 196, 226);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Police Report Verification");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_1_1_1.setBounds(325, 563, 273, 34);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(217, 217, 217));
		panel_1_1.setBounds(291, 563, 324, 34);
		contentPane.add(panel_1_1);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//to get the selection of update
				String pVerification = comboBox.getSelectedItem().toString();
				String NICNum=textFieldNICNum.getText();
				
				PoliceReportClass prf=new PoliceReportClass();
				
				 if(prf.updateReportStatus(NICNum,pVerification)) {
		            	int choice = JOptionPane.showConfirmDialog(rootPane, "Update Available! Do you want to update now?", "Update", JOptionPane.YES_NO_OPTION);
			            if (choice == JOptionPane.YES_OPTION) {
			            	JOptionPane.showMessageDialog(rootPane, "Update Successful!");
			                 AdminPanelFram apf=new AdminPanelFram();
			                 apf.setVisible(true);
			                 apf.setBounds(-8, 0, 1500, 690);
			                 dispose();
			            } else {
			            	JOptionPane.showMessageDialog(rootPane, "Invalid User NIC Number !",NICNum, JOptionPane.ERROR_MESSAGE);
			            	
			            }
					}
		            
		            
		            
		    	}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(1007, 563, 109, 33);
		contentPane.add(btnNewButton_1);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Success", "Pending", "Faild", "Creminal Issue"}));
		comboBox.setBounds(653, 563, 295, 32);
		contentPane.add(comboBox);
		
		JButton btnReportInsert = new JButton("Report Insert");
		btnReportInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PoliceReportInsertFrame pr=new PoliceReportInsertFrame();
				pr.setVisible(true);
				pr.setBounds(-8, 0, 1500, 690);
				dispose();
			}
		});
		btnReportInsert.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReportInsert.setBounds(10, 70, 125, 32);
		contentPane.add(btnReportInsert);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-100, 0, 1550, 690);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\E  ZONE\\Desktop\\passsport\\Untitled-5.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		contentPane.add(lblNewLabel_1);
	}
}
