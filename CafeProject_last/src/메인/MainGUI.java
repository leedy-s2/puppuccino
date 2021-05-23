package 메인;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Advertisement.donation_plz;
import MEMO_view.JtMain;
import dogdoggy.doggy_random;
import goods.GoodsGui;
import goods.SearchGui;
import order_last_view.OrderGUI;
import sales.sales_main;
import 로그인.LoginGUI;
import 직원관리.attendance_GUI;







public class MainGUI {

	private JFrame frame;

	public MainGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(300, 100, 1400, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn_item = new JButton();
		btn_item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SearchGui search = new SearchGui();
			//frame.dispose();
				
			}
		});
		btn_item.setBounds(27, 248, 411, 277);
		frame.getContentPane().add(btn_item);
		
		btn_item.setBorderPainted(false); 
		btn_item.setContentAreaFilled(false);    
		btn_item.setFocusPainted(false);
		
		
	
		JButton btn_pos = new JButton();
		btn_pos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OrderGUI gui = new OrderGUI();
				//frame.dispose();
			}
		});
		btn_pos.setBounds(476, 252, 411, 273);
		frame.getContentPane().add(btn_pos);
		btn_pos.setBorderPainted(false); 
		btn_pos.setContentAreaFilled(false);    
		btn_pos.setFocusPainted(false);
//		btn_pos.setContentAreaFilled(false);
//		btn_pos.setBackground(new Color(0, 0, 0, 0));
//		btn_pos.setBackground(new Color(0, 174, 219,0));
//		btn_pos.setOpaque(false); // 투명하게
//		frame.setVisible(true);
		
	
		JButton btn_emp = new JButton();
		btn_emp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attendance_GUI att = new attendance_GUI();
				//frame.dispose();
				
			}
		});
		btn_emp.setBounds(928, 252, 411, 273);
		frame.getContentPane().add(btn_emp);
		
		btn_emp.setBorderPainted(false); 
		btn_emp.setContentAreaFilled(false);    
		btn_emp.setFocusPainted(false);
		
		
		ImageIcon memo = new ImageIcon("C:\\메모.png");
		Image img3 = memo.getImage();
		Image changeImg3 = img3.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		ImageIcon changeIcon3 = new ImageIcon(changeImg3);
		JButton btn_memo = new JButton(changeIcon3);
		btn_memo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JtMain m = new JtMain();
				//frame.dispose();
				
			}
		});
		
		btn_memo.setBounds(928, 574, 411, 277);
		frame.getContentPane().add(btn_memo);
		
		btn_memo.setBorderPainted(false); 
		btn_memo.setContentAreaFilled(false);    
		btn_memo.setFocusPainted(false);
		
		
		
		
		ImageIcon account = new ImageIcon("C:\\매출.png");
		Image img4 = account.getImage();
		Image changeImg4 = img4.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		ImageIcon changeIcon4 = new ImageIcon(changeImg4);
			
		
		JButton btn_account = new JButton(changeIcon4);
		btn_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sales_main s = new sales_main();
				//frame.dispose();
				
			}
		});
		btn_account.setBorderPainted(false); 
		btn_account.setContentAreaFilled(false);    
		btn_account.setFocusPainted(false);
		
		
		

		btn_account.setBounds(476, 577, 411, 274);
		frame.getContentPane().add(btn_account);
		
		ImageIcon cust = new ImageIcon("C:\\회원관리.png");
		Image img5 = cust.getImage();
		Image changeImg5 = img5.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		ImageIcon changeIcon5 = new ImageIcon(changeImg5);
		JButton btn_cust = new JButton(changeIcon5);
		btn_cust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doggy_random rd = new doggy_random();
				//frame.dispose();
			
			}
		});
		btn_cust.setBorderPainted(false); 
		btn_cust.setContentAreaFilled(false);    
		btn_cust.setFocusPainted(false);
		
		

		btn_cust.setBounds(27, 577, 404, 274);
		frame.getContentPane().add(btn_cust);
		
		
		ImageIcon 로그아웃 = new ImageIcon("C:\\로그아웃.png");
		Image img6 = 로그아웃.getImage();
		Image changeImg6 = img6.getScaledInstance(120, 110, Image.SCALE_SMOOTH);
		ImageIcon changeIcon6 = new ImageIcon(changeImg6);
		
		JLabel main_design = new JLabel("New label");
		main_design.setIcon(new ImageIcon(MainGUI.class.getResource("/image_pack/ppcn+main.jpg")));
		main_design.setBounds(0, 0, 1400, 900);
		frame.getContentPane().add(main_design);
		JButton btn_로그아웃 = new JButton(changeIcon6);
		btn_로그아웃.setBounds(1237, 20, 135, 67);
		
		btn_로그아웃.setBorderPainted(false); 
		btn_로그아웃.setContentAreaFilled(false);    
		btn_로그아웃.setFocusPainted(false);
		
		frame.getContentPane().add(btn_로그아웃);
		btn_로그아웃.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				donation_plz dplz = new donation_plz();
				frame.dispose();
				
			}
		});
	}
}
