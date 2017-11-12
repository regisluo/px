package com.bitspur.springboot.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.bitspur.springboot.model.Book;

@Component
public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int arg1) throws SQLException {
		Book book = new Book();
		book.setAuthor(rs.getString("author"));
		book.setId(rs.getLong("id"));
		book.setName(rs.getString("name"));
		book.setPrice(rs.getBigDecimal("price"));
		return book;
	}

}
