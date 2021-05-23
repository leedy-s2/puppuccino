package Advertisement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Desktop;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class donation_plz {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	public donation_plz() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(650, 300, 497, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(donation_plz.class.getResource("/image_pack/\uD6C4\uC6D0\uBC84\uD2BC.jpg")));
		lblNewLabel.setBounds(0, 0, 481, 394);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btn_donate = new JButton("New button");
		btn_donate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				  if (Desktop.isDesktopSupported()) {
			            Desktop desktop = Desktop.getDesktop();
			            try {
			                URI uri = new URI("https://www.smhrd.or.kr/");
			                desktop.browse(uri);
			            } catch (IOException ex) {
			                ex.printStackTrace();
			            } catch (URISyntaxException ex) {
			                ex.printStackTrace();
			            }
			    }
				  frame.dispose();
			}

		});
		btn_donate.setBounds(32, 168, 426, 99);
		frame.getContentPane().add(btn_donate);
		
		btn_donate.setBorderPainted(false); 
		btn_donate.setContentAreaFilled(false);    
		btn_donate.setFocusPainted(false);
	      
		
		JButton btn_nexttime = new JButton("New button");
		btn_nexttime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});

		btn_nexttime.setBounds(32, 287, 426, 97);
		frame.getContentPane().add(btn_nexttime);
		
		 btn_nexttime.setBorderPainted(false); 
		 btn_nexttime.setContentAreaFilled(false);    
		 btn_nexttime.setFocusPainted(false);
		 
		
	      
		 
	}
}
