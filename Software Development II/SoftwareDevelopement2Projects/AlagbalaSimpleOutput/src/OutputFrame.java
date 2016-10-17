import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class OutputFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JTextField phoneTextField;
	private JLabel lblPhone;
	private JTextField emailTextField;
	private JLabel lblEmail;
	private JLabel lblMutiatAlagbala;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OutputFrame frame = new OutputFrame();
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
	public OutputFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSayHello = new JButton("Say Hello");
		btnSayHello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSayHello_actionPerformed(e);
			}
		});
		
		lblMutiatAlagbala = new JLabel("Mutiat Alagbala");
		lblMutiatAlagbala.setBounds(6, 6, 130, 16);
		contentPane.add(lblMutiatAlagbala);
		btnSayHello.setBounds(269, 68, 117, 29);
		contentPane.add(btnSayHello);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 55, 200, 150);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.BLACK);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(313, 109, 130, 26);
		contentPane.add(nameTextField);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(247, 114, 48, 16);
		contentPane.add(lblName);
		
		phoneTextField = new JTextField();
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(313, 153, 130, 26);
		contentPane.add(phoneTextField);
		
		lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(247, 158, 48, 16);
		contentPane.add(lblPhone);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(313, 201, 130, 26);
		contentPane.add(emailTextField);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(247, 206, 48, 16);
		contentPane.add(lblEmail);
	}
	
	public void do_btnSayHello_actionPerformed(ActionEvent e) {
		
		if(nameTextField.getText().isEmpty())
			textArea.append("Please type your name. \n");
		else
			textArea.append("Hello, " + nameTextField.getText()+ "!\n");
		if(phoneTextField.getText().isEmpty())
			textArea.append("Please type your phone number. \n");
		else
			textArea.append("Your phone number is: " + phoneTextField.getText()+ "!\n");
		if(emailTextField.getText().isEmpty())
			textArea.append("Please type your email. \n");
		else
			textArea.append("Your email is: " + emailTextField.getText()+ "!\n");
		/*if(!nameTextField.getText().isEmpty()&&!phoneTextField.getText().isEmpty()&&!emailTextField.getText().isEmpty())
			textArea.append("Hello, " + nameTextField.getText()+ "!\n"+
							"Your phone number is: " + phoneTextField.getText()+ "!\n"+
							"Your email is: " + emailTextField.getText()+ "!\n");
		if(nameTextField.getText().isEmpty())
			textArea.setText("Please type your name. \n");
		if(phoneTextField.getText().isEmpty());*/
		
	}
}
