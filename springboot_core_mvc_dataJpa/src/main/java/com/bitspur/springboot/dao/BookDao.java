package com.bitspur.springboot.dao;

import java.util.List;

import com.bitspur.springboot.model.Book;

public interface BookDao {

	Book findById(Long id);

	List<Book> findByName(String name);

	int save(Book book);

	List<Book> findByAuthor(String author);
}
