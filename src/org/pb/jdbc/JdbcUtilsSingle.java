package org.pb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * JDBC工具类(单例实现)
 * 
 * 功能：1、自动加载驱动类。2、获得一个数据库连接。3、释放数据库资源。
 * 
 * @author daemon
 * 
 */

public final class JdbcUtilsSingle {

	private String url = "jdbc:mysql://localhost:3306/jdbc";
	private String user = "root";
	private String password = "123456";

	// 单例的引用，用于指向，必须用static修饰
	private static JdbcUtilsSingle instance = null;

	// 提供一个访问单例的方法，使用延迟初始化
	public static JdbcUtilsSingle getInstance() {
		if (instance == null) {
			synchronized (JdbcUtilsSingle.class) {
				if (instance == null) {
					instance = new JdbcUtilsSingle();
				}
			}
		}
		return instance;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private JdbcUtilsSingle() {
	}

	public Connection getConnection() throws SQLException {

		return DriverManager.getConnection(url, user, password);

	}

	public void free(ResultSet rs, Statement st, Connection conn) {
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
