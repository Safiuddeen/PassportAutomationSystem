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
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class DocumentVerificationFram extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblimage_BC;
	private JTextField textFieldPasspotId;
	private JButton btnupdate;
	private JLabel lblimage_NIC;
	private JLabel lblimage_Applicant;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton_1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocumentVerificationFram frame = new DocumentVerificationFram();
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
	public DocumentVerificationFram() {
		setTitle("Document Verification Page");
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblimage_BC = new JLabel("");
		lblimage_BC.setBorder(new MatteBorder(6, 6, 6, 6, (Color) new Color(0, 0, 0)));
		lblimage_BC.setBackground(new Color(240, 240, 240));
		lblimage_BC.setBounds(35, 60, 300, 400);
		contentPane.add(lblimage_BC);
		
		lblimage_NIC = new JLabel("");
		lblimage_NIC.setBorder(new MatteBorder(6, 6, 6, 6, (Color) new Color(0, 0, 0)));
		lblimage_NIC.setBackground(new Color(240, 240, 240));
		lblimage_NIC.setBounds(375, 60, 300, 400);
		contentPane.add(lblimage_NIC);
		
		lblimage_Applicant = new JLabel("");
		lblimage_Applicant.setBorder(new MatteBorder(6, 6, 6, 6, (Color) new Color(0, 0, 0)));
		lblimage_Applicant.setBackground(new Color(240, 240, 240));
		lblimage_Applicant.setBounds(706, 60, 300, 400);
		contentPane.add(lblimage_Applicant);
		
		JLabel lblNewLabel = new JLabel("PassportID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(62, 471, 112, 39);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(45, 471, 141, 39);
		contentPane.add(panel);
		
		textFieldPasspotId = new JTextField();
		textFieldPasspotId.setBounds(210, 471, 193, 31);
		contentPane.add(textFieldPasspotId);
		textFieldPasspotId.setColumns(10);
		
		JButton btnNewButton = new JButton("Display");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminPanelClass apc=new AdminPanelClass();
				
				 String PassportID = textFieldPasspotId.getText();
				
				 apc.verifyTodisplayImages(PassportID, lblimage_BC, lblimage_NIC, lblimage_Applicant);
				
			}
		});
		btnNewButton.setBounds(441, 473, 95, 37);
		contentPane.add(btnNewButton);
		
	    btnupdate = new JButton("Update");
	    btnupdate.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		String Verification = comboBox.getSelectedItem().toString();
	            String PassportID = textFieldPasspotId.getText();
	            AdminPanelClass apc = new AdminPanelClass();
	            
	            if(apc.UpdateDocumentVerification(PassportID, Verification)) {
	            	int choice = JOptionPane.showConfirmDialog(rootPane, "Update Available! Do you want to update now?", "Update", JOptionPane.YES_NO_OPTION);
		            if (choice == JOptionPane.YES_OPTION) {
		            	JOptionPane.showMessageDialog(rootPane, "Update Successful!");
		                 AdminPanelFram apf=new AdminPanelFram();
		                 apf.setVisible(true);
		                 apf.setBounds(-8, 0, 1500, 690);
		                 dispose();
		            } else {
		            	JOptionPane.showMessageDialog(rootPane, "Invalid User PassportID !",PassportID, JOptionPane.ERROR_MESSAGE);
		            	
		            }
				}
	            
	            
	            
	    	}
	    });
		btnupdate.setBounds(787, 528, 105, 39);
		contentPane.add(btnupdate);
		
		JLabel lblNewLabel_2 = new JLabel("If Document are Correct ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(572, 471, 205, 39);
		contentPane.add(lblNewLabel_2);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setBounds(39, 11, 296, 38);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_3 = new JLabel("Birth Certificate");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(74, 0, 150, 38);
		panel_1.add(lblNewLabel_3);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(211, 211, 211));
		panel_2.setBounds(375, 11, 296, 38);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_4 = new JLabel("NIC");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(120, 0, 38, 38);
		panel_2.add(lblNewLabel_4);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(211, 211, 211));
		panel_3.setBounds(706, 11, 296, 38);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		lblNewLabel_5 = new JLabel("Applicant");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(115, 0, 87, 38);
		panel_3.add(lblNewLabel_5);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanelFram apf=new AdminPanelFram();
				apf.setVisible(true);
				apf.setBounds(-8, 0, 1500, 690);
				dispose();
			}
		});
		btnNewButton_1.setBounds(1137, 11, 89, 30);
		contentPane.add(btnNewButton_1);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Verified", "Un Verified", "Pending"}));
		comboBox.setBounds(787, 473, 227, 37);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-100, 0, 1550, 690);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\E  ZONE\\Desktop\\passsport\\Untitled-5.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		contentPane.add(lblNewLabel_1);
	}
}


