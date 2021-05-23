package 직원관리;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import 메인.MainGUI;
import javax.swing.ImageIcon;

public class attendance_GUI {
	static MemberVO loginMember = null;
	Scanner sc = new Scanner(System.in);
	private JFrame frame;
	private JTextField tf_name;
	private JPanel panel;
	private String name;
	private JTable table_1;
	protected AbstractButton textPane;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	
			

	/**
	 * Create the application.
	 */
	public attendance_GUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 300, 523, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tf_name = new JTextField();
		tf_name.setBounds(178, 61, 130, 30);
		frame.getContentPane().add(tf_name);
		tf_name.setColumns(10);

		Date today = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("HH : mm : ss");

		String time1 = format1.format(today);
		// System.out.println(time1);

		panel = new JPanel();
		panel.setBounds(41, 103, 421, 246);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 431, 246);
		panel.add(scrollPane);
		MemberDAO dao = new MemberDAO();
		dao.MemberList();

		String[] colNames = {"번호", "이름", "출근", "퇴근" };
		ArrayList<MemberAttendVO> memberAttend = dao.select();
		Object[][] data = new Object[memberAttend.size()][4];
		for (int i = 0; i < memberAttend.size(); i++) {
			data[i][0] = i+1;
			data[i][1] = memberAttend.get(i).getMem_name();
			data[i][2] = memberAttend.get(i).getMemc_sdate();
			data[i][3] = memberAttend.get(i).getMemc_edate();
		}

		table_1 = new JTable(data, colNames);
		scrollPane.setViewportView(table_1);
		// scrollPane.setColumnHeaderView(table);

		JButton btn_input = new JButton("");
		btn_input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 이름값만 넘겨주면 됩니다.
				String name = tf_name.getText();
				MemberVO vo = new MemberVO(name);
				vo = dao.oneSelectStd(vo);

				if (vo == null) {
					System.out.println("없음");
					JOptionPane.showMessageDialog(null, "출근 실패", "출근실패", JOptionPane.ERROR_MESSAGE);
					// frame.dispose();
				} else {

					MemberAttendVO v = dao.insertAttend22(vo);
					if (v == null) {

						int c = dao.oneInsert(vo.getMem_no(), vo.getMem_id());

						JOptionPane.showMessageDialog(null, "출근 확인");
						attendance_GUI att = new attendance_GUI();
						frame.dispose();
					} else {
						
						System.out.println("성명 : " + vo.getMem_id());
						int c = dao.oneUpate(vo.getMem_no());
						System.out.println("업데이트 성공");
						attendance_GUI att = new attendance_GUI();
						frame.dispose();
					}

				}

//				MemberAttendVO vo2 = new MemberAttendVO(vo.getMem_no(), vo.getMem_id());
//				System.out.println(vo2.getMem_no());
//				if(vo2.getMem_no() > 0) {
//					int cnt = dao.insertAttend(vo2);
//					if(cnt > 0) {
//						JOptionPane.showMessageDialog(null, "출근 확인");
//						attendance_GUI.main(null);
//						frame.dispose();
//					}else {
//						JOptionPane.showMessageDialog(null, "출근 실패","출근실패",JOptionPane.ERROR_MESSAGE);
//						//frame.dispose();
//					}
//				}
			}

		});
		btn_input.setBounds(320, 61, 55, 30);
		frame.getContentPane().add(btn_input);
		
		btn_input.setBorderPainted(false); 
		btn_input.setContentAreaFilled(false);    
		btn_input.setFocusPainted(false);

		JButton btn_manage = new JButton("");
		btn_manage.setBounds(142, 376, 103, 35);
		frame.getContentPane().add(btn_manage);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			MainGUI main = new MainGUI();
			frame.dispose();
				
			}
		});
		btnNewButton.setBounds(264, 376, 111, 35);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.setBorderPainted(false); 
		btnNewButton.setContentAreaFilled(false);    
		btnNewButton.setFocusPainted(false);
		
		
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(attendance_GUI.class.getResource("/image_pack/\uC9C1\uC6D0\uAD00\uB9AC_1.jpg")));
		lblNewLabel_1.setBounds(0, 0, 507, 433);
		frame.getContentPane().add(lblNewLabel_1);
		btn_manage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login_GUI login = new login_GUI();
				frame.dispose();
			}
		});
		
		btn_manage.setBorderPainted(false); 
		btn_manage.setContentAreaFilled(false);    
		btn_manage.setFocusPainted(false);

	}
}
