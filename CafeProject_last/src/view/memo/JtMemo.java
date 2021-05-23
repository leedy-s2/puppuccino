package view.memo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import MEMO_dao.JtMemoDao;
import MEMO_dto.JtMemoDto;
import MEMO_view.JtMain;
import 메인.MainGUI;
import javax.swing.ImageIcon;

public class JtMemo {
    private JFrame frame;
    private JTable table;

    /**
     * Create the application.
     */
    public JtMemo() {
        initialize();
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(700, 300, 600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 584, 461);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(204, 204, 255));
        panel_1.setForeground(new Color(204, 204, 255));
        panel_1.setBounds(0, 0, 584, 461);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(399, 10, 154, 421);
        panel_1.add(panel_2);
        panel_2.setLayout(null);

        JButton btn_write = new JButton("");
        btn_write.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JtMemoWrite mWrite = new JtMemoWrite();
                // frame.setVisible(false);//메인창을 숨길 때
                frame.dispose();// 현재창을 종료시킬 때
            }
        });
        btn_write.setBounds(0, 63, 154, 56);
        panel_2.add(btn_write);
        btn_write.setBorderPainted(false); 
        btn_write.setContentAreaFilled(false);    
        btn_write.setFocusPainted(false);
        

        JButton btn_list = new JButton("");
        btn_list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btn_list.setBounds(0, 114, 154, 56);
        panel_2.add(btn_list);
        btn_list.setBorderPainted(false); 
        btn_list.setContentAreaFilled(false);    
        btn_list.setFocusPainted(false);
        
        
        
        JButton btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JtMain m = new JtMain();
				frame.dispose();
        		
        	}
        });
        btnNewButton.setBorderPainted(false); 
        btnNewButton.setContentAreaFilled(false);    
        btnNewButton.setFocusPainted(false); 
        btnNewButton.setBounds(12, 370, 130, 41);
        panel_2.add(btnNewButton);
        
       
        
        
        
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(JtMemo.class.getResource("/image_pack/\uC81C\uBC1C.jpg")));
        lblNewLabel_1.setBounds(0, 0, 154, 421);
        panel_2.add(lblNewLabel_1);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(204, 204, 255));
        panel_3.setBounds(12, 10, 374, 421);
        panel_1.add(panel_3);
        panel_3.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(JtMemo.class.getResource("/image_pack/\u3142\u314C.png")));
        lblNewLabel.setBounds(70, 0, 240, 53);
        panel_3.add(lblNewLabel);

        String[] colNames = {"No", "Memo", "Day" };
        JtMemoDao dao = new JtMemoDao();
        ArrayList<JtMemoDto> memoL = dao.selectJtMemo();
        Object[][] data = new Object[memoL.size()][colNames.length];

        for (int i = 0; i < memoL.size(); i++) {
            data[i][0] = memoL.get(i).getMemo_no();
            data[i][1] = memoL.get(i).getMemo_memo();
            data[i][2] = memoL.get(i).getMes_date();
        }
        
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 55, 374, 396);
        panel_3.add(scrollPane);
        
        //table = new JTable(data.colNames);
        table = new JTable(data, colNames);
        scrollPane.setViewportView(table);
        
        table.getColumnModel().getColumn(0).setMaxWidth(40); //컬럼width
        table.getColumnModel().getColumn(2).setMaxWidth(150);
        table.setBackground(new Color(119, 136, 153));
        table.setForeground(new Color(255, 255, 255));
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //테이블 클릭했을 때 값 가져오기
                int row = table.getSelectedRow(); //열(세로방향)번호
                //int col = table.getSelectedColumn(); //행(가로방향)번호
                Object value = table.getValueAt(row, 1);
                JtMemoView mView = new JtMemoView(value);
                frame.dispose();// 현재창을 종료시킬 때
            }
        });
        table.setBounds(0, 25, 374, 396);
    }
}
