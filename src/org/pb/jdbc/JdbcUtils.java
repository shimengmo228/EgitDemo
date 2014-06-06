package org.pb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * JDBC工具类
 * 
 * 功能：1、自动加载驱动类。2、获得一个数据库连接。3、释放数据库资源。
 * 
 * @author daemon
 * 
 */

public final class JdbcUtils {

	private static String url = "jdbc:mysql://localhost:3306/jdbc";
	private static String user = "root";
	private static String password = "123456";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private JdbcUtils() {
	}
	
	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(url, user, password);

	}

	public static void free(ResultSet rs, Statement st, Connection conn) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
