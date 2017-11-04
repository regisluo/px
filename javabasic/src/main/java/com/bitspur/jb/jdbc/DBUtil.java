package com.bitspur.jb.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bitspur.jb.io.ResourceUtil;

public class DBUtil {
	private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String url = "jdbc:derby:src/main/resources/MyDB/test;create=true";

	public static Connection getConnect() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName(driver);
		connection = DriverManager.getConnection(url);
		return connection;
	}

	public static ResultSet findAll(Connection con, Statement stmt, String tableName) {
		ResultSet rs = null;
		String sql = "select * from " + tableName;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static ResultSet find(Connection con, Statement stmt, String sql) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static boolean tableExist(String tableName) {
		boolean exist = false;
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = getConnect();
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			rs = databaseMetaData.getTables(null, null, null, new String[] { "TABLE" });
			while (rs.next()) {
				if (rs.getString("TABLE_NAME").equalsIgnoreCase(tableName)) {
					exist = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ResourceUtil.close(rs, connection);
		}
		return exist;
	}
}
