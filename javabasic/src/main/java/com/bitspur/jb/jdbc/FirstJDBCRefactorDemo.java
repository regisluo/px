package com.bitspur.jb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bitspur.jb.io.ResourceUtil;

public class FirstJDBCRefactorDemo {
	private static final String TABLE_CUSTOMER = "CUSTOMER";

	public static void main(String[] args) {
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//step 1: register the driver
			String driver = "org.apache.derby.jdbc.EmbeddedDriver";
			Class.forName(driver);

			//step 2: get connect object
			String url = "jdbc:derby:src/main/resources/MyDB/test;create=true";
			connection = DriverManager.getConnection(url);

			//step 3: Create Statement
			st = connection.createStatement();

			//step 4: executing query
			if (!DBUtil.tableExist(TABLE_CUSTOMER)) {
				String customerTable = "create table customer(id varchar (11) NOT NULL, name varchar (50), birthday varchar(11))";
				st.executeUpdate(customerTable);
			}
			String insert1 = "insert into customer values('" + RandomId.getKey() + "','Jim','1990-11-02')";
			String insert2 = "insert into customer values('" + RandomId.getKey() + "','Tim','1992-09-01')";
			st.executeUpdate(insert1);
			st.executeUpdate(insert2);

			String s = "update customer set name=? where id=?";
			PreparedStatement pst = connection.prepareStatement(s);
			pst.setString(1, "haha");
			pst.setString(2, "1");
			pst.executeUpdate();

			//step 5: Process resultset
			rs = st.executeQuery("SELECT * FROM customer");
			while (rs.next()) {
				System.out.println("id: " + rs.getString("id") + ", name: " + rs.getString("name") + "," + " birthday: "
						+ rs.getString("birthday"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ResourceUtil.close(rs, st, connection);
		}
	}
}
