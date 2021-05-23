package MEMO_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MEMO_dto.JtMemoDto;

public class JtMemoDao {
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
    
    public ArrayList<JtMemoDto> selectJtMemo() {
        ArrayList<JtMemoDto> memoL = new ArrayList<JtMemoDto>();
        try {
            connect();
            sql = " SELECT * FROM jt_memo WHERE ROWNUM <= 10 ORDER BY mes_date DESC ";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()) {
                int memo_no = rs.getInt("memo_no");
                String memo_memo = rs.getString("memo_memo");
                String mes_date = rs.getString("mes_date");
                
                JtMemoDto dto = new JtMemoDto(memo_no, memo_memo, mes_date);
                memoL.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return memoL;
    }

    public int insertMemo(JtMemoDto dto) {
        connect();
        int cnt = 0;
        String sql = " INSERT INTO jt_memo VALUES (memo_no_seq.nextval, ?, sysdate, null) ";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, dto.getMemo_memo());
            cnt = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return cnt;
    }
}
