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

public class ApplicantLoginCreateFram extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textName;
	private JTextField textMobilNum;
	private JTextField textEmail;
	private JPasswordField passwordField;
	private JPasswordField CApassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicantLoginCreateFram frame = new ApplicantLoginCreateFram();
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
	public ApplicantLoginCreateFram() {
		setTitle("User Rejistration");
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
		panel.setBounds(250, 70, 760, 530);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Create Account");
		lblNewLabel_2.setBounds(103, 11, 514, 90);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 56));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		
		JButton create = new JButton("Create");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String UserName=textName.getText();
				String MobilNumber=textMobilNum.getText();
				String E_mail=textEmail.getText();
				String Password=CApassword.getText();
				
				int I=Integer.parseInt(MobilNumber);
				
				ApplicantLoginClass apl=new ApplicantLoginClass(); 
				if(apl.CreateAccount(UserName,I,E_mail,Password)) {	
				//popup massage
					JOptionPane.showMessageDialog(rootPane,"Your Account create Successfully");
					JOptionPane.showMessageDialog(rootPane,"You can successfuly login with 'User login'");
					textName.setText("");
					textMobilNum.setText("");
					textEmail.setText("");
					CApassword.setText("");
				}else {	
				
				
		
				JOptionPane.showMessageDialog(rootPane,"Your Account create Unsuccessfully");
				}
			}
		});
		create.setForeground(new Color(255, 255, 255));
		create.setBackground(new Color(169, 24, 143));
		create.setFont(new Font("Tahoma", Font.BOLD, 18));
		create.setBounds(324, 445, 126, 43);
		panel.add(create);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(211, 248, 119, 26);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile Number");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(211, 292, 147, 26);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\E  ZONE\\Desktop\\passsport\\Untitled-4.png"));
		lblNewLabel_4.setBounds(324, 99, 119, 102);
		panel.add(lblNewLabel_4);
		
		JButton CAbackbutton = new JButton("Back");
		CAbackbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePageFram hm=new HomePageFram ();
				hm.setBounds(-8, 0, 1500, 690);
				hm.setVisible(true);
				dispose();
				
			}
		});
		CAbackbutton.setForeground(new Color(255, 255, 255));
		CAbackbutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		CAbackbutton.setBackground(new Color(0, 0, 0));
		CAbackbutton.setBounds(661, 11, 89, 28);
		panel.add(CAbackbutton);
		
		JLabel lblNewLabel_3_1 = new JLabel("E-mail ");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1.setBounds(211, 342, 119, 26);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Password");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_1.setBounds(211, 390, 119, 26);
		panel.add(lblNewLabel_3_1_1);
		
		textName = new JTextField();
		textName.setBounds(383, 248, 211, 26);
		panel.add(textName);
		textName.setColumns(10);
		
		textMobilNum = new JTextField();
		textMobilNum.setColumns(10);
		textMobilNum.setBounds(383, 292, 211, 26);
		panel.add(textMobilNum);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(383, 342, 211, 26);
		panel.add(textEmail);
		
		CApassword = new JPasswordField();
		CApassword.setBounds(383, 390, 211, 26);
		panel.add(CApassword);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\E  ZONE\\Desktop\\passsport\\Untitled-5.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_1.setBounds(-100, 0, 1550, 690);
		contentPane.add(lblNewLabel_1);
	}
	
}