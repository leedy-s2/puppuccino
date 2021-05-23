package sales;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Color;


public class sales_daily{

	private JFrame frame;
	private JTable table_sales;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public sales_daily(String date) {
		initialize(date);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String date) {

		frame = new JFrame();
		frame.setBounds(700, 300, 574, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		SalesVO vo = new SalesVO();
		
		JLabel lbl_today = new JLabel();
		lbl_today.setForeground(Color.WHITE);
		lbl_today.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 20));
		lbl_today.setBounds(222, 32, 147, 69);
		frame.getContentPane().add(lbl_today);
		
		
		lbl_today.setText(date);
		



		JButton btn_back = new JButton("");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				sales_main m = new sales_main();
				frame.dispose();

			}
		});
		btn_back.setBounds(437, 334, 109, 39);
		frame.getContentPane().add(btn_back);

		
		btn_back.setBorderPainted(false); 
		btn_back.setContentAreaFilled(false);    
		btn_back.setFocusPainted(false);
	      
		
		
		JPanel panel = new JPanel();
		panel.setBounds(88, 98, 411, 226);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 428, 224);
		panel.add(scrollPane);

		JLabel whole_sales = new JLabel("New label");
		whole_sales.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 17));
		whole_sales.setBounds(101, 342, 133, 27);
		frame.getContentPane().add(whole_sales);
		sales_DAO dao = new sales_DAO();
		ArrayList<SalesVO> stList2 = dao.selectStd(date);
		int sum = 0;
		for(int i = 0; i<stList2.size(); i++) {	
		sum+=stList2.get(i).getPay();
		}
		whole_sales.setText(sum+"원");
		   String[] colnames = {"주문번호", "가격"};
//		      Object[][] data = {{"카푸치노", 4500, 5}, {"바닐라라떼", 3500, 4}, {"퍼푸치노", 2000, 5}, {"강아지 케이크", 1900, 4}};

		ArrayList<SalesVO> stList = dao.selectStd(date);
		Object[][] data = new Object[stList.size()][2];

		int cnt = 1;
		for(int i = 0; i<stList.size(); i++) {		
			data[i][0] = "주문번호 "+ cnt++ +"번";
			data[i][1] = stList.get(i).getPay();
			
			
		}

		table_sales = new JTable(data, colnames);
		scrollPane.setViewportView(table_sales);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(sales_daily.class.getResource("/image_pack/\uC7AC\uC7AC\uC5C5\uB85C\uB4DC.jpg")));
		lblNewLabel.setBounds(0, 0, 558, 387);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(157, 52, 49, 28);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.setBorderPainted(false); 
		btnNewButton.setContentAreaFilled(false);    
		btnNewButton.setFocusPainted(false);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(340, 52, 49, 26);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_1.setBorderPainted(false); 
		btnNewButton_1.setContentAreaFilled(false);    
		btnNewButton_1.setFocusPainted(false);
	}
}
