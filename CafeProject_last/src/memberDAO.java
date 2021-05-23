import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class memberDAO {

	
	PreparedStatement pst = null;
	Connection conn = null;
	ResultSet rs = null;
	
	// sql connect 동적로딩
		public void connect() {
			// 1. JDBC 드라이버 동적 로딩. try catch 예외처리방법
			try {
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
		// sql 작동 닫기
		public void close() {
			try {
				if(pst != null) {
					pst.close();
				}if(conn != null) {
					conn.close();
				}if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
