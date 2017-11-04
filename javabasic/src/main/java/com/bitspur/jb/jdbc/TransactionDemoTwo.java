package com.bitspur.jb.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bitspur.jb.io.ResourceUtil;

public class TransactionDemoTwo {

	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = DBUtil.getConnect();
			stmt = connection.createStatement();
			System.out.println("before updating...");
			printOutCustomer(stmt);

			connection.setAutoCommit(false);

			String sql2 = "update customer set name='name_changed_back'";
			stmt.executeUpdate(sql2);
			System.out.println("after updating...");
			printOutCustomer(stmt);

			//rollback
			connection.rollback();

			System.out.println("after rollback:");
			printOutCustomer(stmt);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ResourceUtil.close(stmt, connection);
		}
	}

	public static void printOutCustomer(Statement stmt) {
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		try {
			rs = stmt.executeQuery("select * from customer");

			while (rs.next()) {
				sb.append(rs.getString("id") + ", " + rs.getString("name") + ", " + rs.getString("birthday") + "\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceUtil.close(rs);
		}
		System.out.println(sb.toString());
	}
}
