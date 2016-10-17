import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlagbalaFlashingLabelFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblMyLabel = new JLabel("CMPT 330 is Fun!!");
	private final JButton btnFlash = new JButton("Flash");
	private final JButton btnFlashier = new JButton("Flashier");
	private final JLabel lblBest = new JLabel("Best Class Ever!");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlagbalaFlashingLabelFrame frame = new AlagbalaFlashingLabelFrame();
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
	public AlagbalaFlashingLabelFrame() {
		jbInit();
	}
	private void jbInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblMyLabel.setBounds(143, 31, 154, 14);
		
		contentPane.add(lblMyLabel);
		btnFlash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnFlash_actionPerformed(e);
			}
		});
		btnFlash.setBounds(166, 107, 89, 23);
		
		contentPane.add(btnFlash);
		btnFlashier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnFlashier_actionPerformed(e);
			}
		});
		btnFlashier.setBounds(166, 163, 89, 23);
		
		contentPane.add(btnFlashier);
		lblBest.setBounds(176, 56, 110, 14);
		lblBest.setVisible(false);
		
		contentPane.add(lblBest);
		
		JLabel lblMutiatAlagbala = new JLabel("Mutiat Alagbala");
		lblMutiatAlagbala.setBounds(23, 6, 110, 16);
		contentPane.add(lblMutiatAlagbala);
	}
	protected void do_btnFlash_actionPerformed(ActionEvent e) {
		lblMyLabel.setVisible(!lblMyLabel.isVisible());
		
	}
	protected void do_btnFlashier_actionPerformed(ActionEvent e) {
		lblBest.setVisible(lblMyLabel.isVisible());
		lblMyLabel.setVisible(!lblMyLabel.isVisible());
	}
}
