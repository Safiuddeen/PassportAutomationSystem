package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.FlowLayout;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JTextField;

public class UploaddocumentFram extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final String IDnum = null;
	private JPanel contentPane;
	private JTextField textFieldBc;
	private JTextField textIdimage;
	private JTextField textAppimage;
	private String NICNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploaddocumentFram frame = new UploaddocumentFram(IDnum);
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
	public UploaddocumentFram(String NICNum) {
		this.NICNum=NICNum;
		setTitle("Home Page");
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1146, 690);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  Upload Document");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(165, 11, 201, 38);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(128, 128, 128,100));
		panel.setBackground(new Color(128, 128, 128,100));
		panel.setBounds(165, 11, 933, 523);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel(" BirthCertificate ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(57, 121, 205, 34);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Id imge ( *borth side)");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(57, 191, 205, 34);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Applicant image");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1_1.setBounds(57, 261, 205, 34);
		panel.add(lblNewLabel_2_1_1);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicantLoginFram ap=new ApplicantLoginFram();
				ap.setBounds(-8, 0, 1500, 690);
				ap.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(844, 0, 89, 28);
		panel.add(btnNewButton_1);
		
		//birthCertificate File chooser
		JButton btnBCButton = new JButton("Choose File");
		btnBCButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 JFileChooser fileChooser = new JFileChooser();
			        int userSelection = fileChooser.showOpenDialog(UploaddocumentFram.this);

			        if (userSelection == JFileChooser.APPROVE_OPTION) {
			            File fileToUpload = fileChooser.getSelectedFile();
			            String filePath = fileToUpload.getAbsolutePath();
			            textFieldBc.setText(filePath);
			        }
			    }
		});
		btnBCButton.setBounds(635, 124, 136, 34);
		panel.add(btnBCButton);
		
		textFieldBc = new JTextField();
		textFieldBc.setBounds(315, 121, 310, 34);
		panel.add(textFieldBc);
		textFieldBc.setColumns(10);
		
		JButton btnuploadButton = new JButton("Upload Document");
		btnuploadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

		        // Get file paths from text fields
		        String bcFilePath = textFieldBc.getText();
		        String idImageFilePath = textIdimage.getText();
		        String appImageFilePath = textAppimage.getText();
		        
		        UploadDocumentClass udc=new  UploadDocumentClass();

		        // Check if all fields are filled
		        if (!bcFilePath.isEmpty() && !idImageFilePath.isEmpty() && !appImageFilePath.isEmpty()) {
		            // Upload images to the database
		            File bcFile = new File(bcFilePath);
		            File idImageFile = new File(idImageFilePath);
		            File appImageFile = new File(appImageFilePath);

		            udc.uploadImageToDataBase(NICNum,bcFile,idImageFile,appImageFile);
		           

		            JOptionPane.showMessageDialog(UploaddocumentFram.this, "Images uploaded successfully!");
		            textFieldBc.setText("");
		            textIdimage.setText("");
		            textAppimage.setText("");
		        } else {
		            JOptionPane.showMessageDialog(UploaddocumentFram.this, "Please choose all files.");
		        }
		    }
		});
		btnuploadButton.setBounds(701, 433, 89, 34);
		panel.add(btnuploadButton);
		
		textIdimage = new JTextField();
		textIdimage.setColumns(10);
		textIdimage.setBounds(315, 191, 310, 34);
		panel.add(textIdimage);
		
		textAppimage = new JTextField();
		textAppimage.setColumns(10);
		textAppimage.setBounds(315, 261, 310, 34);
		panel.add(textAppimage);
		
		//NIC File Chooser
		JButton btnIdimage = new JButton("Choose File");
		btnIdimage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser fileChooser = new JFileChooser();
			        int userSelection = fileChooser.showOpenDialog(UploaddocumentFram.this);

			        if (userSelection == JFileChooser.APPROVE_OPTION) {
			            File fileToUpload = fileChooser.getSelectedFile();
			            String filePath = fileToUpload.getAbsolutePath();
			            textIdimage.setText(filePath);
			        }
			    }
		});
		btnIdimage.setBounds(638, 191, 136, 34);
		panel.add(btnIdimage);
		
		//Applicant image Chooser
		JButton btnAppimage = new JButton("Choose File");
		btnAppimage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        int userSelection = fileChooser.showOpenDialog(UploaddocumentFram.this);

		        if (userSelection == JFileChooser.APPROVE_OPTION) {
		            File fileToUpload = fileChooser.getSelectedFile();
		            String filePath = fileToUpload.getAbsolutePath();
		            textAppimage.setText(filePath);
		        }
			}
		});
		btnAppimage.setBounds(635, 261, 136, 34);
		panel.add(btnAppimage);
		
		JLabel lblNewLabel_4 = new JLabel("** The report verifing date you should have these documents**,");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(30, 322, 730, 25);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("1. Id photocpy ");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_5.setBounds(50, 358, 160, 18);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("2. Applicant photo ( with reference number)");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7.setBounds(217, 358, 390, 18);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("3. Birth sertificate original (within 6 month)");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_6.setBounds(43, 392, 399, 18);
		panel.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(165, 11, 201, 38);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\E  ZONE\\Desktop\\passsport\\Untitled-5.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_1.setBounds(-100, 0, 1550, 690);
		contentPane.add(lblNewLabel_1);
	}
}
