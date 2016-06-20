package imgBoard.img;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.support.JdbcUtils;


public class ImgDaoImpl implements ImgDao {

	private DataSource dataSource;
	private Connection conn;
	
	

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Img i) {
		// TODO Auto-generated method stub
		String sql = "insert into img values(seq_img.nextval, "
				+ "?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, i.getTitle());
			pstmt.setString(2, i.getPath());
			pstmt.setString(3, i.getWriter());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}

	}

	@Override
	public Img select(int num) { 
		// TODO Auto-generated method stub
		Img i = null;
		ResultSet rs = null;
		String sql = "select num, title, path, writer from Img where num=?";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				i = new Img(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return i;

	}

	@Override
	public ArrayList<Img> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Img> list = new ArrayList<Img>();
		ResultSet rs = null;
		String sql = "select num, title, path, writer from Img";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new Img(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return list;

	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		String sql = "delete Img where num=?";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
	}

}
