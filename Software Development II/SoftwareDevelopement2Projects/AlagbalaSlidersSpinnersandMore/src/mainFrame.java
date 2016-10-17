import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;

public class mainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblSlider;
	private JSlider slider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
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
	public mainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSlider = new JLabel("Slider");
		lblSlider.setBounds(29, 121, 61, 16);
		contentPane.add(lblSlider);
		
		slider = new JSlider();
		slider.setBackground(Color.WHITE);
		slider.setMajorTickSpacing(10);
		slider.setPaintTrack(false);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_slider_stateChanged(e);
			}
		});
		slider.setMinorTickSpacing(5);
		slider.setPaintLabels(true);
		slider.setValue(100);
		slider.setPaintTicks(true);
		slider.setBounds(102, 102, 344, 52);
		contentPane.add(slider);
		lblSlider.setText(slider.getValue()+"");
		
		JLabel lblSpinner = new JLabel("Spinner");
		lblSpinner.setBounds(29, 179, 61, 16);
		contentPane.add(lblSpinner);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(112, 174, 33, 26);
		spinner.setValue(1);
		
		contentPane.add(spinner);
	}
	
	protected void do_slider_stateChanged(ChangeEvent e){
		lblSlider.setText(slider.getValue()+"");
	}
}
