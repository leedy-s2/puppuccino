package 직원관리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MemberDAO {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String sql = "";

	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.데이터베이스 연결객체(connection)생성

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (pst != null) {
				conn.close();

			}
			if (conn != null) {
				conn.close();

			}
			if (rs != null) {
				conn.close();

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

//	public MemberVO loginSelect(String name, String phone) {
//		MemberVO vo = null;
//
//		connect();
//		String sql = "select * from memberinfo where name =? and phone=? ";
//
//		try {
//			pst = conn.prepareStatement(sql);
//			pst.setString(1, name);
//			pst.setString(2, phone);
//			rs = pst.executeQuery(); // 변경된게 있을때 쿼리 사용
//			while (rs.next()) {
//				
//				String selName = rs.getString(1);
//				String selPhone = rs.getString(2);
//
//				vo = new MemberVO(selName, selPhone);
//			}
//
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		} finally {
//
//			close();
//
//		}
//
//		return vo;
//	}
	public ArrayList<MemberVO> selectStd() {

		ArrayList<MemberVO> al = new ArrayList<MemberVO>();

		try {

			connect();

			// 3. sql구문 준비 객체 (preparedstatement)

			sql = "select*from jt_member";
			pst = conn.prepareStatement(sql);

			// 4 sql 실행하여 결과 처리 하겠습니다.
			rs = pst.executeQuery();

			while (rs.next()) {

				String name1 = rs.getString("name");

				MemberVO vo = new MemberVO(name1);

				al.add(vo);
//				System.out.println("=================================");
//				System.out.println("학생번호 :" + student_num);
//				System.out.println("학생이름 : " + name);
//				System.out.println("학생 나이 :" + age);
//				System.out.println("학생전화번호 :" + phone);
//				System.out.println("이메일" + mail);
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

	public MemberVO oneSelectStd(MemberVO vo) {
		MemberVO vo2 = null;
		try {
			connect();
			sql = " SELECT mem_no, mem_id FROM jt_member WHERE mem_name = ? AND ROWNUM = 1 ";
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getMem_name());
			rs = pst.executeQuery();
			int cnt = 0;
			while (rs.next()) {
				cnt++;
				// String name = rs.getString("name");
				vo2 = new MemberVO(rs.getInt("mem_no"), rs.getString("mem_id"));
				System.out.println("찾아부렀");
				/*
				 * System.out.println(vo.getMem_no()); System.out.println("------------");
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo2;
	}

	public int joinInsert(MemberVO vo) {

		int cnt = 0;
		connect();

		sql = "insert into jt_member values(mem_no_seq.nextval, ?,?,?,?,?,2,null,?)";
		try {

			pst = conn.prepareStatement(sql);

			pst.setString(1, vo.getMem_id());
			pst.setString(2, vo.getMem_password());
			pst.setString(3, vo.getMem_name());
			pst.setString(4, vo.getMem_phone());
			pst.setString(5, vo.getMem_email());
			pst.setInt(6, vo.getMem_denied());

			cnt = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close();
		}
		return cnt;
	}

	public ArrayList<MemberVO> MemberList() {
		ArrayList<MemberVO> MemberList = new ArrayList<MemberVO>();

		connect();
		sql = " select * from jt_member where mem_level_no = 2 ";

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {

				String Mem_name = rs.getString(2);
				String Memc_sdate = rs.getString(5);
				String Memc_edate = rs.getString(6);

				// System.out.println(Mem_name);

				MemberList.add(new MemberVO(Mem_name));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return MemberList; // Null이 리턴된다.

	}

	public MemberVO loginSelect(String id, String pw) {
		MemberVO vo = null;

		connect();
		sql = "select * from jt_member where MEM_ID =? and MEM_PASSWORD=? and MEM_LEVEL_NO=1 ";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			rs = pst.executeQuery(); // 변경된게 있을때 쿼리 사용
			while (rs.next()) {

				String selid = rs.getString(1);
				String selpw = rs.getString(2);
				int denied = 1;

				vo = new MemberVO(1, selid, selpw);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			close();

		}

		return vo;
	}

	public ArrayList<MemberVO> selectStd2() {

		ArrayList<MemberVO> al = new ArrayList<MemberVO>();

		try {

			connect();

			// 3. sql구문 준비 객체 (preparedstatement)

			sql = "select*from jt_member";
			pst = conn.prepareStatement(sql);

			// 4 sql 실행하여 결과 처리 하겠습니다.
			rs = pst.executeQuery();

			while (rs.next()) {

				String Mem_name = rs.getString("name");

				MemberVO vo = new MemberVO(Mem_name);

				al.add(vo);
//				System.out.println("=================================");
//				System.out.println("학생번호 :" + student_num);
//				System.out.println("학생이름 : " + name);
//				System.out.println("학생 나이 :" + age);
//				System.out.println("학생전화번호 :" + phone);
//				System.out.println("이메일" + mail);
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

	public MemberAttendVO insertAttend22(MemberVO vo) {
		MemberAttendVO vo2 = null;
		sql = " SELECT A.mem_no,  B.mem_id, B.mem_name, A.memc_sdate, A.memc_edate "
				+ "FROM jt_member_commute A, jt_member B " + "WHERE A.mem_no = B.mem_no " + "AND A.mem_no = ? "
				+ "AND to_char(A.memc_sdate,'YYYY-MM-DD') = to_char(sysdate, 'YYYY-MM-DD') ";

		connect();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, vo.getMem_no());
			rs = pst.executeQuery();

			while (rs.next()) {
				int mem_no = rs.getInt("mem_no");
				String mem_id = rs.getString("mem_id");
				String mem_name = rs.getString("mem_name");
				String memc_sdate = rs.getString("memc_sdate");
				System.out.println("1:" + mem_no);
				System.out.println("2:" + mem_name);
				vo2 = new MemberAttendVO(0, mem_no, mem_id, mem_name, memc_sdate);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vo2;
	}

	public int insertAttend(MemberAttendVO vo) {
		ArrayList<MemberAttendVO> memAttendList = new ArrayList<MemberAttendVO>();
		System.out.println(vo.getMem_no());
		sql = " SELECT A.mem_no, B.mem_id, B.mem_name, A.memc_sdate, A.memc_edate "
				+ "FROM jt_member_commute A, jt_member B " + "WHERE A.mem_no = B.mem_no " + "AND A.mem_no = ? "
				+ "AND to_char(A.memc_sdate,'YYYY-MM-DD') = to_char(sysdate, 'YYYY-MM-DD') ";
		try {
			connect();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, vo.getMem_no());
			rs = pst.executeQuery();
			while (rs.next()) {
				// System.out.println(rs.getInt("mem_no"));
				int mem_no = rs.getInt("mem_no");
				String mem_id = rs.getNString("mem_id");
				String mems_sdate = rs.getString("mems_date");
//				memAttendList.add(new MemberAttendVO(mem_no, mem_id, mems_sdate));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close();
		}
		int cnt = 0;
		if (memAttendList.size() > 0) {
			System.out.println("-------------if------------");
			cnt = oneUpate(vo.getMem_no());
		} else {
			System.out.println("-------------else------------");
			System.out.println(vo.getMem_no() + "---" + vo.getMem_id());

			cnt = oneInsert(vo.getMem_no(), vo.getMem_id());
		}
		memAttendList = null;
		return cnt;
	}

	public String toDay() {
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		String time = format.format(today);
		// System.out.println(time);
		return time;
	}

	public int oneUpate(int mem_no) {
		int cnt2 = 0;
		sql = "UPDATE jt_member_commute " + " SET memc_edate = sysdate " + " WHERE mem_no = ? ";
		try {
			connect();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, mem_no);
			cnt2 = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt2;
	}

	public int oneInsert(int mem_no, String mem_id) {
		int cnt3 = 0;
		sql = "INSERT INTO jt_member_commute " + "VALUES (memc_no_seq.nextval, ?, ?, sysdate, null, null, null)";
		System.out.println(sql);
		try {
			connect();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, mem_no);
			pst.setString(2, mem_id);
			cnt3 = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt3;
	}

	public ArrayList<MemberAttendVO> select() {
		ArrayList<MemberAttendVO> memberAttend = new ArrayList<MemberAttendVO>();

		String sql = "select a.mem_no, b.mem_name, a.memc_sdate, a.memc_edate from jt_member_commute a, jt_member b"
				+ " where a.mem_no = b.mem_no and to_char(a.memc_sdate, 'YYYY-MM-DD') = to_char(sysdate, 'YYYY-MM-DD') and b.mem_level_no = 2 ";
		try {
			connect();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			// pst.setString(1, toDay());
			while (rs.next()) {
				String name = rs.getString("mem_name");
				String date = toDay();
				MemberAttendVO aa = new MemberAttendVO(rs.getInt("mem_no"), rs.getString("mem_name"),
						rs.getString("memc_sdate"), rs.getString("memc_edate"));
				memberAttend.add(aa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return memberAttend;
	}

	public int delete(MemberVO vo) {
		int cnt = 0;
		connect();
		String sql = "delete from jt_member where mem_name = ?";
		System.out.println(vo.getMem_name());
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getMem_name());
			cnt = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
}
