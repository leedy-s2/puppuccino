package 로그인;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Advertisement.doggy_food;
import 메인.MainGUI;
import 직원관리.MemberDAO;
import 직원관리.MemberVO;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class LoginGUI {

	private JFrame frame;
	private JTextField tf_id;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(300, 100, 1400, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel.setIcon(new ImageIcon("C:\\\uC81C\uBAA9.png"));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(127, 59, 200, 100);
		frame.getContentPane().add(lblNewLabel);
		
		tf_id = new JTextField();
		tf_id.setBounds(611, 474, 200, 41);
		frame.getContentPane().add(tf_id);
		tf_id.setColumns(10);
		
		ImageIcon join = new ImageIcon("C:\\로그인.png");
		Image img = join.getImage();
		Image changeImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JButton btn_join = new JButton(changeIcon);
		btn_join.setBorderPainted(false);	    
		btn_join.setContentAreaFilled(false);	  
		btn_join.setFocusPainted(false);
		
		
		
		//JButton btn_join = new JButton("J O I N");
		btn_join.setOpaque(false); 
		btn_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tf_id.getText();
				String pw = passwordField.getText();
				
				MemberDAO dao = new MemberDAO();
				MemberVO vo = dao.loginSelect(id, pw);
				if (vo == null) {
					JOptionPane.showMessageDialog(null, "로그인 실패", "로그인", JOptionPane.ERROR_MESSAGE);
					frame.dispose();
					LoginGUI.main(null);

				} else {
					JOptionPane.showMessageDialog(null, "환영합니다.");
					MainGUI m = new MainGUI();
					doggy_food d = new doggy_food();
					frame.dispose();
					
				}
				
				
				
			}
		});
		btn_join.setBounds(835, 477, 126, 87);
		frame.getContentPane().add(btn_join);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblNewLabel_1.setIcon(new ImageIcon(LoginGUI.class.getResource("/image_pack/ppcn+login.jpg")));
		lblNewLabel_1.setBounds(428, 218, 584, 461);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(611, 530, 200, 41);
		frame.getContentPane().add(passwordField);
		passwordField.addKeyListener(new KeyAdapter() {
	         @Override
	         public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode()==10) {
	            	btn_join.doClick();
	            }
	         }
	      });
		
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(LoginGUI.class.getResource("/image_pack/ppcn+main.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1384, 861);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
