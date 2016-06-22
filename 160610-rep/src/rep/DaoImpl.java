package rep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;

public class DaoImpl implements Dao {

	private Connection conn;
	private DBConnect db;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;


	public DaoImpl() {
		db =  DBConnect.getInstance();
	}

	public int makeNum() {
		int num = 0;
		ResultSet rs = null;
		String sql = "select seq_rep.nextval from dual";
		Connection conn = null;
		conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {		
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int insert(Reply r) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		int num = makeNum();
		String sql = "INSERT INTO REP (NUM, NAME, CONTENT) VALUES(?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, r.getName());
			pstmt.setString(3, r.getContent());
			pstmt.executeQuery();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return num;
	}

	@Override
	public Reply select(int num) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		Reply r = new Reply();
		String sql = "SELECT * FROM rep WHERE NUM = " + num;
		Statement stmt;


		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {

				r.setNum(rs.getInt(1));
				r.setName(rs.getString(2));
				r.setContent(rs.getString(3));
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub

		ArrayList<Reply> list = new ArrayList<Reply>();

		conn = db.getConnection();
		String sql = "SELECT * FROM REP order by num";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				list.add(new Reply(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public int update(Reply r) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql;
		int num = r.getNum();
		sql = "UPDATE rep SET NAME = ?,  CONTENT = ? WHERE NUM ="+ num;
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getName());
			pstmt.setString(2, r.getContent());
			pstmt.executeQuery();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int num) {
		// TODO Auto-generated method stub
		System.out.println("여기는 서비스다"+num);
		conn = db.getConnection();
		String sql = "DELETE FROM rep WHERE NUM = "+ num;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

}
