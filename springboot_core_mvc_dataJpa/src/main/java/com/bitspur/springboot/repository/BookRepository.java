package com.bitspur.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.bitspur.springboot.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
	List<Book> findByAuthor(@Param("author") String author);

	

}
