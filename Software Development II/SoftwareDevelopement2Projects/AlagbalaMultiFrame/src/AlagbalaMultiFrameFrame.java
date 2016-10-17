import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlagbalaMultiFrameFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnGoAway;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlagbalaMultiFrameFrame frame = new AlagbalaMultiFrameFrame();
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
	public AlagbalaMultiFrameFrame() {
		setTitle("AlagbalaMultiFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnGoAway = new JButton("Go Away");
		btnGoAway.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_actionPreformed_btnGoAway(e);
			
			}
		});
		btnGoAway.setBounds(178, 123, 117, 29);
		contentPane.add(btnGoAway);
	}

	protected void do_actionPreformed_btnGoAway(ActionEvent e) {
			try {
				AlagbalaSecondFrame frame2 = new AlagbalaSecondFrame();
				frame2.setVisible(true);
				this.dispose();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	}
	
}
