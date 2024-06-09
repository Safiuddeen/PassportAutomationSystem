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

import project.AdminLoginClass;



public class HomePageFram extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePageFram frame = new HomePageFram();
					frame.setVisible(true);
					frame.setBounds(-8,0, 1500, 690);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePageFram() {
		setTitle("Home Page");
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1044, 660);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(128, 128, 128,100));
		panel.setBackground(new Color(128, 128, 128,100));
		panel.setBounds(250, 42, 760, 540);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("WELCOME !!!");
		lblNewLabel_2.setBounds(176, 11, 424, 77);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 56));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("TO PASSPORT SYSTEM.");
		lblNewLabel.setBounds(24, 72, 726, 84);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 51));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicantLoginFram alf=new ApplicantLoginFram();
				alf.setBounds(-8,0, 1500, 690);
				alf.setVisible(true);
				dispose();
				
				
			
			}
		});
		btnNewButton.setForeground(new Color(220, 20, 60));
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(295, 189, 126, 43);
		panel.add(btnNewButton);
		
		JLabel lableMouseClik = new JLabel("Don't have an account?");
		lableMouseClik.setForeground(new Color(255, 255, 255));
		lableMouseClik.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 21));
		lableMouseClik.setBackground(UIManager.getColor("Button.background"));
		lableMouseClik.setBounds(161, 282, 260, 24);
		panel.add(lableMouseClik);
		
		JLabel lblClickHear = new JLabel("Create account");
		lblClickHear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ApplicantLoginCreateFram acf=new ApplicantLoginCreateFram();
				acf.setBounds(-8,0, 1500, 690);
				acf.setVisible(true);
				dispose();
				
			}
		});
		lblClickHear.setForeground(new Color(255, 255, 0));
		lblClickHear.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 21));
		lblClickHear.setBounds(424, 283, 176, 24);
		panel.add(lblClickHear);
		
		JLabel lblClickHear_1 = new JLabel("Click here");
		lblClickHear_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminFram adf=new AdminFram();
				adf.setBounds(-8,0, 1500, 690);
				adf.setVisible(true);
				dispose();
			}
		});
		lblClickHear_1.setForeground(new Color(255, 0, 0));
		lblClickHear_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 21));
		lblClickHear_1.setBounds(424, 333, 157, 24);
		panel.add(lblClickHear_1);
		
		JLabel lblAdminLogin = new JLabel("Admin user login :");
		lblAdminLogin.setForeground(new Color(255, 255, 255));
		lblAdminLogin.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 21));
		lblAdminLogin.setBackground(UIManager.getColor("Button.background"));
		lblAdminLogin.setBounds(176, 333, 213, 24);
		panel.add(lblAdminLogin);
		
		JLabel lblNewLabel_3 = new JLabel("*if you are admin in this system");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBounds(118, 312, 260, 24);
		panel.add(lblNewLabel_3);
		
		JButton btnViewStatus = new JButton("View Status");
		btnViewStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStatusFram vsf=new ViewStatusFram();
				vsf.setBounds(-8, 0, 1500, 690);
				vsf.setVisible(true);
				dispose();
			}
		});
		btnViewStatus.setForeground(new Color(220, 20, 60));
		btnViewStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnViewStatus.setBackground(UIManager.getColor("Button.background"));
		btnViewStatus.setBounds(295, 391, 157, 31);
		panel.add(btnViewStatus);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
		        if (option == JOptionPane.YES_OPTION) {
		            dispose(); // Close the current window if "Yes" is clicked
		        }
		    }
		});
		btnExit.setForeground(new Color(220, 20, 60));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBackground(UIManager.getColor("Button.background"));
		btnExit.setBounds(295, 454, 157, 37);
		panel.add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\E  ZONE\\Desktop\\passsport\\Untitled-5.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_1.setBounds(-100, 0, 1550, 690);
		contentPane.add(lblNewLabel_1);
	}
}