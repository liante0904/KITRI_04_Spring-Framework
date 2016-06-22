package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	@Override
	public void insert(Join j) {
		// TODO Auto-generated method stub
		String sql = "insert into join values(?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, j.getId());
			pstmt.setString(2, j.getPwd());
			pstmt.setString(3, j.getName());
			pstmt.setString(4, j.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}

	}

	@Override
	public Join select(String id) {
		// TODO Auto-generated method stub
		Join j = null;
		ResultSet rs = null;
		String sql = "select * from Join where id = ?";
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);;
			rs = pstmt.executeQuery();
			if(rs.next()){
				j = new Join(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return j;
	}

	@Override
	public void update(Join j) {
		// TODO Auto-generated method stub
		String sql = "update Join set pwd = ?, name = ?, email = ? where id = ?";
		PreparedStatement pstmt = null;
		System.out.println("dao"+j.getId());
		System.out.println("dao"+j.getPwd());
		System.out.println("dao"+j.getName());
		System.out.println("dao"+j.getEmail());
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, j.getPwd());
			pstmt.setString(2, j.getName());
			pstmt.setString(3, j.getEmail());   
			pstmt.setString(4, j.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		} 
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		String sql = "delete Join where id = ?";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		} 
	}

}
