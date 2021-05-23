package 직원관리;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Administartor_GUI {

	protected static Object loginMember;
	private JFrame frame;
	private JTextField tf_name;
	private JTextField tf_phone;
	private JTextField tf_id;
	private JTextField tf_pw;
	private JTextField tf_email;

	public Administartor_GUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(800, 300, 494, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btn_name = new JButton("");
		btn_name.setBounds(29, 179, 124, 36);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btn_name);

		btn_name.setBorderPainted(false); 
		btn_name.setContentAreaFilled(false);    
		btn_name.setFocusPainted(false);
		
		
		JButton btn_phone = new JButton("");
		btn_phone.setBounds(29, 235, 124, 36);
		btn_phone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btn_phone);
		
		btn_phone.setBorderPainted(false); 
		btn_phone.setContentAreaFilled(false);    
		btn_phone.setFocusPainted(false);
		

		tf_name = new JTextField();
		tf_name.setBounds(204, 183, 160, 32);
		frame.getContentPane().add(tf_name);
		tf_name.setColumns(10);

		tf_phone = new JTextField();
		tf_phone.setBounds(204, 239, 160, 29);
		tf_phone.setColumns(10);
		frame.getContentPane().add(tf_phone);

		JButton btn_make = new JButton("");
		btn_make.setBounds(111, 341, 86, 29);
		btn_make.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String MEM_id = tf_id.getText();
				String MEM_password = tf_pw.getText();
				String MEM_name = tf_name.getText();
				String MEM_phone = tf_phone.getText();
				String MEM_email = tf_email.getText();

				int denied = 2;

				MemberDAO dao = new MemberDAO();
				MemberVO vo = new MemberVO(MEM_id, MEM_password, MEM_name, MEM_phone, MEM_email, denied);
				int cnt = dao.joinInsert(vo);
				if (cnt == 0) {
					JOptionPane.showMessageDialog(null, "회원가입 실패", "회원가입", JOptionPane.ERROR_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "회원가입 성공");

				}

			}
		});
		frame.getContentPane().add(btn_make);
		
		btn_make.setBorderPainted(false); 
		btn_make.setContentAreaFilled(false);    
		btn_make.setFocusPainted(false);
		

		JButton btn_delete = new JButton("");
		btn_delete.setBounds(210, 341, 86, 29);
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				MemberDAO dao = new MemberDAO();
				String name = tf_name.getText();
				int cnt = dao.delete(new MemberVO(name));
				if (cnt > 0) {
					attendance_GUI.loginMember = null;
					attendance_GUI login = new attendance_GUI();
					JOptionPane.showMessageDialog(null, "회원탈퇴성공");
					
				} else {
					JOptionPane.showMessageDialog(null, "회원정보를 다시입력해주세요.", "회원탈퇴", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		frame.getContentPane().add(btn_delete);
		
		btn_delete.setBorderPainted(false); 
		btn_delete.setContentAreaFilled(false);    
		btn_delete.setFocusPainted(false);
		
		
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(29, 119, 124, 43);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.setBorderPainted(false); 
		btnNewButton.setContentAreaFilled(false);    
		btnNewButton.setFocusPainted(false);
	      
		

		JButton btn_id = new JButton("");
		btn_id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_id.setBounds(33, 71, 120, 38);
		frame.getContentPane().add(btn_id);
		
		btn_id.setBorderPainted(false); 
		btn_id.setContentAreaFilled(false);    
		btn_id.setFocusPainted(false);
	      
		

		tf_id = new JTextField();
		tf_id.setBounds(204, 76, 160, 30);
		tf_id.setColumns(10);
		frame.getContentPane().add(tf_id);

		tf_pw = new JTextField();
		tf_pw.setBounds(204, 126, 160, 32);
		tf_pw.setColumns(10);
		frame.getContentPane().add(tf_pw);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(34, 290, 119, 36);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_2.setBorderPainted(false); 
		btnNewButton_2.setContentAreaFilled(false);    
		btnNewButton_2.setFocusPainted(false);
		
		
		tf_email = new JTextField();
		tf_email.setBounds(204, 294, 160, 29);
		tf_email.setColumns(10);
		frame.getContentPane().add(tf_email);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(308, 341, 79, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				attendance_GUI att = new attendance_GUI();
				frame.dispose();

			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_1.setBorderPainted(false); 
		btnNewButton_1.setContentAreaFilled(false);    
		btnNewButton_1.setFocusPainted(false);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Administartor_GUI.class.getResource("/image_pack/\uC9C1\uC6D0\uAD00\uB9AC3.jpg")));
		lblNewLabel.setBounds(0, 0, 478, 380);
		frame.getContentPane().add(lblNewLabel);
	}
}
