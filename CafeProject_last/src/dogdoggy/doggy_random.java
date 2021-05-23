package dogdoggy;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import ∏ﬁ¿Œ.MainGUI;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class doggy_random {
	Timer timer;
	private JFrame frame;
	private String []images = {"≤Œ.jpg", "¥Û¥Û¿Ã¿Â≥≠∞®.jpg", "¥Û¥Û¿Ã ¿Â≥≠∞®2.jpg", "µµ±◊∫ÒæÓ.jpg", "∆€«™ƒ°≥Î.jpg", "≥™∫Ò≥ÿ≈∏¿Ã.jpg"};

	
	/**
	 * Create the application.
	 */
	public doggy_random() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		frame = new JFrame();
		frame.setBounds(700, 300, 450, 463);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 516, 484);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_photo = new JLabel("");
		lbl_photo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_photo.setBounds(48, 9, 343, 305);
		panel.add(lbl_photo);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				
			}
		});
		btnNewButton.setBounds(127, 324, 182, 37);
		panel.add(btnNewButton);
		
		btnNewButton.setBorderPainted(false); 
		btnNewButton.setContentAreaFilled(false);    
		btnNewButton.setFocusPainted(false);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGUI main = new MainGUI();
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(127, 377, 182, 37);
		panel.add(btnNewButton_1);
		
		btnNewButton_1.setBorderPainted(false); 
		btnNewButton_1.setContentAreaFilled(false);    
		btnNewButton_1.setFocusPainted(false);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(doggy_random.class.getResource("/image_pack/KakaoTalk_20210102_125929415.jpg")));
		lblNewLabel.setBounds(0, 0, 432, 424);
		panel.add(lblNewLabel);
		
		timer = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int n = (int)Math.floor(Math.random() * 6);
				String image = images[n];
				lbl_photo.setIcon(new ImageIcon("src//image//"+image));
			}
	});
		timer.start();
	}
	
}