package goods;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class GoodsGui {

	private JFrame frame;
	private JTextField tf_name;
	private JTextField tf_price;
	private JTextField tf_realprice;
	private JTextField tf_category;

	/**
	 * Create the application.
	 */
	public GoodsGui() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 300, 600, 435);
		frame.getContentPane().setLayout(null);

		tf_name = new JTextField();
		tf_name.setBounds(255, 101, 154, 36);
		frame.getContentPane().add(tf_name);
		tf_name.setColumns(10);

		tf_price = new JTextField();
		tf_price.setBounds(255, 150, 154, 36);
		frame.getContentPane().add(tf_price);
		tf_price.setColumns(10);

		JButton btn_register1 = new JButton("");
		btn_register1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				String category = tf_category.getText();
				int category = Integer.parseInt(tf_category.getText());
				String name = tf_name.getText();
				int goodsprice = Integer.parseInt(tf_price.getText());
				int realgoodsprice = Integer.parseInt(tf_realprice.getText());
				// String goodsorder = tf_goodsorder.getText();
				// String goodsuse = tf_goodsuse.getText();
				// String goodsregister = tf_goodsregister.getText();

				// if (name.equals(category)) {
				GoodsDAO dao = new GoodsDAO();
				GoodsVO vo = new GoodsVO(category, name, goodsprice, realgoodsprice);
				System.out.println(category + " " + name + " " + goodsprice + "  " + realgoodsprice);
				// (category, name, goodsprice, realgoodsprice, goodsorder, goodsuse,
				// goodsregister);
				int cnt = dao.joinInsert(vo);
				System.out.println(cnt);
				if (cnt == 0) {
					JOptionPane.showMessageDialog(null, "물품등록  실패", "등록실패", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "물품등록 성공");
					// GoodsGui goodsgui1 = new GoodsGui();
					SelectGoods selGood = new SelectGoods();
					frame.dispose();
				}

				// } else {
				// JOptionPane.showMessageDialog(null, "존재하지 않는 카테고리", "등록실패",
				// JOptionPane.ERROR_MESSAGE);
				// }

			}
		});
		btn_register1.setBounds(52, 282, 222, 76);
		frame.getContentPane().add(btn_register1);

		btn_register1.setBorderPainted(false); 
		btn_register1.setContentAreaFilled(false);    
		btn_register1.setFocusPainted(false);
	      
		
		
		JButton btn_close1 = new JButton("");
		btn_close1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchGui sear = new SearchGui();
				frame.dispose();

			}
		});
		btn_close1.setBounds(309, 285, 203, 76);
		frame.getContentPane().add(btn_close1);
		btn_close1.setBorderPainted(false); 
		btn_close1.setContentAreaFilled(false);    
		btn_close1.setFocusPainted(false);
		
		

		tf_realprice = new JTextField();
		tf_realprice.setColumns(10);
		tf_realprice.setBounds(255, 201, 154, 36);
		frame.getContentPane().add(tf_realprice);

		tf_category = new JTextField();
		tf_category.setColumns(10);
		tf_category.setBounds(255, 52, 154, 30);
		frame.getContentPane().add(tf_category);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(GoodsGui.class.getResource("/image_pack/\uC81C\uBAA9 \uC5C6\uC74C-1.jpg")));
		lblNewLabel_2.setBounds(0, 0, 584, 396);
		frame.getContentPane().add(lblNewLabel_2);
	}

}
