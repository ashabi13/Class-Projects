import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class AlagbalaAutoFlashFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblPentatonix = new JLabel("PENTATONIX");
	private final JButton btnFlash = new JButton("Flash");
	private final JButton btnAutoFlash = new JButton("Auto Flash");
	
	Timer timer = new Timer(100, new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
        	lblPentatonix.setVisible(!lblPentatonix.isVisible());
        }
	}); //brace-paren-semicolon
	private final JSlider slider = new JSlider();
	private final JLabel lblFaster = new JLabel("Faster");
	private final JLabel lblSlower = new JLabel("Slower");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlagbalaAutoFlashFrame frame = new AlagbalaAutoFlashFrame();
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
	public AlagbalaAutoFlashFrame() {
		jbInit();
	}
	private void jbInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		slider.setMinimum(1);
		slider.setBackground(Color.WHITE);
		slider.setForeground(Color.WHITE);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_slider_stateChanged(e);
			}
		});
		slider.setValue(500);
		slider.setMaximum(1000);
		slider.setBounds(6, 221, 438, 29);
		
		contentPane.add(slider);
		lblPentatonix.setForeground(Color.WHITE);
		lblPentatonix.setFont(new Font("Raanana", Font.PLAIN, 50));
		lblPentatonix.setHorizontalAlignment(SwingConstants.CENTER);
		lblPentatonix.setBounds(6, 16, 438, 90);
		
		contentPane.add(lblPentatonix);
		btnFlash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnFlash_actionPerformed(e);
			}
		});
		btnFlash.setBounds(164, 139, 117, 29);
		
		contentPane.add(btnFlash);
		btnAutoFlash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAutoFlash_actionPerformed(e);
			}
		});
		btnAutoFlash.setBounds(164, 180, 117, 29);
		
		contentPane.add(btnAutoFlash);
		lblFaster.setForeground(Color.WHITE);
		lblFaster.setHorizontalAlignment(SwingConstants.CENTER);
		lblFaster.setBounds(383, 244, 61, 16);
		
		contentPane.add(lblFaster);
		lblSlower.setForeground(Color.WHITE);
		lblSlower.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlower.setBounds(6, 244, 61, 16);
		
		contentPane.add(lblSlower);
	}
	protected void do_btnFlash_actionPerformed(ActionEvent e) {
		lblPentatonix.setVisible(!lblPentatonix.isVisible());
		
	}
	protected void do_btnAutoFlash_actionPerformed(ActionEvent e) {
		if(!timer.isRunning())
			timer.start();
		else
			timer.stop();
	}
	protected void do_slider_stateChanged(ChangeEvent e) {
		timer.setDelay(1000-this.slider.getValue());
	}
}	