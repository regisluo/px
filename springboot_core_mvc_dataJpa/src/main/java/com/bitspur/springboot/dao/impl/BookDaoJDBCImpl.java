package com.bitspur.springboot.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.bitspur.springboot.dao.BookDao;
import com.bitspur.springboot.model.Book;
import com.bitspur.springboot.rowmapper.BookRowMapper;

@Component
public class BookDaoJDBCImpl implements BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private BookRowMapper bookRowMapper;

	@Override
	public Book findById(Long id) {
		String sql = "select * from Book where id = ?";
		return jdbcTemplate.queryForObject(sql, bookRowMapper, id);
	}

	@Override
	public List<Book> findByName(String name) {
		String sql = "select * from Book where name = ?";
		return jdbcTemplate.query(sql, bookRowMapper, name);
	}

	@Override
	public List<Book> findByAuthor(String author) {
		String sql = "select * from Book where author = :author";
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("author", author);
		return namedParameterJdbcTemplate.query(sql, paramMap, bookRowMapper);
	}

	@Override
	public int save(Book book) {
		String sql = "insert into book (name, author, price) values (?,?,?)";
		return jdbcTemplate.update(sql, new Object[] { book.getName(), book.getAuthor(), book.getPrice() });
	}

}
