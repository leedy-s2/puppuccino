package sales;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ¸ÞÀÎ.MainGUI;

public class sales_main {

	private JFrame frame;


	public sales_main() {

		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 300, 574, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn_dilaysales = new JButton("");
		btn_dilaysales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sales_choose choose = new sales_choose();
				frame.dispose();
				
				
			}
		});
		
		btn_dilaysales.setBorderPainted(false); 
		btn_dilaysales.setContentAreaFilled(false);    
		btn_dilaysales.setFocusPainted(false);
		
		
		
		btn_dilaysales.setFont(new Font("ÇÑÄÄ °íµñ", Font.PLAIN, 18));
		btn_dilaysales.setBounds(54, 164, 218, 174);
		frame.getContentPane().add(btn_dilaysales);
		
		JButton btn_monthsales = new JButton("");
		btn_monthsales.setFont(new Font("ÇÑÄÄ °íµñ", Font.PLAIN, 18));
		btn_monthsales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				sales_monthly monthly = new sales_monthly();
				frame.dispose();
			}
		});
		btn_monthsales.setBounds(293, 164, 216, 174);
		frame.getContentPane().add(btn_monthsales);
		
		btn_monthsales.setBorderPainted(false); 
		btn_monthsales.setContentAreaFilled(false);    
		btn_monthsales.setFocusPainted(false);
		
		
		JButton btn_close = new JButton("");
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGUI m = new MainGUI();
				frame.dispose();
			}
		});
		btn_close.setBounds(488, 356, 61, 24);
		frame.getContentPane().add(btn_close);
		
		btn_close.setBorderPainted(false); 
		btn_close.setContentAreaFilled(false);    
		btn_close.setFocusPainted(false);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(sales_main.class.getResource("/image_pack/ppcn+sales+main.jpg")));
		lblNewLabel_1.setBounds(0, 0, 558, 387);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
