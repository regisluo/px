package com.bitspur.jb.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bitspur.jb.io.ResourceUtil;

public class BatchDemo {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try {
			conn = DBUtil.getConnect();
			stmt = conn.createStatement();
			rs = DBUtil.findAll(conn, stmt, "branch");
			while (rs.next()) {
				System.out.println("id:" + rs.getString("id") + ", name:" + rs.getString("name"));
			}

			stmt.addBatch("insert into branch(id,name,bankid) values ('3','branch3','1')");
			stmt.addBatch("insert into branch(id,name,bankid) values ('4','branch4','1')");
			stmt.executeBatch();

			System.out.println("after batch processing...");
			rs2 = DBUtil.findAll(conn, stmt, "branch");
			while (rs2.next()) {
				System.out.println("id:" + rs2.getString("id") + ", name:" + rs2.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ResourceUtil.close(rs, rs2, stmt, conn);
		}

	}
}
