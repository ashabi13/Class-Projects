
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class AlagbalaListExampleFrame extends JFrame {

	private JPanel contentPane;
	private JComboBox pSize;
	private JList<String> values;
	private JButton btnPrint;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JTextArea txtrOutputTA;
	private JTextField txtName;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private boolean validOrder = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlagbalaListExampleFrame frame = new AlagbalaListExampleFrame();
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
	@SuppressWarnings("deprecation")
	public AlagbalaListExampleFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(239, 30, 205, 171);
		contentPane.add(scrollPane);
		
		txtrOutputTA = new JTextArea();
		scrollPane.setViewportView(txtrOutputTA);
		txtrOutputTA.setEditable(false);
		
		pSize = new JComboBox<String>();
		pSize.setToolTipText("Pick a pie size.");
		pSize.addItem("Personal");
		pSize.addItem("Small");
		pSize.addItem("Medium");
		pSize.addItem("Large");
		pSize.addItem("Family");
		pSize.setBounds(87, 82, 140, 29);
		contentPane.add(pSize);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setToolTipText("Pick your toppings");
		scrollPane_1.setBounds(87, 140, 140, 71);
		contentPane.add(scrollPane_1);
		
		
		values = new JList();
		values.setToolTipText("Scroll through and pick your toppings.");
		scrollPane_1.setViewportView(values);
		values.setModel(new AbstractListModel() {
			String[] values_1 = new String[] {"extra cheese", "fresh motzarella", "pepperoni", "sausage", "bacon", "ground beef", "anchovies", "spinach", "basil", "olives", "peppers","fresh tomatoes", "sun-dried tomatoes", "pineapple"};
			public int getSize() {
				return values_1.length;
			}
			public Object getElementAt(int index) {
				return values_1[index];
			}
		});
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPrint_actionPerformed(e);
			}

			
		});
		btnPrint.setBounds(181, 229, 117, 29);
		contentPane.add(btnPrint);
		
		txtName = new JTextField();
		txtName.setToolTipText("Enter your name.");
		txtName.setBounds(87, 25, 140, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(19, 30, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblSize = new JLabel("Size:");
		lblSize.setBounds(19, 87, 61, 16);
		contentPane.add(lblSize);
		
		JLabel lblToppings = new JLabel("Toppings:");
		lblToppings.setBounds(12, 142, 68, 16);
		contentPane.add(lblToppings);
		
		JLabel lblMutiatAlagbala = new JLabel("Mutiat Alagbala");
		lblMutiatAlagbala.setBounds(19, 6, 184, 16);
		contentPane.add(lblMutiatAlagbala);
	}

	protected void do_btnPrint_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(txtName.getText().trim().isEmpty()) {
			txtrOutputTA.append("Please enter your name \n or your order will not \n be valid! \n "); 
			validOrder=false;
			txtrOutputTA.setForeground(Color.RED);
		}
		else{
			if(!validOrder){
				txtrOutputTA.setText("");
				validOrder = true;
				txtrOutputTA.setForeground(Color.BLACK);
			}	
			txtrOutputTA.append("Hello " + txtName.getText() + ". \n"); 
			txtrOutputTA.append("You ordered a "+pSize.getSelectedItem()+" sized \n cheese pizza ");
			List<String> theList = values.getSelectedValuesList();
			if(theList.isEmpty()) 
				txtrOutputTA.append("with NO toppings \n");
			else{
				txtrOutputTA.append("topped with: \n");
				for( int i = 0; i<theList.size(); i ++){
					txtrOutputTA.append(theList.get(i)+"\n");
				}
			}
		}
		/*if(buttonGroup.getSelection()!=null){
			if(rdbtnFirst.isSelected())
				txtrOutputTA.append(rdbtnFirst.getText()+"\n");
			if(rdbtnSecond.isSelected())
				txtrOutputTA.append(rdbtnSecond.getText()+"\n");
			if(rdbtnThird.isSelected())
				txtrOutputTA.append(rdbtnThird.getText()+"\n");
		}*/
		
	}
}
