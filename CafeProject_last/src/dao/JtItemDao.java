package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.JtItemDto;
//import dto.JtMemoDto;
import dto.JtOrderDto;

public class JtItemDao {
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;
    private String sql = "";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String user = "hr";
    private String password = "hr";

    
    public void connect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (rs != null)
                rs.close();
            if (psmt != null)
                psmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<JtItemDto> selectItem(int num) {
        ArrayList<JtItemDto> itemL = new ArrayList<JtItemDto>();
        JtItemDto dto = null;
        try {
            connect();
            sql = " SELECT * FROM jt_item WHERE ca_no = ? ";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, num);
            rs = psmt.executeQuery();
            while(rs.next()) {
                int it_no = rs.getInt("it_no");
                int ca_no = rs.getInt("ca_no");
                String it_name = rs.getString("it_name");
                int it_price = rs.getInt("it_price");
                int it_cust_price = rs.getInt("it_cust_price");
                
                dto = new JtItemDto(it_no, ca_no, it_name, it_price, it_cust_price);
                itemL.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return itemL;
    }
    
//    public ArrayList<JtMemoDto> selectJtMemo() {
//        ArrayList<JtMemoDto> memoL = new ArrayList<JtMemoDto>();
//        try {
//            connect();
//            sql = " SELECT * FROM jt_memo WHERE ROWNUM <= 10 ORDER BY mes_date DESC ";
//            psmt = conn.prepareStatement(sql);
//            rs = psmt.executeQuery();
//            while(rs.next()) {
//                int memo_no = rs.getInt("memo_no");
//                String memo_memo = rs.getString("memo_memo");
//                String mes_date = rs.getString("mes_date");
//                
//                JtMemoDto dto = new JtMemoDto(memo_no, memo_memo, mes_date);
//                memoL.add(dto);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close();
//        }
//        return memoL;
//    }
//    
}
