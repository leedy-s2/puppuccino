package order_last_view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.JtItemDao;
import dao.JtOrderDao;
import dao.JtOrderItemDao;
import dto.JtItemDto;
import dto.JtOrderDto;
import dto.JtOrderItemDto;
import 메인.MainGUI;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class OrderGUI {

    private JFrame frame;
    private JTable table;
    private JTable table_1;
    String[] colNames = { "메뉴", "수량", "금액" };
    int i=0;
    int cnt = 0;
    int sum = 0;
    private JTextField od_no_1;
    JLabel lblNewLabel_2 = new JLabel("New label");
    JLabel lblNewLabel_4_1 = new JLabel("0\uC6D0");
    JLabel lblNewLabel_4 = new JLabel("0");
    private JPanel panel_1;
    
    /**
     * Create the application.
     */
    public OrderGUI() {
        initialize();
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(128, 144, 233));
        frame.setBounds(500, 200, 868, 575);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(12, 300, 828, 242);
        frame.getContentPane().add(panel);
        panel.setBackground(new Color(128, 144, 233));
        
        panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBackground(new Color(153, 153, 204));
        panel_1.setBounds(12, 35, 501, 265);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 10, 477, 245);
        panel_1.add(scrollPane);

        table_1 = new JTable();
        JtOrderItemDao dao = new JtOrderItemDao();
        ArrayList<JtOrderItemDto> oItemL = dao.selectJtOrderItem();
        Object[][] datas = new Object[oItemL.size()][colNames.length];

        od_no_1 = new JTextField();
        
        for (int i = 0; i < oItemL.size(); i++) {
            datas[i][0] = oItemL.get(i).getOdi_name();
            datas[i][1] = oItemL.get(i).getOdi_cnt();
            datas[i][2] = oItemL.get(i).getOdi_price();
            sum += oItemL.get(i).getOdi_price();
            od_no_1.setText(Integer.toString(oItemL.get(i).getOd_no()));
        }
        DefaultTableModel model = new DefaultTableModel(datas, colNames);
        table = new JTable(model);
        //table = new JTable(datas, colNames);
        scrollPane.setViewportView(table);
        panel.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(12, 12, 454, 211);
        panel.add(tabbedPane);

        JPanel panel_3 = new JPanel();
        
        panel_3.setBounds(516, 0, 324, 536);
        frame.getContentPane().add(panel_3);
        panel_3.setBackground(new Color(255, 0, 0, 0));
        panel_3.setLayout(null);
        lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 15));


        
        lblNewLabel_2.setBounds(180, 73, 177, 21);
        panel_3.add(lblNewLabel_2);
        lblNewLabel_2.setText("0");
        lblNewLabel_4_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        lblNewLabel_4_1.setText("0");
        
        JtItemDao itemDao = new JtItemDao();
        ArrayList<JtItemDto> itemL = itemDao.selectItem(1);
        Object[][] data = new Object[itemL.size()][5];

        String[] btnTitle = new String[itemL.size()];
        for (int i = 0; i < itemL.size(); i++) {
            data[i][0] = itemL.get(i).getIt_no();
            data[i][1] = itemL.get(i).getIt_name();
            data[i][2] = itemL.get(i).getIt_price();
            btnTitle[i] = itemL.get(i).getIt_name();
            //System.out.println(itemL.get(i).getIt_name());
        }
        //Object[][] data2 = new Object[1][data[0].length];
        
        JPanel people = new JPanel();
        people.setToolTipText("");
        tabbedPane.addTab("커  피", null, people, null);
        people.setLayout(null);
        
        JButton[] btn = new JButton[itemL.size()];
        int num = 20;
        int num2 = 20;

        for(i=0; i<data.length; i++) {
            btn[i] = new JButton(itemL.get(i).getIt_name());
            btn[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String text = e.getActionCommand();
                    updateTable(scrollPane, colNames, text, 1);
                }
            });
            
            btn[i].setBounds(num, num2, 95, 40);
            btn[i].setBackground(new Color(151, 149, 244));
            people.add(btn[i]);
            num+=100;
            if((i+1)%4==0 && i!=0) {
                num2+=50;
                num=20;
            }
        }

        /*
        JPanel panel_1 = new JPanel();
        panel_1.setToolTipText("");
        tabbedPane.addTab("커  피", null, panel_1, null);
        panel_1.setLayout(null);
        JButton btn_ca1_1 = new JButton("\uD5E4\uC774\uC990\uB11B");
        btn_ca1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // for(int i=0; i<odList.size(); i++) {
                int cnt2 = 0;
                data[0][0] = odList.get(1).getIt_name();
                data[0][1] = ++cnt;
                data[0][2] = odList.get(1).getIt_price() * cnt;
                sum += odList.get(1).getIt_price();
                updateTable(scrollPane, colNames, data);
                
                Order_ItemDTO itemList = new Order_ItemDTO(odList.get(1).getIt_name(),++cnt2,odList.get(1).getIt_price() * cnt2);
                lblNewLabel_2.setText(sum + "원");
                
              
              OrderDAO dao = new OrderDAO();
                              insertOrderItem
              dao.seqGet();
            }

        });
        btn_ca1_1.setBounds(52, 53, 97, 39);
        panel_1.add(btn_ca1_1);
        */
       
        JPanel animal = new JPanel();
        tabbedPane.addTab("퍼  피", null, animal, null);
        animal.setLayout(null);

        JButton btn_ca2_1 = new JButton("\uD37C\uD478\uCE58\uB178");
        btn_ca2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //data[0][0] = odList.get(5).getIt_name();
                //data[0][1] = ++cnt6;
                //data[0][2] = odList.get(5).getIt_price() * cnt6;
                //sum += odList.get(1).getIt_price();
                //updateTable(scrollPane, colNames, data2);
                //lblNewLabel_2.setText(sum + "원");
            }
        });
        
        JtItemDao itemDao2 = new JtItemDao();
        ArrayList<JtItemDto> itemL2 = itemDao.selectItem(2);
        Object[][] dataa = new Object[itemL2.size()][5];
        JButton[] btn2 = new JButton[itemL2.size()];
        int num3 = 20;
        int num33 = 20;

        for(i=0; i<dataa.length; i++) {
            btn2[i] = new JButton(itemL2.get(i).getIt_name());
            btn2[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String text = e.getActionCommand();
                    updateTable(scrollPane, colNames, text, 2);
                }
            });
            
            btn2[i].setBounds(num3, num33, 95, 40);
            btn2[i].setBackground(new Color(150, 120, 200));
            animal.add(btn2[i]);
            num3+=100;
            if((i+1)%4==0 && i!=0) {
                num33+=50;
                num3=20;
            }
        }

        JButton btn_main = new JButton("");
        btn_main.setBounds(552, 155, 257, 82);
        btn_main.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	MainGUI ma = new MainGUI();
            	frame.dispose();
            }
        });
        panel.add(btn_main);
        btn_main.setBorderPainted(false); 
        btn_main.setContentAreaFilled(false);    
        btn_main.setFocusPainted(false);
        lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        

        
        lblNewLabel_4.setBounds(182, 111, 177, 30);
        panel_3.add(lblNewLabel_4);

        
        lblNewLabel_4_1.setBounds(153, 155, 177, 30);
        panel_3.add(lblNewLabel_4_1);

        JButton btn_coupon = new JButton("");
        btn_coupon.setBounds(552, 64, 264, 72);
        btn_coupon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblNewLabel_4.setText("500");
                sum = sum - 500;
                lblNewLabel_4_1.setText((Integer.parseInt(lblNewLabel_2.getText())-500) + "");
            }
        });
        panel.add(btn_coupon);
        
        btn_coupon.setBorderPainted(false); 
        btn_coupon.setContentAreaFilled(false);    
        btn_coupon.setFocusPainted(false);
        
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(423, 28, 375, 218);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(OrderGUI.class.getResource("/image_pack/\uC790\uB978\uBC84\uC804.jpg")));
        lblNewLabel_1.setBounds(493, 5, 333, 227);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_3 = new JLabel();
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(153, 116, 159, 63);
        panel_3.add(lblNewLabel_3);

        JButton btn_pay = new JButton("");
        btn_pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                JtOrderDao dao = new JtOrderDao();
                JtOrderDto dto = new JtOrderDto(Integer.parseInt(od_no_1.getText()), Integer.parseInt(lblNewLabel_4_1.getText()));
                int result = dao.updateOrder(dto);
                if(result > 0) {
                    JtOrderItemDao dao2 = new JtOrderItemDao();
                    JtOrderItemDto dto2 = new JtOrderItemDto(Integer.parseInt(od_no_1.getText()));
                    int result2 = dao2 .updateOrderItem(dto2);
                    if(result2 > 0) {
                        JOptionPane.showMessageDialog(null, "결제 완료!");
                        OrderGUI guiL = new OrderGUI();
                        // frame.setVisible(false);//메인창을 숨길 때
                        frame.dispose();// 현재창을 종료시킬 때
                    } else {
                        JOptionPane.showMessageDialog(null, "oi 결제실패", "Error", 1);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "o 결제실패", "Error", 1);
                }
                    //JtOrderVto dto2 = dao.selectLastOrderNo();
                    //insert item 구문
                    //System.out.println(dto2.getOd_no());
                    
                    //상품명, 상품가격, 
                    
                    
                    
                    //Order_ItemDAO dao = dao.insertOrderItem(vo2);
                //}

