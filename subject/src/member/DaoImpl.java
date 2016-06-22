package member;

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
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Member m) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql;
		sql = "INSERT INTO MEMBER (NUM, NAME, TEL, EMAIL, DEPT, TYPE) VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m.getNum());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getTel());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getDept());
			pstmt.setInt(6, m.getType());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public Member select(int num) {
		System.out.println("int num: "+num);
		conn = db.getConnection();
		String sql;
		Member mem = new Member();
		sql = "SELECT NUM, NAME, TEL, EMAIL, DEPT, TYPE FROM MEMBER WHERE NUM="+num;
		
		try {
			stmt = conn.createStatement();					
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				mem.setNum(rs.getInt(1));
				mem.setName(rs.getString(2));
				mem.setTel(rs.getString(3));
				mem.setEmail(rs.getString(4));
				mem.setDept(rs.getString(5));
				mem.setType(rs.getInt(6));
			}
			System.out.println("memNum: "+mem.getNum());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return mem;
	}

	@Override
	public void update(Member m) {
		conn = db.getConnection();
		String sql;
		int num = m.getNum();
		sql = "UPDATE MEMBER SET DEPT = ?,  EMAIL = ?, NAME = ?, TEL = ? WHERE NUM ="+ num;

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getDept());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getTel());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void delete(int num) {
		// 
		conn = db.getConnection();
		String sql = "DELETE FROM MEMBER WHERE NUM = "+ num;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}



	@Override
	public List<Member> SelectAll() {
		// TODO Auto-generated method stub
		
		ArrayList<Member> list = new ArrayList<Member>();
		
		conn = db.getConnection();
		String sql;
		sql = "SELECT NUM, NAME, TEL, EMAIL, DEPT, TYPE FROM MEMBER";
		
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					list.add(new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
				} 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
		return list;
	}
}
