import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;

public class Alagbala_Menus_and_More extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmNew;
	private JMenuItem mntmOpen;
	private JSeparator separator;
	private JMenuItem mntmClose;
	private JMenuItem mntmExit;
	private JMenu mnEdit;
	private JMenuItem mntmCopy;
	private JMenuItem mntmCut;
	private JMenuItem mntmPaste;
	private JLabel lblSelection;
	private JCheckBox chckbxFirst;
	private JCheckBox chckbxSecond;
	private JCheckBox chckbxThird;
	final String selected="";
	private final JPasswordField passwordField = new JPasswordField();
	private final JLabel lblPassword = new JLabel("Password:");
	private final JButton btnPrint = new JButton("Print");
	private final JProgressBar progressBar = new JProgressBar();
	private final JButton btnAdvance = new JButton("Advance");
	private JToggleButton tglbtnPress;
	private JLabel lblMutiatAlagbala;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alagbala_Menus_and_More frame = new Alagbala_Menus_and_More();
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
	public Alagbala_Menus_and_More() {
		jbInit();
	}
	private void jbInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmNew = new JMenuItem("New");
		/*mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFile(e);
			}
		});
		mntmNew.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				newShortcut(e);
			}
		});*/
		mnFile.add(mntmNew);
		
		mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		separator = new JSeparator();
		mnFile.add(separator);
		
		mntmClose = new JMenuItem("Close");
		/*mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFile(e);
			}
		});*/
		mnFile.add(mntmClose);
		
		mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		
		mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);
		
		mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSelection = new JLabel("Selection: ");
		lblSelection.setBounds(17, 34, 314, 16);
		contentPane.add(lblSelection);
		
		
		
		chckbxFirst = new JCheckBox("First");
		chckbxFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chckbx_actionPerformed(e);
			}
		});
//		chckbxFirst.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				do_chckbx_mouseClicked(arg0);
//			}
//		});
		chckbxFirst.setBounds(17, 68, 80, 23);
		contentPane.add(chckbxFirst);
		
		chckbxSecond = new JCheckBox("Second");
		chckbxSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chckbx_actionPerformed(e);
			}
		});
//		chckbxSecond.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				do_chckbx_mouseClicked(arg0);
//			}
//		});
		chckbxSecond.setBounds(17, 88, 80, 23);
		contentPane.add(chckbxSecond);
		
		chckbxThird = new JCheckBox("Third");
		chckbxThird.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chckbx_actionPerformed(e);
			}
		});
//		chckbxThird.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				do_chckbx_mouseClicked(arg0);
//			}
//		});
		chckbxThird.setBounds(17, 109, 80, 23);
		contentPane.add(chckbxThird);
		passwordField.setBounds(241, 70, 117, 20);
		
		contentPane.add(passwordField);
		lblPassword.setBounds(112, 71, 117, 18);
		
		contentPane.add(lblPassword);
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPrint_actionPerformed(e);
			}
		});
		btnPrint.setBounds(355, 70, 89, 23);
		
		contentPane.add(btnPrint);
		progressBar.setBounds(131, 177, 287, 14);
		
		contentPane.add(progressBar);
		btnAdvance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdvance_actionPerformed(e);
			}
		});
		btnAdvance.setBounds(243, 212, 89, 23);
		
		contentPane.add(btnAdvance);
		
		tglbtnPress = new JToggleButton("Press");
		tglbtnPress.setBounds(243, 130, 80, 29);
		contentPane.add(tglbtnPress);
		
		lblMutiatAlagbala = new JLabel("Mutiat Alagbala");
		lblMutiatAlagbala.setBounds(6, 6, 129, 16);
		contentPane.add(lblMutiatAlagbala);
	}

	protected void do_btnAdvance_actionPerformed(ActionEvent e) {
		if(tglbtnPress.isSelected())
			progressBar.setValue(progressBar.getValue()+(int)(progressBar.getMaximum()*0.1));
		else
			progressBar.setValue(progressBar.getValue()+(int)(progressBar.getMaximum()*0.05));
	}

	protected void do_btnPrint_actionPerformed(ActionEvent e) {
		lblPassword.setText(passwordField.getPassword().clone().toString()+"");
	}

	protected void do_chckbx_actionPerformed(ActionEvent e) {
		lblSelection.setText("");
		outputSelect(chckbxFirst, "First");
		outputSelect(chckbxSecond, "Second");
		outputSelect(chckbxThird, "Third");
	}
	/*protected void do_chckbx_mouseClicked(MouseEvent arg0) {
		
		outputSelect(chckbxFirst, "First");
		outputSelect(chckbxSecond, "Second");
		outputSelect(chckbxThird, "Third");
	}*/
	
	protected void outputSelect(JCheckBox o, String selectName){
		if(o.isSelected() && !lblSelection.getText().contains(selectName))
			lblSelection.setText(lblSelection.getText()+" "+selectName);
			//.setText(selectName);
		/*else if(!o.isSelected()&& lblSelection.getText().contains(selectName))
			lblSelection.setText(text);*/
	}
}
