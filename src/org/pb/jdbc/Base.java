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

		// 1��ע������
		//DriverManager�ౣ����һ���������б���һ��Vector<Driver>��ʾ��
		//JDBC�涨Driver���ʵ�ִ��룬����static����new��һ��Driver�Լ���ʵ����
		//��ͨ��DriverManager.registerDriver����ע�ᣬ
		//����Class.forNameִ��ʱ�����Զ�ע����������
		// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver" );
		Class.forName("com.mysql.jdbc.Driver");

		// 2���������ӣ�ͨ��DriverManager���һ�����ݿ�����
		//��һ��������Э����:��Э����://IP��ַ:�˿ں�/���ݿ�
		//�ڶ�����������½��
		//������������½����
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/jdbc", "root", "123456");

		// 3��������䣬ͨ�����ݿ����ӻ��һ�����ݿ����
		//����Statement���ʱ��������Ҫ������ݻ��ʽ��Ϊ����
		Statement stm = conn.createStatement();

		// 4��ִ�����
		//��ִ������ʱ����ȷ���������ݣ�ִ�в�ѯ��䷵�ؽ������
		ResultSet rs = stm.executeQuery("select * from user");

		// 5��������
		while (rs.next()) {
			System.out.printf("%-10d\t%-45s\t%s\t%-9.2f\n", rs.getInt("id"),
					rs.getString("name"), rs.getDate("birthday"),
					rs.getFloat("money"));
		}

		// 6���ͷ���Դ���������Դ�������Դ��������Դ��
		rs.close();
		stm.close();
		conn.close();
	}
}
