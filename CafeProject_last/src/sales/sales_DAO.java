package sales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class sales_DAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			// 2. 데이터베이스 연결 객체 생성(Connection)
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
	
	public ArrayList<SalesVO> selectStd(String date) {
		ArrayList<SalesVO> al = new ArrayList<SalesVO>();


		try {
			connect();

			// 3. sql구문을 준비해주는 객체 (PreparedStatement) 생성
			String sql = "select * from jt_order WHERE TO_CHAR(od_date, 'YYYY-MM-DD') =?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, date);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String item = rs.getString(2);// 컬럼 순서로도 값을 가져올 수 있다. String item = rs.getString(1); int
				int pay = rs.getInt(4); 
			
				SalesVO vo = new SalesVO(item, pay); 
				al.add(vo); 
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return al;
	}
	
	
	public int selectMonth(String month) {		
		int sales= 0;
		try {
			connect();

			// 3. sql구문을 준비해주는 객체 (PreparedStatement) 생성
			
			//String sql = "select * from jt_order where od_date =?";
			//String sql = "select sum(od_price) as price from jt_order WHERE to_char(od_date, "YYYY-MM");"
			String sql = "select sum(od_price) as price from jt_order WHERE TO_CHAR(od_date, 'YYYY-MM') = ?";					
			// '?-01' and to date '?-31'
			pst = conn.prepareStatement(sql);
			//pst.setString(1, date);
		    pst.setString(1, month);
			//pst.setString(2, month);// 2020-?-01
			rs = pst.executeQuery();
			
			while(rs.next()) {
				//String month = rs.getString(1);// 컬럼 순서로도 값을 가져올 수 있다. String item = rs.getString(1); int
				sales = rs.getInt("price"); 							
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return sales;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
