package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import dto.JtMemoDto;
import dto.JtOrderDto;

public class JtOrderDao {
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
    
    public int insertOrder(JtOrderDto orderDto) {
        connect();
        int cnt = 0;
        int max = 0;
        String sql = " INSERT INTO jt_order VALUES (od_no_seq.nextval, ?, sysdate, ?, ?) ";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, orderDto.getOd_name());
            psmt.setInt(2, orderDto.getOd_price());
            psmt.setInt(3,  orderDto.getMem_no());
            cnt = psmt.executeUpdate();
            if(cnt > 0) {
                max = seqGet();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return max;
    }
    
    public int seqGet() {
        int num = 0;
        try {
            connect();
            String sql = " SELECT MAX(od_no) AS od_no FROM jt_order ";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                 num = rs.getInt("od_no");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return num;
    }

    public int selectOrder(JtOrderDto orderDto) {
        int mem_no = 0;
        try {
            connect();
            String sql = " SELECT mem_no FROM jt_order WHERE mem_no = ? ";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, orderDto.getMem_no());
            rs = psmt.executeQuery();
            while (rs.next()) {
                mem_no = rs.getInt("mem_no");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return mem_no;
    }

    public int updateOrder(JtOrderDto orderDto) {
        connect();
        int cnt = 0;
        String sql = " UPDATE jt_order SET od_price = ? , mem_no = 0 WHERE od_no = ? AND mem_no = 100";
        System.out.println(orderDto.getOd_no() +"++"+ orderDto.getOd_price());
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, orderDto.getOd_price());
            psmt.setInt(2,  orderDto.getOd_no());
            cnt = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return cnt;
    }
}
