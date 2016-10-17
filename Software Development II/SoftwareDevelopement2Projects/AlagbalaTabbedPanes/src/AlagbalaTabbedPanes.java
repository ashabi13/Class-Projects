import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class AlagbalaTabbedPanes extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel pnlName;
	private JPanel pnlPrint;
	private JLabel lblName;
	private JTextField nameTF;
	private JLabel lblNamePrint;
	private JLabel lblStreet;
	private JTextField streetTF;
	private JLabel lblZipCode;
	private JTextField zipTF;
	private JLabel lblCity;
	private JTextField cityTF;
	private JLabel lblState;
	private JTextField stateTF;
	private JLabel lblStreetPrint;
	private JLabel lblZipPrint;
	private JLabel lblStatePrint;
	private JLabel lblCityPrint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlagbalaTabbedPanes frame = new AlagbalaTabbedPanes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AlagbalaTabbedPanes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tabbedPane.setBounds(6, 25, 438, 247);
		contentPane.add(tabbedPane);
		
		pnlName = new JPanel();
		tabbedPane.addTab("Name", null, pnlName, null);
		pnlName.setLayout(null);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(6, 32, 112, 26);
		pnlName.add(lblName);
		
		nameTF = new JTextField();
		nameTF.setBounds(72, 32, 339, 26);
		pnlName.add(nameTF);
		nameTF.setColumns(10);
		
		lblStreet = new JLabel("Street:");
		lblStreet.setBounds(6, 84, 61, 16);
		pnlName.add(lblStreet);
		
		streetTF = new JTextField();
		streetTF.setBounds(82, 79, 329, 26);
		pnlName.add(streetTF);
		streetTF.setColumns(10);
		
		lblZipCode = new JLabel("Zip Code:");
		lblZipCode.setBounds(6, 122, 61, 16);
		pnlName.add(lblZipCode);
		
		zipTF = new JTextField();
		zipTF.setBounds(72, 117, 70, 26);
		pnlName.add(zipTF);
		zipTF.setColumns(10);
		
		lblCity = new JLabel("City:");
		lblCity.setBounds(143, 122, 43, 16);
		pnlName.add(lblCity);
		
		cityTF = new JTextField();
		cityTF.setBounds(173, 117, 130, 26);
		pnlName.add(cityTF);
		cityTF.setColumns(10);
		
		lblState = new JLabel("State:");
		lblState.setBounds(315, 122, 43, 16);
		pnlName.add(lblState);
		
		stateTF = new JTextField();
		stateTF.setBounds(362, 117, 49, 26);
		pnlName.add(stateTF);
		stateTF.setColumns(10);
		
		pnlPrint = new JPanel();
		tabbedPane.addTab("Print", null, pnlPrint, null);
		pnlPrint.setLayout(null);
		
		lblNamePrint = new JLabel("Name:");
		lblNamePrint.setBounds(74, 6, 302, 32);
		pnlPrint.add(lblNamePrint);
		
		lblStreetPrint = new JLabel("Street:");
		lblStreetPrint.setBounds(38, 62, 338, 16);
		pnlPrint.add(lblStreetPrint);
		
		lblZipPrint = new JLabel("Zip:");
		lblZipPrint.setBounds(38, 109, 61, 16);
		pnlPrint.add(lblZipPrint);
		
		lblStatePrint = new JLabel("State:");
		lblStatePrint.setBounds(328, 109, 48, 16);
		pnlPrint.add(lblStatePrint);
		
		lblCityPrint = new JLabel("City:");
		lblCityPrint.setBounds(126, 109, 175, 16);
		pnlPrint.add(lblCityPrint);
		
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_stateChanged_pnlName(e);
			}
		});
	}

	protected void do_stateChanged_pnlName(ChangeEvent e) {
		if(!nameTF.getText().isEmpty()){
			lblNamePrint.setForeground(Color.BLACK);
			lblNamePrint.setText("Name: "+nameTF.getText());
		}
		else {
			lblNamePrint.setForeground(Color.RED);
			lblNamePrint.setText("Name: ");
		}
		if(!streetTF.getText().isEmpty()){
			lblStreetPrint.setForeground(Color.BLACK);
			lblStreetPrint.setText("Street: "+streetTF.getText());
		}
		else {
			lblStreetPrint.setForeground(Color.RED);
			lblStreetPrint.setText("Street: ");
		}
		if(!zipTF.getText().isEmpty()){
			lblZipPrint.setForeground(Color.BLACK);
			lblZipPrint.setText("Zip: "+zipTF.getText());
		}
		else {
			lblZipPrint.setForeground(Color.RED);
			lblZipPrint.setText("Zip: ");
		}
		if(!stateTF.getText().isEmpty()){
			lblStatePrint.setForeground(Color.BLACK);
			lblStatePrint.setText("State: "+stateTF.getText());
		}
		else {
			lblStatePrint.setForeground(Color.RED);
			lblStatePrint.setText("State: ");
		}
		if(!cityTF.getText().isEmpty()){
			lblCityPrint.setForeground(Color.BLACK);
			lblCityPrint.setText("Name: "+cityTF.getText());
		}
		else {
			lblCityPrint.setForeground(Color.RED);
			lblCityPrint.setText("Name: ");
		}
		
	}
}
