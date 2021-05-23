package MEMO_view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.memo.JtMemo;
import view.memo.JtMemoWrite;
import 메인.MainGUI;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class JtMain {

    private JFrame frame;

    /**
     * Launch the application.
     */
    /**
     * Create the application.
     */
    public JtMain() {
        initialize();
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(700, 300, 522, 391);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 506, 352);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JtMemo mList = new JtMemo();
                // frame.setVisible(false);//메인창을 숨길 때
                frame.dispose();// 현재창을 종료시킬 때
            }
        });
        btnNewButton.setBounds(135, 102, 221, 158);
        panel.add(btnNewButton);
        
        btnNewButton.setBorderPainted(false); 
        btnNewButton.setContentAreaFilled(false);    
        btnNewButton.setFocusPainted(false);
	      
        
        
        JButton btn_back = new JButton("");
        btn_back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MainGUI m = new MainGUI();
				frame.dispose();
        		
        		
        	}
        });
        btn_back.setBounds(364, 305, 130, 37);
        panel.add(btn_back);
        
        btn_back.setBorderPainted(false); 
        btn_back.setContentAreaFilled(false);    
        btn_back.setFocusPainted(false);
	      
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(JtMain.class.getResource("/image_pack/\uBA54\uBAA8 \uC0C9\uAE54 \uC218\uC815.jpg")));
        lblNewLabel.setBounds(0, 0, 506, 352);
        panel.add(lblNewLabel);
        
   
        
        
    }
}
