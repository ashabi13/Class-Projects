import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AlagbalaMoveItFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblBlock = new JLabel("Block");
	private final JButton btnMoveIt = new JButton("⇩");
	private final JButton btnBackItUp = new JButton("⇧");
	private final JButton btnToTheRight = new JButton("⇨");
	private final JButton btnToTheLeft = new JButton("⇦");
	private final JButton btnBackleft = new JButton("↖");
	private final JButton btnBackright = new JButton("↗");
	private final JButton btnUpleft = new JButton("↙");
	private final JButton btnUpright = new JButton("↘");
	private final JButton btnReset = new JButton("Reset");
	private final int originalW=50;
	private final int originalH=50;
	private final JButton btnShrink = new JButton("Shrink");
	private final JButton btnGrow = new JButton("Grow");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlagbalaMoveItFrame frame = new AlagbalaMoveItFrame();
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
	public AlagbalaMoveItFrame() {
		jbInit();
	}
	private void jbInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblBlock.setOpaque(true);
		lblBlock.setBackground(Color.PINK);
		lblBlock.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlock.setBounds(145, 37, originalW, originalH);
		
		contentPane.add(lblBlock);
		btnMoveIt.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnMoveIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnMoveIt_actionPerformed(e);
			}
		});
		btnMoveIt.setBounds(126, 249, 117, 29);
		
		contentPane.add(btnMoveIt);
		btnBackItUp.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnBackItUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBackItUp_actionPerformed(e);
			}
		});
		btnBackItUp.setBounds(126, 133, 117, 29);
		
		contentPane.add(btnBackItUp);
		btnToTheRight.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnToTheRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnToTheRight_actionPerformed(e);
			}
		});
		btnToTheRight.setBounds(334, 191, 46, 29);
		
		contentPane.add(btnToTheRight);
		btnToTheLeft.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnToTheLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnToTheLeft_actionPerformed(e);
			}
		});
		btnToTheLeft.setBounds(77, 191, 46, 29);
		
		contentPane.add(btnToTheLeft);
		btnBackleft.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnBackleft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBackleft_actionPerformed(e);
			}
		});
		btnBackleft.setBounds(77, 133, 46, 29);
		
		contentPane.add(btnBackleft);
		btnBackright.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnBackright.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBackright_actionPerformed(e);
			}
		});
		btnBackright.setBounds(334, 133, 46, 29);
		
		contentPane.add(btnBackright);
		btnUpleft.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnUpleft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUpleft_actionPerformed(e);
			}
		});
		btnUpleft.setBounds(77, 243, 46, 29);
		
		contentPane.add(btnUpleft);
		btnUpright.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnUpright.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUpright_actionPerformed(e);
			}
		});
		btnUpright.setBounds(334, 243, 46, 29);
		
		contentPane.add(btnUpright);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReset_actionPerformed(e);
			}
		});
		btnReset.setBounds(126, 191, 117, 29);
		
		contentPane.add(btnReset);
		btnShrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnShrink_actionPerformed(e);
			}
		});
		btnShrink.setBounds(126, 221, 117, 29);
		
		contentPane.add(btnShrink);
		btnGrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnGrow_actionPerformed(e);
			}
		});
		btnGrow.setBounds(126, 163, 117, 29);
		
		contentPane.add(btnGrow);
	}
	protected void do_btnMoveIt_actionPerformed(ActionEvent e) {
		lblBlock.setLocation(lblBlock.getX(), lblBlock.getY()+3);
	}
	protected void do_btnBackItUp_actionPerformed(ActionEvent e) {

		lblBlock.setLocation(lblBlock.getX(), lblBlock.getY()-3);
	}
	protected void do_btnToTheLeft_actionPerformed(ActionEvent e) {

		lblBlock.setLocation(lblBlock.getX()-3, lblBlock.getY());
	}
	protected void do_btnToTheRight_actionPerformed(ActionEvent e) {

		lblBlock.setLocation(lblBlock.getX()+3, lblBlock.getY());
	}
	protected void do_btnBackleft_actionPerformed(ActionEvent e) {

		lblBlock.setLocation(lblBlock.getX()-3, lblBlock.getY()-3);
	}
	
	
	protected void do_btnBackright_actionPerformed(ActionEvent e) {

		lblBlock.setLocation(lblBlock.getX()+3, lblBlock.getY()-3);
	}
	protected void do_btnUpleft_actionPerformed(ActionEvent e) {

		lblBlock.setLocation(lblBlock.getX()-3, lblBlock.getY()+3);
	}
	protected void do_btnUpright_actionPerformed(ActionEvent e) {

		lblBlock.setLocation(lblBlock.getX()+3, lblBlock.getY()+3);
	}
	protected void do_btnReset_actionPerformed(ActionEvent e) {
		lblBlock.setBounds(lblBlock.getX(), lblBlock.getY(), this.originalW, this.originalH);
	}
	protected void do_btnGrow_actionPerformed(ActionEvent e) {

		lblBlock.setBounds(lblBlock.getX()-5, lblBlock.getY()-5, lblBlock.getWidth()+10, lblBlock.getWidth()+10);
	}
	protected void do_btnShrink_actionPerformed(ActionEvent e) {
		lblBlock.setBounds(lblBlock.getX()+5, lblBlock.getY()+5, lblBlock.getWidth()-10, lblBlock.getWidth()-10);
	}
}
