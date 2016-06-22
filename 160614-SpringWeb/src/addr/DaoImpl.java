package addr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.support.JdbcUtils;


public class DaoImpl implements Dao {
	private DataSource dataSource;
	private Connection conn;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) { // 스프링 프로퍼티 설정 (setter)
		this.dataSource = dataSource;
	}


/*	public DaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	} // 생성자
*/
	@Override
	public String insert(Member m) {
		String sql = "insert into addr values(seq_addr.nextval, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getTel());
			pstmt.setString(3, m.getAddress());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		} return null;
	}

	@Override
	public Member select(int num) {

		Member m = null;
		ResultSet rs = null;
		String sql = "select * from addr where num = ?";
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				m = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return m;
	}

	@Override
	public List<Member> selectAll() {
		List<Member> list = new ArrayList<Member>();
		ResultSet rs = null;
		String sql = "select * from addr order by num";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
				/*   EmpBean eb = new EmpBean();   
               eb.setNum(rs.getInt("employee_id"));
               eb.setName(rs.getString("first_name"));
               eb.setTel(rs.getInt("manager_id"));
               eb.setAddress(rs.getString("job_id"));
               list.add(eb);
				 */
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return list;
	}

	@Override
	public int update(Member m) {
		String sql = "update addr set name = ?, tel = ?, address = ? where num = ?";
		PreparedStatement pstmt = null;
		System.out.println("dao 출력"+m.getNum());
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getTel());
			pstmt.setString(3, m.getAddress());   
			pstmt.setInt(4, m.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		} return 0;
	}

	@Override
	public int delete(int num) {
		String sql = "delete addr where num = ?";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		} return 0;
	}

}