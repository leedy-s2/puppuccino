package view.memo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import MEMO_dao.JtMemoDao;
import MEMO_dto.JtMemoDto;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class JtMemoWrite {

    private JFrame frame;
    JtMemoDao dao = new JtMemoDao();

    /**
     * Create the application.
     */
    public JtMemoWrite() {
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
        panel.setBackground(new Color(204, 204, 255));
        panel.setBounds(0, 0, 584, 461);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(204, 204, 255));
        panel_1.setBounds(12, 10, 565, 441);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(JtMemoWrite.class.getResource("/image_pack/\u3142\u314C.png")));
        lblNewLabel.setBounds(90, 10, 240, 53);
        panel_1.add(lblNewLabel);

        JPanel panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBounds(401, 10, 154, 421);
        panel_1.add(panel_2);

        JTextPane tp_memo = new JTextPane();
        tp_memo.setBorder(new LineBorder(new Color(0, 0, 0)));
        tp_memo.setBackground(new Color(255, 255, 255));
        tp_memo.setBounds(12, 65, 378, 366);
        panel_1.add(tp_memo);

        JButton btn_write = new JButton("");
        btn_write.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String memo = tp_memo.getText();
                if (memo == null || memo.length() == 0) {
                    JOptionPane.showMessageDialog(null, "메모를 작성후 등록하세요.", "메모 등록실패", JOptionPane.ERROR_MESSAGE);
                } else {
                    JtMemoDto dto = new JtMemoDto(memo);
                    int cnt = dao.insertMemo(dto);
                    if (cnt > 0) {
                        JOptionPane.showMessageDialog(null, "메모가 등록 되었습니다.");
                        JtMemo mList = new JtMemo();
                        // frame.setVisible(false);//메인창을 숨길 때
                        frame.dispose();// 현재창을 종료시킬 때
                    } else {
                        JOptionPane.showMessageDialog(null, "메모를 등록하지 못했습니다.", "메모 등록실패", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        btn_write.setBounds(0, 69, 154, 43);
        panel_2.add(btn_write);
        
        
        btn_write.setBorderPainted(false); 
        btn_write.setContentAreaFilled(false);    
        btn_write.setFocusPainted(false);
        
        

        JButton btn_list = new JButton("");
        btn_list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JtMemo mList = new JtMemo();
                // frame.setVisible(false);//메인창을 숨길 때
                frame.dispose();// 현재창을 종료시킬 때
            }
        });
        btn_list.setBounds(0, 122, 154, 43);
        panel_2.add(btn_list);
        
        btn_list.setBorderPainted(false); 
        btn_list.setContentAreaFilled(false);    
        btn_list.setFocusPainted(false);
        
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setBorder(null);
        lblNewLabel_1.setIcon(new ImageIcon(JtMemoWrite.class.getResource("/image_pack/writes.jpg")));
        lblNewLabel_1.setBounds(0, 0, 154, 421);
        panel_2.add(lblNewLabel_1);
        
        JLabel label = new JLabel("");
        label.setBounds(24, 0, 240, 53);
        panel_1.add(label);

    }
}
