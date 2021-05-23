package sales;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class sales_choose {

	private JFrame frame;
	JTextField date_choice;
	private JButton btn_back;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public sales_choose() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(750, 400, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		date_choice = new JTextField();
		date_choice.setBounds(87, 120, 250, 35);
		frame.getContentPane().add(date_choice);
		date_choice.setColumns(10);
		
		JButton btn_send = new JButton("");
		btn_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = date_choice.getText();
				sales_daily daily = new sales_daily(date);
				frame.dispose();
				
			}
		});
		btn_send.setBounds(283, 169, 112, 28);
		frame.getContentPane().add(btn_send);
		
		
		btn_send.setBorderPainted(false); 
		btn_send.setContentAreaFilled(false);    
		btn_send.setFocusPainted(false);
		
		
		
		
		
		btn_back = new JButton("");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				sales_main m = new sales_main();
				frame.dispose();
			}
		});
		btn_back.setBounds(283, 209, 112, 28);
		frame.getContentPane().add(btn_back);
		
		
		btn_back.setBorderPainted(false); 
		btn_back.setContentAreaFilled(false);    
		btn_back.setFocusPainted(false);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(sales_choose.class.getResource("/image_pack/ppcn+daily+choice.jpg")));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
