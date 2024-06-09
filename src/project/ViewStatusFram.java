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
import javax.swing.border.MatteBorder;

public class ViewStatusFram extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNICNum;
	private JTextField textFieldPassportID;
	private JTextField textFieldusername;
	private JTextField textFieldDateOfBirth;
	private JTextField textFieldGender;
	private JTextField textFieldAddress;
	private JTextField textFieldMobilNumber;
	private JTextField textFieldDocumentdate;
	private JTextField textFieldVerification;
	private JTextField textFieldPassportStatus;
	private JTextField textFieldAbout;
	private JTextField textFieldPoliceReport;
	private JLabel lblimage_Applicant1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStatusFram frame = new ViewStatusFram();
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
	public ViewStatusFram() {
		setTitle("View Status");
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1214, 653);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNICNum = new JTextField();
		textFieldNICNum.setFont(new Font("Tahoma", Font.BOLD, 19));
		textFieldNICNum.setBounds(194, 42, 210, 29);
		contentPane.add(textFieldNICNum);
		textFieldNICNum.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NICNumber");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(21, 42, 140, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("View Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String NICNum = textFieldNICNum.getText(); 
				
				
				AdminPanelClass pac=new AdminPanelClass();
				pac.retrieveDataFromDatabase(NICNum,lblimage_Applicant1);
				pac.reretrieveDetailsFromDatabase(NICNum,textFieldPassportID,textFieldusername,textFieldDateOfBirth,textFieldGender,textFieldAddress,textFieldMobilNumber,
						textFieldDocumentdate,textFieldVerification,textFieldPoliceReport,textFieldPassportStatus,textFieldAbout);
				
				
			}
		});
		btnNewButton.setBounds(429, 42, 112, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
		        if (option == JOptionPane.YES_OPTION) {
		            dispose(); // Close the current window if "Yes" is clicked
		        }
		    }
		});
		btnNewButton_1.setBounds(1101, 31, 89, 29);
		contentPane.add(btnNewButton_1);
		
		lblimage_Applicant1 = new JLabel("");
		lblimage_Applicant1.setBorder(new MatteBorder(6, 6, 6, 6, (Color) new Color(0, 0, 0)));
		lblimage_Applicant1.setBackground(UIManager.getColor("Button.background"));
		lblimage_Applicant1.setBounds(31, 82, 300, 300);
		contentPane.add(lblimage_Applicant1);
		
		JLabel PassportID = new JLabel("PassportID");
		PassportID.setFont(new Font("Tahoma", Font.BOLD, 21));
		PassportID.setBounds(356, 82, 185, 29);
		contentPane.add(PassportID);
		
		textFieldPassportID = new JTextField();
		textFieldPassportID.setFont(new Font("Tahoma", Font.BOLD, 19));
		textFieldPassportID.setColumns(10);
		textFieldPassportID.setBounds(562, 82, 210, 29);
		contentPane.add(textFieldPassportID);
		
		JLabel lblUsername = new JLabel("UserFullName");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblUsername.setBounds(356, 132, 185, 29);
		contentPane.add(lblUsername);
		
		textFieldusername = new JTextField();
		textFieldusername.setFont(new Font("Tahoma", Font.BOLD, 19));
		textFieldusername.setColumns(10);
		textFieldusername.setBounds(562, 132, 210, 29);
		contentPane.add(textFieldusername);
		
		JLabel lblDateOfBirth = new JLabel("DateOfBirth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblDateOfBirth.setBounds(356, 181, 185, 29);
		contentPane.add(lblDateOfBirth);
		
		textFieldDateOfBirth = new JTextField();
		textFieldDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 19));
		textFieldDateOfBirth.setColumns(10);
		textFieldDateOfBirth.setBounds(562, 181, 210, 29);
		contentPane.add(textFieldDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblGender.setBounds(356, 242, 185, 29);
		contentPane.add(lblGender);
		
		textFieldGender = new JTextField();
		textFieldGender.setFont(new Font("Tahoma", Font.BOLD, 19));
		textFieldGender.setColumns(10);
		textFieldGender.setBounds(562, 242, 210, 29);
		contentPane.add(textFieldGender);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblAddress.setBounds(356, 295, 185, 29);
		contentPane.add(lblAddress);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setFont(new Font("Tahoma", Font.BOLD, 19));
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(562, 295, 210, 29);
		contentPane.add(textFieldAddress);
		
		JLabel lblMobilNumber = new JLabel(" MobilNumber");
		lblMobilNumber.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblMobilNumber.setBounds(356, 353, 185, 29);
		contentPane.add(lblMobilNumber);
		
		textFieldMobilNumber = new JTextField();
		textFieldMobilNumber.setFont(new Font("Tahoma", Font.BOLD, 19));
		textFieldMobilNumber.setColumns(10);
		textFieldMobilNumber.setBounds(562, 353, 210, 29);
		contentPane.add(textFieldMobilNumber);
		
		JLabel Documentdate = new JLabel("Doc.veri.date");
		Documentdate.setFont(new Font("Tahoma", Font.BOLD, 21));
		Documentdate.setBounds(799, 82, 171, 29);
		contentPane.add(Documentdate);
		
		textFieldDocumentdate = new JTextField();
		textFieldDocumentdate.setFont(new Font("Tahoma", Font.BOLD, 19));
		textFieldDocumentdate.setColumns(10);
		textFieldDocumentdate.setBounds(980, 82, 210, 29);
		contentPane.add(textFieldDocumentdate);
		
		JLabel lblVerification = new JLabel("Verification");
		lblVerification.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblVerification.setBounds(799, 132, 171, 29);
		contentPane.add(lblVerification);
		
		textFieldVerification = new JTextField();
		textFieldVerification.setFont(new Font("Tahoma", Font.BOLD, 19));
		textFieldVerification.setColumns(10);
		textFieldVerification.setBounds(980, 132, 210, 29);
		contentPane.add(textFieldVerification);
		
		JLabel lblPoliceReport = new JLabel(" PoliceReport");
		lblPoliceReport.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPoliceReport.setBounds(799, 181, 171, 29);
		contentPane.add(lblPoliceReport);
		
		textFieldPoliceReport = new JTextField();
		textFieldPoliceReport.setFont(new Font("Tahoma", Font.BOLD, 19));
		textFieldPoliceReport.setColumns(10);
		textFieldPoliceReport.setBounds(980, 181, 210, 29);
		contentPane.add(textFieldPoliceReport);
		
		JLabel lblPassportStatus = new JLabel("PassportStatus");
		lblPassportStatus.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPassportStatus.setBounds(799, 242, 171, 29);
		contentPane.add(lblPassportStatus);
		
		textFieldPassportStatus = new JTextField();
		textFieldPassportStatus.setFont(new Font("Tahoma", Font.BOLD, 19));
		textFieldPassportStatus.setColumns(10);
		textFieldPassportStatus.setBounds(980, 242, 210, 29);
		contentPane.add(textFieldPassportStatus);
		
		JLabel lblAbout = new JLabel("About");
		lblAbout.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblAbout.setBounds(799, 295, 171, 29);
		contentPane.add(lblAbout);
		
		textFieldAbout = new JTextField();
		textFieldAbout.setFont(new Font("Tahoma", Font.BOLD, 19));
		textFieldAbout.setColumns(10);
		textFieldAbout.setBounds(980, 295, 210, 87);
		contentPane.add(textFieldAbout);
		
		JButton btnNewButton_1_1 = new JButton("BACK");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePageFram hpf=new HomePageFram();
				hpf.setVisible(true);
				hpf.setBounds(-8, 0, 1500, 690);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(980, 31, 89, 29);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-100, 0, 1550, 690);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\E  ZONE\\Desktop\\passsport\\Untitled-5.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		contentPane.add(lblNewLabel_1);
	}
}