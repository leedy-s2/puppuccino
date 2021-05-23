package Advertisement;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class doggy_food {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public doggy_food() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 300, 524, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(doggy_food.class.getResource("/image_pack/\uC0AC\uB8CC.jpg")));
		lblNewLabel.setBounds(0, 0, 508, 442);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
			}
			
		});
		btnNewButton.setBounds(0, 0, 508, 442);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.setBorderPainted(false); 
		btnNewButton.setContentAreaFilled(false);    
		btnNewButton.setFocusPainted(false);
		
	}
}
