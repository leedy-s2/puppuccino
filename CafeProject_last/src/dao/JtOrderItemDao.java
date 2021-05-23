package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import dto.JtMemoDto;
import dto.JtOrderItemDto;

public class JtOrderItemDao {
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

    public int insertOrderItem(JtOrderItemDto oItemDto) {
        connect();
        int cnt = 0;
        
        System.out.print(oItemDto.getOd_no()+" "+oItemDto.getIt_no()+" "+oItemDto.getOdi_name()+" "+oItemDto.getOdi_price()+" "+oItemDto.getMem_no());
        
        String sql = " INSERT INTO jt_order_item VALUES (odi_no_seq.nextval, ?, ?, ?, sysdate, ?, ?) ";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, oItemDto.getOd_no());
            psmt.setInt(2, oItemDto.getIt_no());
            psmt.setString(3, oItemDto.getOdi_name());
            psmt.setInt(4, oItemDto.getOdi_price());
            psmt.setInt(5, oItemDto.getMem_no());
            cnt = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return cnt;
    }

    public ArrayList<JtOrderItemDto> selectJtOrderItem() {
        ArrayList<JtOrderItemDto> oItemL = new ArrayList<JtOrderItemDto>();
        try {
            connect();
            sql = " SELECT count(it_no) AS odi_cnt, sum(odi_price) AS odi_price,  it_no, odi_name, od_no, mem_no FROM jt_order_item WHERE mem_no = 100 GROUP BY it_no, odi_name, mem_no, od_no "; 
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()) {
                int it_no = rs.getInt("it_no");
                int od_no = rs.getInt("od_no");
                String odi_name = rs.getString("odi_name");
                int odi_cnt = rs.getInt("odi_cnt");
                int odi_price = rs.getInt("odi_price");
                int mem_no = rs.getInt("mem_no");
                
                JtOrderItemDto dto = new JtOrderItemDto(od_no, it_no, odi_name, odi_price, odi_cnt, mem_no);
                oItemL.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return oItemL;
    }

    public int updateOrderItem(JtOrderItemDto dto2) {
        connect();
        int cnt = 0;
        String sql = " UPDATE jt_order_item SET mem_no = 0 WHERE mem_no = 100 AND od_no = ? ";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, dto2.getOd_no());
            cnt = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return cnt;
    }
}
