package com.bitspur.jb.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.bitspur.jb.io.ResourceUtil;

public class MetadataDemo {
	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			rs = DBUtil.findAll(connection, stmt, "branch");
			ResultSetMetaData rMeta = rs.getMetaData();
			for (int i = 1; i <= rMeta.getColumnCount(); i++) {
				System.out.println(rMeta.getColumnName(i) + ": " + rMeta.getColumnTypeName(i));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceUtil.close(rs, stmt, connection);
		}

	}
}
