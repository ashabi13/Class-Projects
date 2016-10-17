import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AlagbalaDataValidationFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblPositiveNumber;
	private JTextField NegNumTF;
	private JLabel lblNegativeNumber;
	private JTextField PosNumTF;
	private JLabel lblThankyou;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlagbalaDataValidationFrame frame = new AlagbalaDataValidationFrame();
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
	public AlagbalaDataValidationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPositiveNumber = new JLabel("Positive Number:");
		lblPositiveNumber.setBounds(6, 54, 120, 16);
		contentPane.add(lblPositiveNumber);
		
		NegNumTF = new JTextField();
		NegNumTF.setToolTipText("Input a positive number <p> please. </p>");
		NegNumTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_focusLost_NegNumTF(e);
			}
		});
		NegNumTF.setBounds(138, 94, 276, 26);
		contentPane.add(NegNumTF);
		NegNumTF.setColumns(10);
		
		lblNegativeNumber = new JLabel("Negative Number:");
		lblNegativeNumber.setBounds(6, 99, 120, 16);
		contentPane.add(lblNegativeNumber);
		
		PosNumTF = new JTextField();
		PosNumTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_focusLost_PosNumTF(e);
			}
		});
		PosNumTF.setColumns(10);
		PosNumTF.setBounds(138, 49, 276, 26);
		contentPane.add(PosNumTF);
		
		lblThankyou = new JLabel("ThankYou");
		lblThankyou.setBounds(138, 198, 100, 16);
		contentPane.add(lblThankyou);
	}

	protected void do_focusLost_PosNumTF(FocusEvent e) {
		if(Integer.parseInt(PosNumTF.getText())<0){
			JOptionPane.showMessageDialog(this, "Must be a positive number", "Positive Number", 1);
			PosNumTF.grabFocus();
			lblThankyou.setVisible(false);
		}
		else lblThankyou.setVisible(true);
		
	}
	protected void do_focusLost_NegNumTF(FocusEvent e) {
		if(Integer.parseInt(NegNumTF.getText())>0){
			JOptionPane.showMessageDialog(this, "Must be a positive number", "Negative Number", 0);
			NegNumTF.grabFocus();
			lblThankyou.setVisible(false);
		}
		else lblThankyou.setVisible(true);
		
	}

}
