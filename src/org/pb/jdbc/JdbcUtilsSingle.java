package org.pb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * JDBC������(����ʵ��)
 * 
 * ���ܣ�1���Զ����������ࡣ2�����һ�����ݿ����ӡ�3���ͷ����ݿ���Դ��
 * 
 * @author daemon
 * 
 */

public final class JdbcUtilsSingle {

	private String url = "jdbc:mysql://localhost:3306/jdbc";
	private String user = "root";
	private String password = "123456";

	// ���������ã�����ָ�򣬱�����static����
	private static JdbcUtilsSingle instance = null;

	// �ṩһ�����ʵ����ķ�����ʹ���ӳٳ�ʼ��
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
