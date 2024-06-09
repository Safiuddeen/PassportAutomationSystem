package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class PoliceReportInsertFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNICin;
	private JTextField textFieldPassIDin;
	private JTextField textFieldUsernamein;
	private JTextField textFieldinsertImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PoliceReportInsertFrame frame = new PoliceReportInsertFrame();
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
	public PoliceReportInsertFrame() {
		setTitle("Police Report Insert Page");
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1131, 658);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setBounds(1159, 25, 89, 34);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PoliceReportFrame apf=new PoliceReportFrame();
				apf.setVisible(true);
				apf.setBounds(-8, 0, 1500, 690);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("NIC Number");
		lblNewLabel_2.setBounds(338, 104, 152, 34);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_2);
		
		textFieldNICin = new JTextField();
		textFieldNICin.setBounds(521, 104, 326, 34);
		textFieldNICin.setColumns(10);
		contentPane.add(textFieldNICin);
		
		JLabel lblNewLabel_2_1 = new JLabel("Passport ID");
		lblNewLabel_2_1.setBounds(338, 165, 152, 34);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_2_1);
		
		textFieldPassIDin = new JTextField();
		textFieldPassIDin.setBounds(521, 165, 326, 34);
		textFieldPassIDin.setColumns(10);
		contentPane.add(textFieldPassIDin);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("User Name");
		lblNewLabel_2_1_1.setBounds(338, 232, 152, 34);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_2_1_1);
		
		textFieldUsernamein = new JTextField();
		textFieldUsernamein.setBounds(521, 232, 326, 34);
		textFieldUsernamein.setColumns(10);
		contentPane.add(textFieldUsernamein);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Police Report");
		lblNewLabel_2_1_1_1.setBounds(338, 291, 152, 34);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(304, 102, 196, 226);
		panel_1.setBackground(new Color(217, 217, 217));
		contentPane.add(panel_1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String ID = textFieldPassIDin.getText();
				 String NICnum = textFieldNICin.getText();
			        String userName = textFieldUsernamein.getText();
			        String PR_FilePath = textFieldinsertImage.getText();
			        
			       
			        
			        // Check if any of the input fields are empty
			        if (ID.isEmpty() || userName.isEmpty() || NICnum.isEmpty() || PR_FilePath.isEmpty()) {
			            // If any field is empty, display a popup message
			            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Incomplete Data", JOptionPane.WARNING_MESSAGE);
			        } else {
			            // All fields are filled, proceed with submission
			        	 File PRFile = new File(PR_FilePath);
			            PoliceReportClass pr = new PoliceReportClass();
			           
			            pr.submitData(ID, userName, NICnum, PRFile);
			            // Display a confirmation message
			            JOptionPane.showMessageDialog(null, "Data submitted successfully.", "Submission Confirmation", JOptionPane.INFORMATION_MESSAGE);
			            textFieldPassIDin.setText("");
			            textFieldUsernamein.setText("");
			            textFieldNICin.setText("");
			            textFieldinsertImage.setText("");
			        }
			    }
				
				
			
		});
		btnSubmit.setBounds(553, 366, 104, 33);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnSubmit);
		
		JLabel lblPoliceReportInsert = new JLabel("Police Report Insert");
		lblPoliceReportInsert.setBounds(23, 11, 284, 39);
		lblPoliceReportInsert.setForeground(Color.WHITE);
		lblPoliceReportInsert.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblPoliceReportInsert);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 295, 59);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		
		textFieldinsertImage = new JTextField();
		textFieldinsertImage.setColumns(10);
		textFieldinsertImage.setBounds(521, 291, 326, 34);
		contentPane.add(textFieldinsertImage);
		
		JButton btnChose = new JButton("Chose");
		btnChose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        int userSelection = fileChooser.showOpenDialog(PoliceReportInsertFrame.this);

		        if (userSelection == JFileChooser.APPROVE_OPTION) {
		            File fileToUpload = fileChooser.getSelectedFile();
		            String filePath = fileToUpload.getAbsolutePath();
		            textFieldinsertImage.setText(filePath);
		        }
			}
				
			
		});
		btnChose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnChose.setBounds(857, 292, 104, 33);
		contentPane.add(btnChose);
		
	
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-100, 0, 1550, 690);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\E  ZONE\\Desktop\\passsport\\Untitled-5.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		contentPane.add(lblNewLabel_1);
	}
}
