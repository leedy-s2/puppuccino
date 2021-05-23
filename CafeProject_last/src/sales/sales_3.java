package sales;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class sales_3 {

	private JFrame frame;
	String month;

	public sales_3(String month) {
		this.month = month;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		JButton button = new JButton("\uB3CC\uC544\uAC00\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sales_monthly mon = new sales_monthly();
				frame.dispose();
			}
		});
		button.setBounds(307, 217, 97, 23);
		frame.getContentPane().add(button);

		JPanel panel = new JPanel();
		panel.setBounds(38, 62, 366, 99);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lbl_monthly = new JLabel("New label");
		lbl_monthly.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lbl_monthly.setBounds(231, 34, 95, 24);
		panel.add(lbl_monthly);

		sales_DAO dao = new sales_DAO();
		int sales = dao.selectMonth("2021-03");
		lbl_monthly.setText(sales+"");
		JLabel lbl_month = new JLabel();
		lbl_month.setBounds(24, 20, 244, 52);
		panel.add(lbl_month);
		lbl_month.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lbl_month.setText("2020³â " + this.month + " ¸ÅÃâ Áý°è ");
	}
}
