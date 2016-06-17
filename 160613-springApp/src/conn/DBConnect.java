package conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static DBConnect db = new DBConnect();
	private Connection conn = null;
	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	String jdbc_url = "jdbc:oracle:thin:@192.168.14.171:1521:xe";
	
	private DBConnect() {
	}

	public static DBConnect getInstance() {
		return db;
	}
	public Connection getConnection(){
		
		// TODO Auto-generated constructor stub
		try {
			Class.forName(jdbc_driver);
			// �����ͺ��̽� ���������� �̿��� Connection �ν��Ͻ� Ȯ��
			conn = DriverManager.getConnection(jdbc_url, "hr", "hr");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