//              DefaultTableModel model = new DefaultTableModel(data, colNames);
//              JTable table_1 = new JTable(model);
//              model.fireTableDataChanged();
//  
            }
        });
          
        btn_pay.setBorderPainted(false); 
        btn_pay.setContentAreaFilled(false);    
        btn_pay.setFocusPainted(false);
        

        btn_pay.setFont(new Font("굴림", Font.PLAIN, 20));
        btn_pay.setBounds(66, 216, 183, 69);
        panel_3.add(btn_pay);
        
        
        od_no_1.setEnabled(false);
        od_no_1.setEditable(false);
        od_no_1.setBackground(new Color(240,240,240));
        od_no_1.setBounds(12, 136, -10, -2);
        panel_3.add(od_no_1);
        od_no_1.setColumns(10);
        
                JLabel lblNewLabel_6 = new JLabel("New label");
                lblNewLabel_6.setBounds(-513, 0, 850, 534);
                panel_3.add(lblNewLabel_6);
                lblNewLabel_6.setIcon(new ImageIcon(OrderGUI.class.getResource("/image_pack/ppcn+pos+coffee.jpg")));
        
      

    }

    private JButton addActionListener(ActionListener actionListener) {
        // TODO Auto-generated method stub
        return null;
    }

    private void updateTable(JScrollPane scrollPane, String[] colNames, String text, int num) {
        JtItemDao dao = new JtItemDao();
        ArrayList<JtItemDto> itemL = dao.selectItem(num);
        Object[][] data = new Object[itemL.size()][5];

        String[] btnTitle = new String[itemL.size()];
        for (int i = 0; i < itemL.size(); i++) {
            data[i][0] = itemL.get(i).getIt_no();
            data[i][1] = itemL.get(i).getIt_name();
            data[i][2] = itemL.get(i).getIt_price();
            btnTitle[i] = itemL.get(i).getIt_name();
        }

        Object[][] data2 = new Object[1][data[0].length];
        
        //System.out.println(text);
        for(i = 0; i<data.length; i++) {
            for(int j =i; j<data.length; j++) {
                if(data[j][1].equals(text)) {
                    data2[0][0] = data[i][0];
                    data2[0][1] = data[i][1];
                    data2[0][2] = data[i][2];
                }
                //System.out.println(data2[0][0]+"--"+data2[0][1]+"--"+data2[0][2]);
            }
        }

        int mem_no = 100;
        int od_no = 0;
        
        int it_no = (int)data2[0][0];
        String od_name = (String)data2[0][1];
        int od_price = (int)data2[0][2];
        int od_cust_price = 0;
        //System.out.println(it_no+" "+od_name+" "+od_price);

        //주문테이블
        JtOrderDto orderDto = new JtOrderDto(od_name, od_price, mem_no);
        JtOrderDao orderDao = new JtOrderDao();
        int mem_nos = orderDao.selectOrder(orderDto);
        //System.out.println(mem_nos);
        if(mem_nos > 0) {
            //회원번호가 있을때는 order에는 insert 시키지 않음.
            int od_nos = orderDao.seqGet();
            //System.out.println(od_nos);
            JtOrderItemDto  oItemDto = new JtOrderItemDto(od_nos, it_no, od_name, od_price, mem_nos);
            JtOrderItemDao oItemDao = new JtOrderItemDao();
            int cnts = oItemDao.insertOrderItem(oItemDto);
            //OrderGUI guiL = new OrderGUI();
            //frame.dispose();// 현재창을 종료시킬 때
            //table.repaint();
        } else {
            int cnt2 = orderDao.insertOrder(orderDto);
            if (cnt2 > 0) {
                od_no = orderDao.seqGet();
                
                //OrderGUI guiL = new OrderGUI();
                // frame.setVisible(false);//메인창을 숨길 때
                //frame.dispose();// 현재창을 종료시킬 때
                //table.repaint();
            } else {
                od_no = 0;
            }
            //System.out.println(od_no);
        }
        /*
        //주문상세테이블
        JtOrderItemDto oItemDto = new JtOrderItemDto(od_no, it_no, od_name, od_price, mem_no);
        jtOrderItemDao oItemDao = new jtOrderItemDao();
        int cnt21 = oItemDao.insertOrderItem(oItemDto);
        if (cnt21 > 0) {
            od_no = orderDdao.seqGet();
        } else {
            od_no = 0;
        }
        */
        JtOrderItemDao dao3 = new JtOrderItemDao();
        ArrayList<JtOrderItemDto> oItemL = dao3.selectJtOrderItem();
        Object[][] datas = new Object[oItemL.size()][colNames.length];

        od_no_1 = new JTextField();
        int sum2 = 0;
        for (int i = 0; i < oItemL.size(); i++) {
            datas[i][0] = oItemL.get(i).getOdi_name();
            datas[i][1] = oItemL.get(i).getOdi_cnt();
            datas[i][2] = oItemL.get(i).getOdi_price();
            sum2 += oItemL.get(i).getOdi_price();
            od_no_1.setText(Integer.toString(oItemL.get(i).getOd_no()));
        }
        lblNewLabel_2.setText(sum2 + "");
        int a = Integer.parseInt(lblNewLabel_4.getText());
        lblNewLabel_4_1.setText((sum2 - a) + "");
        DefaultTableModel model2 = new DefaultTableModel(datas, colNames);
        table = new JTable(model2);
        scrollPane.setViewportView(table);
    }
}
