package goods;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ∏ﬁ¿Œ.MainGUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class SearchGui {

	private JFrame frame;

	
	public SearchGui() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 300, 486, 377);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btn_search = new JButton("");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SelectGoods selectgoods = new SelectGoods();
				frame.dispose();

			}
		});
		btn_search.setBounds(254, 42, 194, 210);
		frame.getContentPane().add(btn_search);
		
		btn_search.setBorderPainted(false); 
		btn_search.setContentAreaFilled(false);    
		btn_search.setFocusPainted(false);
		

		JButton btn_register = new JButton("");
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GoodsGui goodsgui = new GoodsGui();
				frame.dispose();

			}
		});
		
		btn_register.setBounds(35, 43, 194, 209);
		frame.getContentPane().add(btn_register);
		
		
		btn_register.setBorderPainted(false); 
		btn_register.setContentAreaFilled(false);    
		btn_register.setFocusPainted(false);
		
		

		JButton btn_close = new JButton("");
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainGUI main = new MainGUI();
				frame.dispose();
			}
		});
		btn_close.setBounds(347, 288, 100, 40);
		frame.getContentPane().add(btn_close);
		
		
		btn_close.setBorderPainted(false); 
		btn_close.setContentAreaFilled(false);    
		btn_close.setFocusPainted(false);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(SearchGui.class.getResource("/image_pack/\uC81C\uBAA9 \uC5C6\uC74C-1-\uBCF5\uAD6C\uB428.jpg")));
		lblNewLabel.setBounds(0, 0, 470, 349);
		frame.getContentPane().add(lblNewLabel);
	}
}
