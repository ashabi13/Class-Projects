import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlagbalaSecondFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblSecondframe;
	private JButton btnNewFrame;


	/**
	 * Create the frame.
	 */
	public AlagbalaSecondFrame() {
		setTitle("AlagbalaSecondFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSecondframe = new JLabel("SecondFrame");
		lblSecondframe.setBounds(196, 62, 83, 16);
		contentPane.add(lblSecondframe);
		
		btnNewFrame = new JButton("New Frame");
		btnNewFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_actionPerformed_btnNewFrame(e);
			}
		});
		btnNewFrame.setBounds(179, 120, 117, 29);
		contentPane.add(btnNewFrame);
	}


	protected void do_actionPerformed_btnNewFrame(ActionEvent e) {
		try {
			AlagbalaThirdFrame frame3 = new AlagbalaThirdFrame();
			frame3.setVisible(true);
			this.dispose();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
}
