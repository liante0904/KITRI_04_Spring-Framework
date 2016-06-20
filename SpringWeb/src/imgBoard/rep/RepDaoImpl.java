package imgBoard.rep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.support.JdbcUtils;


public class RepDaoImpl implements RepDao {

	private DataSource dataSource;
	private Connection conn;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(ImgRep ir) {
		// TODO Auto-generated method stub
		String sql = "insert into img_rep values(seq_img_rep.nextval, ?, ?, ? )";
		PreparedStatement pstmt = null;
		try {
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, ir.getImgNum());
			pstmt.setString(2, ir.getWriter());
			pstmt.setString(3, ir.getContent());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}

	}

	@Override
	public ImgRep select(int num) {
		// TODO Auto-generated method stub
		ImgRep ir = null;
		ResultSet rs = null;
		String sql = "select num, img_num, writer, content from img_rep where num=?";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				ir = new ImgRep(rs.getInt(1), rs.getInt(2), 
						rs.getString(3), rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn);
		}
		return ir;

	}

	@Override
	public ArrayList<ImgRep> selectAll(int imgNum) {
		// TODO Auto-generated method stub
		ArrayList<ImgRep> list = new ArrayList<ImgRep>();
		ResultSet rs = null;
		String sql = "select num, img_num, writer, content from img_rep where img_num = ? ";
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, imgNum);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new ImgRep(rs.getInt(1), rs.getInt(2), 
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
		String sql = "delete img_rep where num=?";
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
