package sales;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class sales_monthly {

	private JFrame frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	
	public sales_monthly() {
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
		
		JButton btn_back = new JButton("");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				sales_main m = new sales_main();
				frame.dispose();
				
				
			}
		});

		btn_back.setBorderPainted(false); 
		btn_back.setContentAreaFilled(false);    
		btn_back.setFocusPainted(false);
	      
		
		btn_back.setBounds(457, 353, 94, 28);
		frame.getContentPane().add(btn_back);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sales_1 jan = new sales_1(btnNewButton.getText());
			
			}
		});
		btnNewButton.setBounds(41, 105, 107, 66);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.setBorderPainted(false); 
		btnNewButton.setContentAreaFilled(false);    
		btnNewButton.setFocusPainted(false);
	      
		
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sales_2 fab = new sales_2(button_1.getText());
			
			}
		});
		button_1.setBounds(168, 105, 97, 66);
		frame.getContentPane().add(button_1);
		
		
		button_1.setBorderPainted(false); 
		button_1.setContentAreaFilled(false);    
		button_1.setFocusPainted(false);
		
		
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sales_3 mar = new sales_3(button_2.getText());
			
			}
		});
		button_2.setBounds(288, 105, 97, 66);
		frame.getContentPane().add(button_2);
		
		
		button_2.setBorderPainted(false); 
		button_2.setContentAreaFilled(false);    
		button_2.setFocusPainted(false);
		
		
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sales_4 apr = new sales_4(button_3.getText());
			
			}
		});
		button_3.setBounds(405, 105, 107, 66);
		frame.getContentPane().add(button_3);
		
		
		
		button_3.setBorderPainted(false); 
		button_3.setContentAreaFilled(false);    
		button_3.setFocusPainted(false);
		
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sales_5 may  = new sales_5(button_4.getText());
		
			}
		});
		button_4.setBounds(41, 195, 107, 60);
		frame.getContentPane().add(button_4);
		
		
		button_4.setBorderPainted(false); 
		button_4.setContentAreaFilled(false);    
		button_4.setFocusPainted(false);
		
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sales_6 jun = new sales_6(button_5.getText());
		
			}
		});
		button_5.setBounds(160, 195, 107, 60);
		frame.getContentPane().add(button_5);
		
		
		
		button_5.setBorderPainted(false); 
		button_5.setContentAreaFilled(false);    
		button_5.setFocusPainted(false);
		

		JButton button_6 = new JButton("");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sales_7 jul = new sales_7(button_6.getText());
		
			}
		});
		button_6.setBounds(288, 195, 97, 60);
		frame.getContentPane().add(button_6);
		
		button_6.setBorderPainted(false); 
		button_6.setContentAreaFilled(false);    
		button_6.setFocusPainted(false);
		
		
		JButton button_7 = new JButton("");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sales_8 aug = new sales_8(button_7.getText());
			
			}
		});
		button_7.setBounds(405, 195, 107, 60);
		frame.getContentPane().add(button_7);
		
		
		button_7.setBorderPainted(false); 
		button_7.setContentAreaFilled(false);    
		button_7.setFocusPainted(false);
		
		JButton button_8 = new JButton("");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sales_9 sep = new sales_9(button_8.getText());
			
			}
		});
		button_8.setBounds(41, 280, 107, 66);
		frame.getContentPane().add(button_8);
		
		button_8.setBorderPainted(false); 
		button_8.setContentAreaFilled(false);    
		button_8.setFocusPainted(false);
		
		
		JButton button_9 = new JButton("");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sales_10 oct = new sales_10(button_9.getText());
			
			}
		});
		
		
		
	
		button_9.setBounds(168, 280, 97, 66);
		frame.getContentPane().add(button_9);
		
		button_9.setBorderPainted(false); 
		button_9.setContentAreaFilled(false);    
		button_9.setFocusPainted(false);
		
		JButton button_10 = new JButton("");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sales_11 nov = new sales_11(button_10.getText());
			
			}
		});
		button_10.setBounds(286, 280, 107, 66);
		frame.getContentPane().add(button_10);
		
		
		button_10.setBorderPainted(false); 
		button_10.setContentAreaFilled(false);    
		button_10.setFocusPainted(false);
		
		JButton button_11 = new JButton("");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sales_12 dec = new sales_12(button_11.getText());
			
			}
		});
		button_11.setBounds(405, 280, 107, 64);
		frame.getContentPane().add(button_11);
		
		
		button_11.setBorderPainted(false); 
		button_11.setContentAreaFilled(false);    
		button_11.setFocusPainted(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(sales_monthly.class.getResource("/image_pack/\uC7AC\uC5C5\uB85C\uB4DC.jpg")));
		lblNewLabel.setBounds(0, 0, 558, 387);
		frame.getContentPane().add(lblNewLabel);
	}

	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
