package com.bitspur.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bitspur.springboot.dao.BookDao;
import com.bitspur.springboot.model.Book;

@RestController
@RequestMapping("/books")
public class BookController2 {

	@Autowired
	private BookDao bookDao;

	@RequestMapping(value = "/id/{bookId}", method = RequestMethod.GET)
	public Book getBookFromId(@PathVariable("bookId") Long id) {
		return bookDao.findById(id);
	}

	@RequestMapping(value = "/name/{bookName}", method = RequestMethod.GET)
	public List<Book> getBooksFromName(@PathVariable("bookName") String bookName) {
		return bookDao.findByName(bookName);
	}

	@RequestMapping(value = "/author/{author}", method = RequestMethod.GET)
	public List<Book> getBookByAuthor(@PathVariable("author") String author) {
		return bookDao.findByAuthor(author);
	}

	@RequestMapping(method = RequestMethod.POST)
	public int save(@RequestBody Book book) {
		return bookDao.save(book);
	}

}
