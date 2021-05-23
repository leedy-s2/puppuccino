package 직원관리;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class login_GUI {

	private JFrame frame;
	private JTextField tf_loginid;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public login_GUI() {
		initialize();
		getFrame().setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(800, 400, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);

		tf_loginid = new JTextField();
		tf_loginid.setBounds(126, 135, 125, 35);
		getFrame().getContentPane().add(tf_loginid);
		tf_loginid.setColumns(10);
	
		passwordField = new JPasswordField();
		passwordField.setBounds(126, 180, 125, 33);
		frame.getContentPane().add(passwordField);
		
	
		JButton btn_login = new JButton("");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				String id = tf_loginid.getText();
				
				String pw = passwordField.getText();

				MemberDAO dao = new MemberDAO();
				MemberVO vo = dao.loginSelect(id, pw);
				if (vo == null) {
					JOptionPane.showMessageDialog(null, "로그인 실패", "로그인", JOptionPane.ERROR_MESSAGE);
					
				} else {
					JOptionPane.showMessageDialog(null, vo.getMem_id() + "관리자 님 환영합니다.");
					Administartor_GUI j = new Administartor_GUI();
					frame.dispose();
				}

				
			}
		});
		
			passwordField.addKeyListener(new KeyAdapter() {
	         @Override
	         public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode()==10) {
	            	btn_login.doClick();
	            }
	         }
	      });
		
		btn_login.setBorderPainted(false); 
		btn_login.setContentAreaFilled(false);    
		btn_login.setFocusPainted(false);
		
		
		btn_login.setBounds(275, 137, 71, 33);
		getFrame().getContentPane().add(btn_login);
		
		
		

		JButton btn_cancel = new JButton("");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				attendance_GUI att = new attendance_GUI();
				getFrame().dispose();

			}
		});
		btn_cancel.setBounds(275, 180, 71, 33);
		getFrame().getContentPane().add(btn_cancel);
		
		
		btn_cancel.setBorderPainted(false); 
		btn_cancel.setContentAreaFilled(false);    
		btn_cancel.setFocusPainted(false);
	      
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(login_GUI.class.getResource("/image_pack/\uC9C1\uC6D0\uAD00\uB9AC_2.jpg")));
		lblNewLabel_3.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel_3);
	
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public static void main(Object object) {
		// TODO Auto-generated method stub

	}
}
