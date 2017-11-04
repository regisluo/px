package com.bitspur.jb.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bitspur.jb.io.ResourceUtil;

public class TransactionDemo {

	public static void main(String[] args) {
		Connection connection = null;
		String sql = "select * from customer";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connection = DBUtil.getConnect();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("id") + ", " + rs.getString("name") + ", " + rs.getString("birthday"));
			}
			connection.setAutoCommit(false);

			String sql2 = "update customer set name='name_changed_back'";
			stmt.executeUpdate(sql2);

			System.out.println("\nupdate execute before commit:");
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("id") + ", " + rs.getString("name") + ", " + rs.getString("birthday"));
			}
			connection.rollback();

			System.out.println("\nupdate execute after rollback:");
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("id") + ", " + rs.getString("name") + ", " + rs.getString("birthday"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ResourceUtil.close(rs, stmt, connection);
		}
	}

}
