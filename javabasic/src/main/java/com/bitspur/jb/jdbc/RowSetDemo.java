package com.bitspur.jb.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetDemo {
	public static void main(String[] args) throws Exception {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

		//Creating and Executing RowSet  
		JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
		String url = "jdbc:derby:src/main/resources/MyDB/test;create=true";
		rowSet.setUrl(url);

		rowSet.setCommand("select * from customer");
		rowSet.execute();

		while (rowSet.next()) {
			System.out.println("Id: " + rowSet.getString(1));
			System.out.println("Name: " + rowSet.getString(2));
			System.out.println("Birthday: " + rowSet.getString(3));
		}

	}
}
