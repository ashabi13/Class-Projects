import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MFreame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Hello");
	private final JLabel lblGoodbye = new JLabel("Goodbye");
	private final JButton btnSwitch = new JButton("Switch");
	private final JLabel lblAloha = new JLabel("Aloha");
	private final JButton btnColors = new JButton("Colors");
	private final JButton btnFonts = new JButton("Fonts");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MFreame frame = new MFreame();
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
	public MFreame() {
		jbInit();
	}
	private void jbInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(27, 19, 75, 54);
		
		contentPane.add(lblNewLabel);
		lblGoodbye.setForeground(Color.BLUE);
		lblGoodbye.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblGoodbye.setBounds(128, 22, 75, 54);
		
		contentPane.add(lblGoodbye);
		btnSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSwitch_actionPerformed(e);
			}
		});
		btnSwitch.setBounds(45, 134, 89, 23);
		
		contentPane.add(btnSwitch);
		lblAloha.setForeground(new Color(128, 0, 128));
		lblAloha.setFont(new Font("Segoe Script", Font.BOLD, 16));
		lblAloha.setBounds(247, 42, 95, 14);
		
		contentPane.add(lblAloha);
		btnColors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnColors_actionPerformed(e);
			}
		});
		btnColors.setBounds(154, 134, 89, 23);
		
		contentPane.add(btnColors);
		btnFonts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnFonts_actionPerformed(e);
			}
		});
		btnFonts.setBounds(264, 134, 89, 23);
		
		contentPane.add(btnFonts);
	}
	protected void do_btnSwitch_actionPerformed(ActionEvent e) {
		String s = lblGoodbye.getText();
		lblGoodbye.setText(lblNewLabel.getText());
		lblNewLabel.setText(lblAloha.getText());
		lblAloha.setText(s);
		
	}
	protected void do_btnColors_actionPerformed(ActionEvent e) {
		Color c = lblGoodbye.getForeground();
		lblGoodbye.setForeground(lblNewLabel.getForeground());
		lblNewLabel.setForeground(lblAloha.getForeground());
		lblAloha.setForeground(c);
	}
	protected void do_btnFonts_actionPerformed(ActionEvent e) {
		Font f = lblGoodbye.getFont();
		lblGoodbye.setFont(lblNewLabel.getFont());
		lblNewLabel.setFont(lblAloha.getFont());
		lblAloha.setFont(f);
	}
}
