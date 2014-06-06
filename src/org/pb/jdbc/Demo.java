package org.pb.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtilsSingle.getInstance().getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery("select * from user");
			while (rs.next()) {
				System.out.printf("%-10d\t%-45s\t%s\t%-9.2f\n",
						rs.getInt("id"), rs.getString("name"),
						rs.getDate("birthday"), rs.getFloat("money"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtilsSingle.getInstance().free(rs, stm, conn);

		}

	}

}
