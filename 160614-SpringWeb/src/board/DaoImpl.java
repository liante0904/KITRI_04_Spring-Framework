package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.support.JdbcUtils;

import member.Join;



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
	public void insert(Article a) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO BOARD VALUES(seq_board.nextval, sysdate, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, a.getWriter()); // writer
			pstmt.setString(2, a.getTitle()); // title
			pstmt.setString(3, a.getContent()); // content
			pstmt.setInt(4, a.getParent());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		} 
	}

	@Override
	public Article select(int num) {
		// TODO Auto-generated method stub
		Article a = null;
		ResultSet rs = null;
		String sql = "select NUM, W_DATE, TITLE, WRITER, CONTENT, PARENT"+ " from BOARD WHERE num = ?";
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				a = new Article(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return a;
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		List<Article> list = new ArrayList<Article>();
		ResultSet rs = null;
		String sql = "select NUM, W_DATE, TITLE, WRITER, CONTENT, PARENT"+ " from BOARD WHERE parent = 0 "
		+"order by num";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new Article(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return list;
	}

	@Override
	public List selectByParentNum(int parentNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		String sql = "DELETE BOARD WHERE NUM = ?";

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
		} 
	}

	@Override
	public void update(Article a) {
		// TODO Auto-generated method stub
		String sql = "update board set w_date=sysdate, "
				+ "title=?, content=? where num=?";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, a.getTitle());
			pstmt.setString(2, a.getContent());
			pstmt.setInt(3, a.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
	}

	@Override
	public Article selectByNum(int num) {
		// TODO Auto-generated method stub
		List<Article> list = new ArrayList<Article>();
		ResultSet rs = null;
		String sql = "select NUM, W_DATE, TITLE, WRITER, CONTENT, PARENT"+ " from BOARD WHERE NUM = ? "
		+"order by num";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new Article(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return (Article) list;
	}

	@Override
	public List selectByWriter(String writer) {
		// TODO Auto-generated method stub
		List<Article> list = new ArrayList<Article>();
		ResultSet rs = null;
		String sql = "select NUM, W_DATE, TITLE, WRITER, CONTENT, PARENT"+ " from BOARD WHERE WRITER = ? "
		+"order by num";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new Article(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return list;
	}

	@Override
	public List selectByTitle(String title) {
		// TODO Auto-generated method stub
		List<Article> list = new ArrayList<Article>();
		ResultSet rs = null;
		String sql = "select NUM, W_DATE, TITLE, WRITER, CONTENT, PARENT"+ " from BOARD WHERE TITLE = ? "
		+"order by num";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new Article(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return list;
	}

}
