package goods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GoodsDAO {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // SelectGoods a = new SelectGoods();

    public void connect() {
        try {
            // 1. jdbc 드라이버 동적로딩
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "hr";
            String password = "hr";

            // 2. 데이터베이스 연결객체(Connection) 생성
            conn = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void close() {
        try {
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int joinInsert(GoodsVO vo) {
        int cnt = 0;
        connect();
        String sql = "insert into jt_item values(it_no_seq.nextval, ?, ?, ?, null, 2, 1, null) ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, vo.getCa_no());
            pst.setString(2, vo.getIt_name());
            pst.setInt(3, vo.getIt_price());
            cnt = pst.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close();
        }
        return cnt;
    }

    public ArrayList<GoodsVO> selectItem() {

        ArrayList<GoodsVO> al = new ArrayList<GoodsVO>();

        try {
            connect();

            String sql = " select * from jt_item ";
            // 3. sql구문 준비 객체(PreparedStatement) 생성
            pst = conn.prepareStatement(sql);
            // 4. sql 문을 실행하여 결과 처리
            rs = pst.executeQuery();
            while (rs.next()) {
                int it_no = rs.getInt("it_no");
                int ca_no = rs.getInt("ca_no");
                String it_name = rs.getString("it_name");
                int it_price = rs.getInt("it_price");
                int it_cust_price = rs.getInt("it_cust_price");
                String it_date = rs.getString("it_date");
                GoodsVO vo = new GoodsVO(it_no, ca_no, it_name, it_price, it_cust_price, it_date);
                al.add(vo);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            close();
        }
        return al;
    }

    public int updateTable(int it_no, int ca_no, String name, int it_price) {

        //boolean result = false;
        //System.out.println(name + ":" + it_price + ":" + it_cust_price + ":" + col);
        int cnt = 0;
        try {
            connect();
            String sql = "update jt_item set ca_no = ?, it_name = ?, it_price = ? where it_no = ? ";
            // 3. sql구문 준비객체(PreparedStatement) 생성
            pst = conn.prepareStatement(sql);

            // 4. 바인드 변수 채운다
            pst.setInt(1, ca_no);
            pst.setString(2, name);
            pst.setInt(3, it_price);
            pst.setInt(4, it_no);
            cnt = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return cnt;
    }
}
