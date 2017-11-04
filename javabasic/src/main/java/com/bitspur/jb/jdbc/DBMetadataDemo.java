package com.bitspur.jb.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bitspur.jb.io.ResourceUtil;

public class DBMetadataDemo {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = DBUtil.getConnect();
			DatabaseMetaData dbMetaData = connection.getMetaData();
			System.out.println(
					dbMetaData.getDatabaseProductName() + ", " + "version: " + dbMetaData.getDatabaseProductVersion());
			rs = dbMetaData.getTables(null, null, null, new String[] { "TABLE" });
			while (rs.next()) {
				//TABLE_SCHEM, TABLE_TYPE and TABLE_NAME
				System.out.println(rs.getString("TABLE_SCHEM"));
				System.out.println(rs.getString("TABLE_TYPE"));
				System.out.println(rs.getString("TABLE_NAME"));
				System.out.println("---------------");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			ResourceUtil.close(rs, connection);
		}
	}

}
