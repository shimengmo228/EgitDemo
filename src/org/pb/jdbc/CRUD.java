package org.pb.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

	private Connection conn = null;
	private Statement stm = null;
	private ResultSet rs = null;
	private String sql;

	public CRUD(String sql) {
		try {
			conn = JdbcUtils.getConnection();
			stm = conn.createStatement();

		} catch (SQLException e) {
			throw new RuntimeException("DataBase Connection Error",e);
		} finally {
			JdbcUtils.free(rs, stm, conn);
		}
	}

	public static void main(String[] args) {

	}

	public  void create() {
		///
		//String sql = "insert into user(name, birthday, money) values('pb', '1989-02-28', 13000)";
		

	}
}
