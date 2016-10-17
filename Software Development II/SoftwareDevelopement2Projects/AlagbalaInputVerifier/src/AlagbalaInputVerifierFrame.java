import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlagbalaInputVerifierFrame extends JFrame {

	
	
	private JPanel contentPane;
	
	//Locale inLocale = Locale.US;
	NumberFormat numFormat = NumberFormat.getNumberInstance();
	//NumberFormat num2Format = NumberFormat.getCurrencyInstance(inLocale);
	
	private JFormattedTextField firstFTF;
	private JFormattedTextField secondFTF;
	private JFormattedTextField thirdFTF;
	
	
	private double num1 = 1.0;
	private double num2 = 2.00;
	private double num3 = 3.0;
	private JLabel lblFirstText;
	private JLabel lblFirstValue;
	private JLabel lblSecondText;
	private JLabel lblSecondvalue;
	private JLabel lblThirdtext;
	private JLabel lblThirdvalue;
	private JButton btnFirstAdd;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlagbalaInputVerifierFrame frame = new AlagbalaInputVerifierFrame();
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
	public AlagbalaInputVerifierFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		firstFTF = new JFormattedTextField(numFormat);
		firstFTF.setHorizontalAlignment(SwingConstants.RIGHT);
		firstFTF.setBounds(83, 58, 107, 26);
		firstFTF.setValue(num1);
		firstFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				lblFirstText.setText(firstFTF.getText());
				lblFirstValue.setText(firstFTF.getValue().toString());
			}
		});
		
		contentPane.add(firstFTF);
		/**firstFTF.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent e) {
			do_focusLost_firstFTF(e);
		}
	});*/
		
		secondFTF = new JFormattedTextField(numFormat.getCurrencyInstance());
		
		secondFTF.setHorizontalAlignment(SwingConstants.RIGHT);
		secondFTF.setBounds(83, 111, 107, 26);
		secondFTF.setValue(num2);
		secondFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				lblSecondText.setText(secondFTF.getText());
				lblSecondvalue.setText(secondFTF.getValue().toString());
			}
		});
		contentPane.add(secondFTF);
		
		thirdFTF = new JFormattedTextField(numFormat.getPercentInstance());
		thirdFTF.setHorizontalAlignment(SwingConstants.RIGHT);
		thirdFTF.setBounds(83, 168, 107, 26);
		thirdFTF.setValue(num3);
		thirdFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				lblThirdtext.setText(firstFTF.getText());
				lblThirdvalue.setText(firstFTF.getValue().toString());
			}
		});
		contentPane.add(thirdFTF);
		
		lblFirstText = new JLabel("FirstText");
		lblFirstText.setBounds(226, 63, 89, 16);
		contentPane.add(lblFirstText);
		
		lblFirstValue = new JLabel("FirstValue");
		lblFirstValue.setBounds(355, 63, 89, 16);
		contentPane.add(lblFirstValue);
		
		lblSecondText = new JLabel("SecondText");
		lblSecondText.setBounds(226, 116, 89, 16);
		contentPane.add(lblSecondText);
		
		lblSecondvalue = new JLabel("SecondValue");
		lblSecondvalue.setBounds(355, 116, 89, 16);
		contentPane.add(lblSecondvalue);
		
		lblThirdtext = new JLabel("ThirdText");
		lblThirdtext.setBounds(226, 173, 89, 16);
		contentPane.add(lblThirdtext);
		
		lblThirdvalue = new JLabel("ThirdValue");
		lblThirdvalue.setBounds(355, 173, 89, 16);
		contentPane.add(lblThirdvalue);
		
		btnFirstAdd = new JButton("Add");
		btnFirstAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_actionPerformed_firstAdd(e);
			}
		});
		btnFirstAdd.setBounds(6, 58, 81, 29);
		contentPane.add(btnFirstAdd);
		
		
	}
	
	protected void do_actionPerformed_firstAdd(ActionEvent e) {
		num1 = ((Number)firstFTF.getValue()).doubleValue()+1;
		firstFTF.setValue(num1);
		//OR \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
		//num1 = (double)firstFTF.getValue();
	}

	protected void do_focusLost_firstFTF(FocusEvent e) {
		lblFirstText.setText(firstFTF.getText());
		lblFirstValue.setText((String) firstFTF.getValue().toString());
		
	}
}
