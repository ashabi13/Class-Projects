import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class AlagbalaBounceFrame extends JFrame {

	private JPanel contentPane;
	private final JButton btnGo = new JButton("GO!");
	private final JLabel lblBall = new JLabel("BALL");
	Timer timer = new Timer(100, new ActionListener() {
	int xdir = 10;
	int ydir = 10;
        public void actionPerformed(ActionEvent e) {
        	
        	if(lblBall.getX()>=contentPane.getWidth()-lblBall.getWidth())
        		xdir=-10;
        	if(lblBall.getX()<=0)
        		xdir=10;
        	if(lblBall.getY()>=contentPane.getHeight()-lblBall.getHeight())
        		ydir=-10;
        	if(lblBall.getY()<=0)
        		ydir=10;
        	
        	lblBall.setLocation(lblBall.getX()+xdir, lblBall.getY()+ydir);
        }
	}); //brace-paren-semicolon
	private final JSlider slider = new JSlider();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlagbalaBounceFrame frame = new AlagbalaBounceFrame();
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
	public AlagbalaBounceFrame() {
		jbInit();
	}
	private void jbInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnGo_actionPerformed(e);
			}
		});
		btnGo.setBounds(155, 135, 117, 29);
		
		contentPane.add(btnGo);
		lblBall.setForeground(Color.WHITE);
		lblBall.setOpaque(true);
		lblBall.setBackground(Color.BLUE);
		lblBall.setHorizontalAlignment(SwingConstants.CENTER);
		lblBall.setBounds(44, 65, 61, 54);
		
		contentPane.add(lblBall);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_slider_stateChanged(e);
			}
		});
		slider.setMinimum(1);
		slider.setMaximum(500);
		slider.setValue(slider.getMaximum()/2);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_slider_stateChanged(e);
			}
		});
		slider.setBounds(118, 192, 190, 29);
		
		contentPane.add(slider);
	}
	protected void do_btnGo_actionPerformed(ActionEvent e) {
		if(!timer.isRunning())
			timer.start();
		else
			timer.stop();
	}
	protected void do_slider_stateChanged(ChangeEvent e) {
		timer.setDelay(slider.getMaximum()-this.slider.getValue());
	}
}
