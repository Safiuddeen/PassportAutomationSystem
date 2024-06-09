package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import project.HomePageFram;
import project.ApplicantLoginClass;

public class ApplicantLoginFram extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField inputUserName;
	private JPasswordField passwordField;
	private JPasswordField inputpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicantLoginFram frame = new ApplicantLoginFram();
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
	public ApplicantLoginFram() {
		setTitle("User login");
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1044, 622);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(128, 128, 128,100));
		panel.setBackground(new Color(128, 128, 128,100));
		panel.setBounds(250, 75, 760, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("User Login");
		lblNewLabel_2.setBounds(179, 11, 360, 96);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 56));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		
		JButton btnNewButton = new JButton("Login !!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			       String UserName=inputUserName.getText();
			       String Password=inputpassword.getText();
			       
			       ApplicantLoginClass apl=new ApplicantLoginClass();
			       
			       if (apl.applicantsignin(UserName, Password)) {
			            JOptionPane.showMessageDialog(rootPane, "Login Successful!");
			            // Add code to open the main application window or perform further actions
			            PassportApplicationFram paf=new PassportApplicationFram();
			            paf.setBounds(-8, 0, 1500, 690);
			            paf.setVisible(true);
			            dispose();
			        } else {
			            JOptionPane.showMessageDialog(rootPane, "Invalid username or password");
			        }
			       
			      
			    }
				
				
			
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 160));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(324, 395, 126, 43);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(245, 246, 119, 26);
		panel.add(lblNewLabel);
		
		inputUserName = new JTextField();
		inputUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		inputUserName.setBounds(374, 246, 173, 28);
		panel.add(inputUserName);
		inputUserName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(245, 309, 119, 26);
		panel.add(lblNewLabel_3);
		
		inputpassword = new JPasswordField();
		inputpassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		inputpassword.setBounds(374, 309, 173, 26);
		panel.add(inputpassword);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\E  ZONE\\Desktop\\passsport\\Untitled-2.png"));
		lblNewLabel_4.setBounds(324, 112, 119, 96);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HomePageFram hm=new HomePageFram ();
				hm.setBounds(-8, 0, 1500, 690);
				hm.setVisible(true);
				
				dispose();
				}
			

			
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(661, 11, 89, 28);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\E  ZONE\\Desktop\\passsport\\Untitled-5.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_1.setBounds(-100, 0, 1550, 690);
		contentPane.add(lblNewLabel_1);
	}
}
