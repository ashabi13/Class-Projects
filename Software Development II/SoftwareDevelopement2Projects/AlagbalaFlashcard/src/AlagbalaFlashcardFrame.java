import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlagbalaFlashcardFrame extends JFrame {

	MaskFormatter numberMask1 = createFormatter("*##");
	MaskFormatter numberMask2 = createFormatter("*##");
	
	private JPanel contentPane;
	private JFormattedTextField val1FTF;
	private JFormattedTextField val2FTF;
	private JLabel lblSum;
	private JSeparator separator;
	private JLabel label;
	
	private int STNDRDVAL = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlagbalaFlashcardFrame frame = new AlagbalaFlashcardFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//place this code after main()

		public MaskFormatter createFormatter(String s) {
		     MaskFormatter formatter = null;
		     try {
		          formatter = new MaskFormatter(s);
		         } 
		     catch (java.text.ParseException exc) {
			          System.err.println("formatter is bad: " + exc.getMessage());
			          System.exit(-1);
			      }
		      return formatter;
		}//createFormatter
	/**
	 * Create the frame.
	 */
	public AlagbalaFlashcardFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		val1FTF = new JFormattedTextField();
		val1FTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_actionPerformed_val1FTF(e);
			}
		});
		/*val1FTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_propertyChanged_val1FTF(evt);
			}
		});
		val1FTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_focusLost_valFTF(e);
			}
		});*/
		val1FTF.setText("0");
		val1FTF.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		val1FTF.setHorizontalAlignment(SwingConstants.RIGHT);
		val1FTF.setBounds(62, 68, 79, 51);
		numberMask1.setPlaceholderCharacter('#');
		val1FTF.setText("00");
		numberMask1.install(val1FTF);
		contentPane.add(val1FTF);
		
		val2FTF = new JFormattedTextField();
		/*val2FTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_propertyChanged_val2FTF(evt);
			}
		});*/
		val2FTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_focusLost_valFTF(e);
			}
		});
		
		val2FTF.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		val2FTF.setHorizontalAlignment(SwingConstants.RIGHT);
		val2FTF.setBounds(62, 131, 79, 51);
		numberMask2.setPlaceholderCharacter('#');
		val2FTF.setText("0");
		numberMask2.install(val2FTF);
		contentPane.add(val2FTF);
		
		lblSum = new JLabel("SUM");
		lblSum.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		lblSum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSum.setBackground(Color.WHITE);
		lblSum.setBounds(62, 218, 79, 51);
		contentPane.add(lblSum);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(16, 194, 125, 12);
		contentPane.add(separator);
		
		label = new JLabel("+");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(6, 152, 44, 43);
		contentPane.add(label);
	}

	protected void do_actionPerformed_val1FTF(ActionEvent e) {
		Integer val1 = 0;
		CharSequence cs = new StringBuffer("##");
		if(val1FTF.getText()!=null&&!val1FTF.getText().contains(cs+"")){
			val1 = Integer.valueOf(val1FTF.getText());
			if(val1>=0)
				val1FTF.setForeground(Color.BLACK);
			else
				val1FTF.setForeground(Color.RED);
		}
		
	}

	/*protected void do_propertyChanged_val1FTF(PropertyChangeEvent evt) {
		Integer val1 = 0;
		CharSequence cs = new StringBuffer("##");
		if(val1FTF.getText()!=null&&!val1FTF.getText().contains(cs+"")){
			val1 = Integer.valueOf(val1FTF.getText());
			if(val1>=0)
				val1FTF.setForeground(Color.BLACK);
			else
				val1FTF.setForeground(Color.RED);
		}
		
	}

	protected void do_propertyChanged_val2FTF(PropertyChangeEvent evt) {
		Integer val2 = 0;
		CharSequence cs = new StringBuffer("##");
		if(val2FTF.getText()!=null&&!val2FTF.getText().contains(cs+"")){
			val2 = Integer.valueOf(val2FTF.getText());
			if(val2>=0)
				val2FTF.setForeground(Color.BLACK);
			else
				val2FTF.setForeground(Color.RED);
		}
			
		
	}*/

	protected void do_focusLost_valFTF(FocusEvent e) {
		Integer sum = 0;
		Integer val1 = 0;
		Integer val2 = 0;
		CharSequence cs = new StringBuffer("##");
		if(val1FTF.getText()!=null&&!val1FTF.getText().contains(cs+"")){
			val1 = Integer.valueOf(val1FTF.getText());
			if(val1>=0)
				val1FTF.setForeground(Color.BLACK);
			else
				val1FTF.setForeground(Color.RED);
			sum+=val1;
		}
		if(val2FTF.getText()!=null&&!val1FTF.getText().contains(cs+"")){
			val2 = Integer.valueOf(val2FTF.getText());
			if(val2>=0)
				val2FTF.setForeground(Color.BLACK);
			else
				val2FTF.setForeground(Color.RED);
			sum += val2;
			
		}
		
		/*CharSequence cs = new StringBuffer("##");
		if((val1 !=0)
		 &&(val1FTF.getText().contains(cs))
		 &&(val2!=0)
		 &&(val2FTF.getText().contains(cs)))
			sum = val1+val2;
		else if(val1!=0)
			sum = val1;
		else if(val2!=0)
			sum = val2;
		*/
		lblSum.setText(sum.toString());	
	}


}
