import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AlagbalaInputMasksFrame extends JFrame {

	private JPanel contentPane;
	
	
	MaskFormatter numberMask = createFormatter("####");
	MaskFormatter socialMask = createFormatter("###-##-####");
	MaskFormatter phoneMask = createFormatter("###-###-####");
	MaskFormatter stateMask = createFormatter("UU");
	
	private JLabel lblNumber;
	private JFormattedTextField numberFTF;
	private JLabel lblSsn;
	private JFormattedTextField socialFTF;
	private JLabel lblPhone;
	private JFormattedTextField phoneFTF;
	private JLabel lblState;
	private JFormattedTextField stateFTF;
	private JLabel lblNumberOutput;
	private JLabel lblSsnOutput;
	private JLabel lblPhoneOutput;
	private JLabel lblStateOutput;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlagbalaInputMasksFrame frame = new AlagbalaInputMasksFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//place this code after main()

	public MaskFormatter createFormatter(String s) {
	     MaskFormatter formatter = null;
	     try {
	          formatter = new MaskFormatter(s);
	         } 
	     catch (java.text.ParseException exc) {
		          System.err.println("formatter is bad: " + exc.getMessage());
		          System.exit(-1);
		      }
	      return formatter;
	}//createFormatter
	/**
	 * Create the frame.
	 */
	public AlagbalaInputMasksFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNumber = new JLabel("Number:");
		lblNumber.setBounds(34, 57, 61, 16);
		contentPane.add(lblNumber);
		
		numberFTF = new JFormattedTextField();
		numberFTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_focusLost_numberFTF(e);
			}
		});
		numberFTF.setBounds(107, 52, 142, 26);
		
		numberMask.setPlaceholderCharacter('#');
		numberMask.install(numberFTF);
		contentPane.add(numberFTF);
		
		lblSsn = new JLabel("SSN:");
		lblSsn.setBounds(34, 101, 28, 16);
		contentPane.add(lblSsn);
		
		socialFTF = new JFormattedTextField();
		socialFTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_focusLost_socialFTF(e);
			}
		});
		socialFTF.setBounds(85, 96, 164, 26);
		
		socialMask.setPlaceholderCharacter('#');
		socialMask.install(socialFTF);
		contentPane.add(socialFTF);
		
		lblPhone = new JLabel("Phone #:");
		lblPhone.setBounds(34, 146, 61, 16);
		contentPane.add(lblPhone);
		
		phoneFTF = new JFormattedTextField();
		phoneFTF.setBounds(107, 141, 142, 26);
		
		phoneMask.setPlaceholderCharacter('#');
		phoneMask.install(phoneFTF);
		contentPane.add(phoneFTF);
		
		lblState = new JLabel("State:");
		lblState.setBounds(34, 191, 61, 16);
		contentPane.add(lblState);
		
		stateFTF = new JFormattedTextField();
		stateFTF.setBounds(151, 186, 98, 26);
		
		stateMask.setPlaceholderCharacter('U');
		stateMask.install(stateFTF);
		contentPane.add(stateFTF);
		
		lblNumberOutput = new JLabel("Number Output");
		lblNumberOutput.setBounds(261, 57, 109, 16);
		contentPane.add(lblNumberOutput);
		
		lblSsnOutput = new JLabel("SSN Output");
		lblSsnOutput.setBounds(261, 101, 109, 16);
		contentPane.add(lblSsnOutput);
		
		lblPhoneOutput = new JLabel("Phone# Output");
		lblPhoneOutput.setBounds(261, 146, 109, 16);
		contentPane.add(lblPhoneOutput);
		
		lblStateOutput = new JLabel("State Output");
		lblStateOutput.setBounds(261, 191, 109, 16);
		contentPane.add(lblStateOutput);
		
		
	}
	protected void do_focusLost_stateFTF(FocusEvent e) {
		lblStateOutput.setText(stateFTF.getText());
		
	}
	protected void do_focusLost_phoneFTF(FocusEvent e) {
		lblPhoneOutput.setText(phoneFTF.getText());
		
	}
	protected void do_focusLost_socialFTF(FocusEvent e) {
		lblSsnOutput.setText(socialFTF.getText());
		
	}
	protected void do_focusLost_numberFTF(FocusEvent e) {
		lblNumberOutput.setText(numberFTF.getText());
		
	}
}
