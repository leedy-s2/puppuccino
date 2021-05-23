package view.memo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import java.awt.Font;

public class JtMemoView {

    private JFrame frame;
    JTextPane tp_view = new JTextPane();

    /**
     * Create the application.
     */
    /*
    public JtMemoView() {
        initialize();
        frame.setVisible(true);
    }
    */

    public JtMemoView(Object value) {
        initialize();
        frame.setVisible(true);
        /*
         * tp_view.setForeground(new Color(25, 25, 112)); 
         * tp_view.setEnabled(false);
         * tp_view.setBackground(new Color(119, 136, 153)); 
         * tp_view.setBounds(0, 25,
         * 374, 396);
         */
        tp_view.setFont(new Font("한컴 고딕", Font.BOLD, 17));
        tp_view.setText((String) value);
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
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(204, 204, 255));
        panel_2.setLayout(null);
        panel_2.setBounds(399, 10, 154, 421);
        panel_1.add(panel_2);
        
        JButton btn_write = new JButton("");
        btn_write.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JtMemoWrite mWrite = new JtMemoWrite();
                // frame.setVisible(false);//메인창을 숨길 때
                frame.dispose();// 현재창을 종료시킬 때
            }
        });
        btn_write.setBounds(0, 61, 154, 50);
        panel_2.add(btn_write);
        
        
        btn_write.setBorderPainted(false); 
        btn_write.setContentAreaFilled(false);    
        btn_write.setFocusPainted(false);
        
        
        JButton btn_list = new JButton("");
        btn_list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JtMemo mList = new JtMemo();
                //frame.setVisible(false);//메인창을 숨길 때
                frame.dispose();//현재창을 종료시킬 때
            }
        });
        btn_list.setBounds(0, 121, 154, 50);
        panel_2.add(btn_list);
        
        
        btn_list.setBorderPainted(false); 
        btn_list.setContentAreaFilled(false);    
        btn_list.setFocusPainted(false);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(JtMemoView.class.getResource("/image_pack/\u3142\u314C.png")));
        lblNewLabel.setBounds(90, 10, 240, 53);
        panel_1.add(lblNewLabel);
        
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(JtMemoView.class.getResource("/image_pack/\uB2EB\uAE30 \uC5C6\uB294 \uBC84\uC804.jpg")));
        lblNewLabel_1.setBounds(0, 0, 154, 421);
        panel_2.add(lblNewLabel_1);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(204, 204, 255));
        panel_3.setBounds(12, 40, 374, 391);
        panel_1.add(panel_3);
        panel_3.setLayout(null);
        
        
        tp_view.setText((String) null);
        tp_view.setForeground(new Color(255, 250, 240));
        tp_view.setEnabled(false);
        tp_view.setBackground(new Color(102, 102, 204));
        tp_view.setBounds(0, 25, 374, 345);
        panel_3.add(tp_view);
        
     
    }
}
