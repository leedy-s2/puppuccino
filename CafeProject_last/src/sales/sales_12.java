package sales;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class sales_12 {

	private JFrame frame;
	String month;

	public sales_12(String month) {
		this.month = month;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 300, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sales_monthly mon = new sales_monthly();
				frame.dispose();
			}
		});
		button.setBounds(341, 216, 81, 35);
		frame.getContentPane().add(button);
		
		button.setBorderPainted(false); 
		button.setContentAreaFilled(false);    
		button.setFocusPainted(false);
	      
		

		JPanel panel = new JPanel();
		panel.setBounds(42, 29, 366, 99);
		panel.setBackground(new Color(250, 0,0,0));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		// ±¸ÇöµÇ´Â °÷
		sales_DAO dao = new sales_DAO();
		int sales = dao.selectMonth("2020-12");

		
	
		
		JLabel lbl_month = new JLabel();
		lbl_month.setBounds(142, 20, 244, 52);
		panel.add(lbl_month);
		lbl_month.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 33));
		lbl_month.setText("12");
		
		JLabel lbl_sysmonth = new JLabel("New label");
		lbl_sysmonth.setForeground(new Color(0, 0, 51));
		lbl_sysmonth.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 37));
		lbl_sysmonth.setBounds(138, 160, 200, 42);
		frame.getContentPane().add(lbl_sysmonth);
		lbl_sysmonth.setText(sales+"¿ø");
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 34));
		lblNewLabel.setIcon(new ImageIcon(sales_12.class.getResource("/image_pack/\uC81C\uBAA9 \uC5C6\uC74C-2.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel);
		


	}
}
