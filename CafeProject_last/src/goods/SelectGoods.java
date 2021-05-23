package goods;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class SelectGoods {

    private JFrame frame;
    private JTable table;
    private JButton btn_수정;
    private JButton btnNewButton_2;
    private JButton btn_저장;
    int row;
    int col;
    private JLabel lblNewLabel;

    /**
     * Create the application.
     */
    public SelectGoods() {
        initialize();
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(500, 300, 871, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(29, 21, 795, 294);
        frame.getContentPane().add(scrollPane);
//		setLayout(null);

        String[] colNames = { "번호", "카테고리", "상품명", "가격" };
//		DefaultTableModel medel = new DefaultTableModel(colNames, 0);
        GoodsDAO dao = new GoodsDAO();
        ArrayList<GoodsVO> stList = dao.selectItem();

        Object[][] data = new Object[stList.size()][colNames.length];

        for (int i = 0; i < stList.size(); i++) {
            data[i][0] = stList.get(i).getIt_no();
            data[i][1] = stList.get(i).getCa_no();
            data[i][2] = stList.get(i).getIt_name();
            data[i][3] = stList.get(i).getIt_price();
            System.out.print(data[i][0]+" -- "+data[i][1]+" -- "+data[i][2]+" -- "+data[i][3]);
        }

        DefaultTableModel model = new DefaultTableModel(data, colNames);
        table = new JTable(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        	},
        	new String[] {
        		"\uBC88\uD638", "\uCE74\uD14C\uACE0\uB9AC", "\uC0C1\uD488\uBA85", "\uAC00\uACA9"
        	}
        ));
        table.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        /*
         * table.addMouseListener(new MouseAdapter() {
         * 
         * @Override public void mouseClicked(MouseEvent e) { if (e.getClickCount() ==
         * 2) { row = table.rowAtPoint(e.getPoint()); col =
         * table.columnAtPoint(e.getPoint());
         * 
         * Object value = table.getValueAt(row, col); //String in =
         * JOptionPane.showInputDialog(value); //table.setValueAt(in, row, col); } } });
         */

        table.setColumnSelectionAllowed(true);
        table.setEnabled(false);
        table.setCellSelectionEnabled(true);
        table = new JTable(data, colNames);
        scrollPane.setViewportView(table);

        btn_수정 = new JButton("");
        btn_수정.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                table.setEnabled(true);
                for (int i = 0; i < stList.size(); i++) {
                    data[i][0] = stList.get(i).getIt_no();
                    data[i][1] = stList.get(i).getCa_no();
                    data[i][2] = stList.get(i).getIt_name();
                    data[i][3] = stList.get(i).getIt_price();
                    //data[i][4] = stList.get(i).getIt_cust_price();
                    //data[i][4] = stList.get(i).getIt_date();
                }
            }
        });
        btn_수정.setBounds(185, 335, 221, 66);
        frame.getContentPane().add(btn_수정);

        
        btn_수정.setBorderPainted(false); 
        btn_수정.setContentAreaFilled(false);    
        btn_수정.setFocusPainted(false);
        
        
        
        btn_저장 = new JButton("");
        btn_저장.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow(); // 열(세로방향)번호
                int col = table.getSelectedColumn(); // 행(가로방향)번호
                Object value = table.getValueAt(row, col);
                System.out.println(value);

                int it_no = Integer.parseInt(table.getValueAt(row, 0) + "");
                int num = Integer.parseInt(table.getValueAt(row, 1) + "");
                String name = table.getValueAt(row, 2) + "";
                int p = Integer.parseInt(table.getValueAt(row, 3) + "");
                //int cp = Integer.parseInt(table.getValueAt(row, 4) + "");
                table.setValueAt(value, row, col);
                /*
                System.out.println(it_no);
                System.out.println(num);
                System.out.println(name);
                System.out.println(p);
                System.out.println(cp);
                 */
                table.setEnabled(false);
                GoodsDAO dao = new GoodsDAO();
                int r = dao.updateTable(it_no, num, name, p);
                if (r > 0) {
                    JOptionPane.showMessageDialog(null, "수정완료");
                    SearchGui sear = new SearchGui();
                    
                    frame.dispose();// 현재창을 종료시킬 때
                } else {
                    JOptionPane.showMessageDialog(null, "수정실패", "Error", 1);
                }
                // dao.close();
                // System.out.println(data[0][1]);
              
            }
        });
        btn_저장.setBounds(436, 335, 215, 66);
        frame.getContentPane().add(btn_저장);
        
        btn_저장.setBorderPainted(false); 
        btn_저장.setContentAreaFilled(false);    
        btn_저장.setFocusPainted(false);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(SelectGoods.class.getResource("/image_pack/8.jpg")));
        lblNewLabel.setBounds(0, 0, 855, 411);
        frame.getContentPane().add(lblNewLabel);

    }
}
