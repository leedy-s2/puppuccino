import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class memberDAO {

	
	PreparedStatement pst = null;
	Connection conn = null;
	ResultSet rs = null;
	
	// sql connect �����ε�
		public void connect() {
			// 1. JDBC ����̹� ���� �ε�. try catch ����ó�����
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "hr";
				String password = "hr";

				// 2. �����ͺ��̽� ���ᰴü(Connection) ����
				conn = DriverManager.getConnection(url, user, password);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// sql �۵� �ݱ�
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
