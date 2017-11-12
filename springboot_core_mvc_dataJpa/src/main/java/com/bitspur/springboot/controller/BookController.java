// package com.bitspur.springboot.controller;
//
// import java.util.List;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;
//
// import com.bitspur.springboot.demo.HelloWorld;
// import com.bitspur.springboot.model.Book;
// import com.bitspur.springboot.repository.BookRepository;
// import com.bitspur.springboot.service.Calculator;
//
// @RestController
// @RequestMapping("/")
// public class BookController {
//
// @Autowired
// private BookRepository bookRepository;
//
// @Autowired
// private HelloWorld helloWorld;
//
// @Autowired
// private Calculator calculator;
//
// @Autowired
// JdbcTemplate jdbcTemplate;
//
// @RequestMapping(value = "/books", method = RequestMethod.GET)
// public List<Book> getAllBooks() {
// return bookRepository.findAll();
//
// }
//
// @RequestMapping(value = "/jdbcTemplate", method = RequestMethod.GET)
// public String getBookNameFromId() {
// return jdbcTemplate.queryForObject("select name from book where id=1",
// String.class);
// }
//
// @RequestMapping(value = "/books/{bookid}", method = RequestMethod.GET)
// public Book getABook(@PathVariable("bookid") Long id) {
// return bookRepository.findOne(id);
// }
// /// books?author=Tom&name=Python
// // @RequestMapping(method=RequestMethod.GET,value="/books")
// // public List<Book> getBookByNameAndAuthor(@RequestParam("author") String
// // author,
// // @RequestParam("name") String name){
// // return null;
// // }
//
// @RequestMapping(method = RequestMethod.PUT, value = "/books/{id}")
// public String updateBook(@RequestBody Book book, @PathVariable("id") Long id)
// {
// book.setId(id);
// bookRepository.save(book);
// return "success";
// }
//
// @RequestMapping(method = RequestMethod.POST, value = "/books")
// public String addBook(@RequestBody Book book) {
// bookRepository.save(book);
// return "success";
// }
//
// @RequestMapping(method = RequestMethod.DELETE, value = "/books/{id}")
// public String deleteBook(@PathVariable("id") Long id) {
// bookRepository.delete(id);
// return "success";
// }
//
// /*
// * @RequestMapping(value="/helloworld",method = RequestMethod.GET) public
// * String helloworld() { helloWorld.setName("haha"); return
// * helloWorld.sayHello(); }
// *
// * @RequestMapping(value="/hello",method = RequestMethod.GET) public String
// * home() { Book book1 = new Book("Java Programming", "John Lee", new
// * BigDecimal(50.50)); Book book2 = bookRepository.save(book1); Book book3 =
// * bookRepository.findOne(book2.getId()); return book3.toString(); }
// *
// * @RequestMapping(value="/book1",method = RequestMethod.POST) public String
// * exercise1(@RequestBody Book book) { System.out.println(book);
// * bookRepository.save(book); return "success"; }
// *
// * @RequestMapping(value="/author",method = RequestMethod.GET) public String
// * findbyAuthor() { List<Book> book = bookRepository.findByAuthor("John Lee"
// * ); System.out.println(book.size()); return "success"; }
// */
//
// }
