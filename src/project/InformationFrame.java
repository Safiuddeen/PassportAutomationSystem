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
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;

public class InformationFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldPassID;
	private JTextField textFieldusername;
	private JTextField textFieldNIC;
	private JTextField textFieldMobil;
	private JTextField textFieldPassStatus;
	private JComboBox comboBoxAbout;
	private JTextField textFieldAbout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformationFrame frame = new InformationFrame();
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
	public InformationFrame() {
		setTitle("Information frame");
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1259, 658);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(409, 70, 859, 413);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PassportID", "UserFullName", " NICNumber", "MobilNumber", "PassportStatus", "About"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(84);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		scrollPane.setViewportView(table);
		
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//to display the data to table 
				InformationClass in=new InformationClass();
				in.DisplayInfodataTable(table);
			}
		});
		btnDisplay.setBounds(408, 494, 99, 31);
		contentPane.add(btnDisplay);
		//if click auto generate for texfeild
		 table.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
	         public void valueChanged(ListSelectionEvent e) {
	             if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
	                 int selectedRow = table.getSelectedRow();
	                 fillFieldsFromSelectedRow(selectedRow);
	             }
	         }

	         private void fillFieldsFromSelectedRow(int selectedRow) {
	             textFieldPassID.setText(getValueAsString(selectedRow, 0)); // PassportID
	             textFieldusername.setText(getValueAsString(selectedRow, 1)); // UserFullName
	             textFieldNIC.setText(getValueAsString(selectedRow, 2)); // NICNumber
	             textFieldMobil.setText(getValueAsString(selectedRow, 3));//MobilNumber
	             textFieldPassStatus.setText(getValueAsString(selectedRow, 4)); // PassportStatus
	             textFieldAbout.setText(getValueAsString(selectedRow, 5));
	         }

	         private String getValueAsString(int row, int column) {
	             Object value = table.getValueAt(row, column);
	             return (value != null) ? value.toString() : "";
	         }
		 });
		
		JLabel PassportID = new JLabel("PassportID");
		PassportID.setForeground(Color.BLACK);
		PassportID.setFont(new Font("Tahoma", Font.BOLD, 16));
		PassportID.setBounds(10, 70, 140, 38);
		contentPane.add(PassportID);
		
		textFieldPassID = new JTextField();
		textFieldPassID.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldPassID.setColumns(10);
		textFieldPassID.setBounds(179, 71, 191, 38);
		contentPane.add(textFieldPassID);
		
		JLabel lbluserName = new JLabel("UserFullName");
		lbluserName.setForeground(Color.BLACK);
		lbluserName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbluserName.setBounds(10, 119, 140, 38);
		contentPane.add(lbluserName);
		
		textFieldusername = new JTextField();
		textFieldusername.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldusername.setColumns(10);
		textFieldusername.setBounds(179, 118, 191, 42);
		contentPane.add(textFieldusername);
		
		JLabel lblNewLabelNIC = new JLabel("NICNumber");
		lblNewLabelNIC.setForeground(Color.BLACK);
		lblNewLabelNIC.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabelNIC.setBounds(10, 168, 140, 38);
		contentPane.add(lblNewLabelNIC);
		
		textFieldNIC = new JTextField();
		textFieldNIC.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldNIC.setColumns(10);
		textFieldNIC.setBounds(179, 169, 191, 38);
		contentPane.add(textFieldNIC);
		
		JLabel lblMobilNum = new JLabel("Mobil Number");
		lblMobilNum.setForeground(Color.BLACK);
		lblMobilNum.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMobilNum.setBounds(10, 217, 140, 38);
		contentPane.add(lblMobilNum);
		
		textFieldMobil = new JTextField();
		textFieldMobil.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldMobil.setColumns(10);
		textFieldMobil.setBounds(179, 218, 191, 38);
		contentPane.add(textFieldMobil);
		
		JLabel PassportStatus = new JLabel("PassportStatus");
		PassportStatus.setForeground(Color.BLACK);
		PassportStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		PassportStatus.setBounds(10, 272, 140, 38);
		contentPane.add(PassportStatus);
		
		textFieldPassStatus = new JTextField();
		textFieldPassStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldPassStatus.setColumns(10);
		textFieldPassStatus.setBounds(179, 273, 191, 38);
		contentPane.add(textFieldPassStatus);
		
		JLabel PassportAbout = new JLabel("About");
		PassportAbout.setForeground(Color.BLACK);
		PassportAbout.setFont(new Font("Tahoma", Font.BOLD, 16));
		PassportAbout.setBounds(10, 325, 63, 38);
		contentPane.add(PassportAbout);
		
		JLabel lblNewLabel = new JLabel("   Information Panel");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 0, 277, 52);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 389, 483);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Send SMS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=textFieldusername.getText();
				String MobilNum=textFieldMobil.getText();
				String PassportId=textFieldPassID.getText();
				String About=comboBoxAbout.getSelectedItem().toString();
				//create the methos for send SMS
				InformationClass in=new InformationClass();
				
				if (in.SendSMS(PassportId,About)) {
		            int choice = JOptionPane.showConfirmDialog(rootPane, "Send SMS! Do you want to Send SMS?", "Send", JOptionPane.YES_NO_OPTION);
		            if (choice == JOptionPane.YES_OPTION) {
		            	JOptionPane.showMessageDialog(rootPane, "Successfully send SMS to,'"+username+"','"+MobilNum+"'");
		                // Add your update logic here
		            } else {
		                // User clicked No or closed the dialog, do nothing or handle accordingly
		            }
				}
				
			}
		});
		btnNewButton_1.setBounds(133, 431, 100, 41);
		panel.add(btnNewButton_1);
		
	    comboBoxAbout = new JComboBox();
	    comboBoxAbout.setBounds(10, 376, 369, 31);
	    panel.add(comboBoxAbout);
	    comboBoxAbout.setModel(new DefaultComboBoxModel(new String[] {"", "Your Passport is pending.", "Your Passport Successfully created , It will hand over by Post in 14 Days. ", "Your Passport have Police report Issuse,wait 2days to complet the process"}));
	    
	    textFieldAbout = new JTextField();
	    textFieldAbout.setFont(new Font("Tahoma", Font.PLAIN, 13));
	    textFieldAbout.setColumns(10);
	    textFieldAbout.setBounds(85, 327, 282, 38);
	    panel.add(textFieldAbout);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-100, 0, 1550, 690);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\E  ZONE\\Desktop\\passsport\\Untitled-5.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		contentPane.add(lblNewLabel_1);
	}
}
