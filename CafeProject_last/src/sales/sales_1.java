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

public class sales_1 {

	private JFrame frame;
	String month;

	public sales_1(String month) {
		this.month = month;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(730, 350, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sales_monthly mon = new sales_monthly();
				frame.dispose();
			}
		});
		button.setBounds(341, 219, 81, 32);
		frame.getContentPane().add(button);

		button.setBorderPainted(false); 
		button.setContentAreaFilled(false);    
		button.setFocusPainted(false);




		JPanel panel = new JPanel();
		panel.setBounds(34, 28, 388, 99);
		panel.setBackground(new Color(250,0,0,0));
		frame.getContentPane().add(panel);
		panel.setLayout(null);




		sales_DAO dao = new sales_DAO();
		int sales = dao.selectMonth("2021-01");

		JLabel lbl_month = new JLabel();
		lbl_month.setBounds(165, 22, 244, 52);
		panel.add(lbl_month);
		lbl_month.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 28));
		lbl_month.setText("1");
		

		JLabel lbl_sysmonth = new JLabel("New label");
		lbl_sysmonth.setForeground(new Color(0, 0, 51));
		lbl_sysmonth.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 37));
		lbl_sysmonth.setBounds(138, 160, 200, 42);
		frame.getContentPane().add(lbl_sysmonth);
		lbl_sysmonth.setText(sales+"¿ø");
		

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(sales_1.class.getResource("/image_pack/\uC6D4+\uCD1D\uB9E4\uCD9C.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel);

		JLabel lbl_sales_price = new JLabel("d");
		lbl_sales_price.setBounds(125, 152, 144, 53);
		frame.getContentPane().add(lbl_sales_price);





		JLabel lblNewLabel_1 = new JLabel("2333");
		lblNewLabel_1.setBounds(146, 196, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("dfd");
		lblNewLabel_2.setBounds(146, 190, 57, 15);
		frame.getContentPane().add(lblNewLabel_2);





	}
}
