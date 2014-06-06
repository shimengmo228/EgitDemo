package org.pb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Base {

	/**
	 * @param args
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		test();
	}

	public static void test() throws SQLException, ClassNotFoundException {

		// 1、注册驱动
		//DriverManager类保持着一个驱动的列表，用一个Vector<Driver>表示。
		//JDBC规定Driver类的实现代码，都在static块中new了一个Driver自己的实例，
		//并通过DriverManager.registerDriver进行注册，
		//所以Class.forName执行时，就自动注册了驱动。
		// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver" );
		Class.forName("com.mysql.jdbc.Driver");

		// 2、建立连接，通过DriverManager获得一个数据库连接
		//第一个参数：协议名:子协议名://IP地址:端口号/数据库
		//第二个参数：登陆名
		//第三参数：登陆密码
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/jdbc", "root", "123456");

		// 3、创建语句，通过数据库连接获得一个数据库语句
		//创建Statement语句时，并不需要语句内容或格式作为参数
		Statement stm = conn.createStatement();

		// 4、执行语句
		//在执行语句的时候再确定语句的内容，执行查询语句返回结果集。
		ResultSet rs = stm.executeQuery("select * from user");

		// 5、处理结果
		while (rs.next()) {
			System.out.printf("%-10d\t%-45s\t%s\t%-9.2f\n", rs.getInt("id"),
					rs.getString("name"), rs.getDate("birthday"),
					rs.getFloat("money"));
		}

		// 6、释放资源，结果集资源，语句资源，连接资源。
		rs.close();
		stm.close();
		conn.close();
	}
}
