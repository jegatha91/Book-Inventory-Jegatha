package com.book.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.Book;
import com.book.service.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService service;
    
    /**
     * Logger Reference
     */
    private static final Logger Log = LoggerFactory.getLogger("BookController.class");
    
    /**
     * Method to get the book based on bookId
     */
    @GetMapping(path="/books/retrieve/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<Book> getBookDetails(@PathVariable String bookId){
    	Log.info("Inside Book Controller to Get the Book Detail");
    	return service.getBookDetails(bookId);
    	
    }
    
    /**
     * Method to get the all the books
     */
    @GetMapping(path="/books/retrieve/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Book> getAllBookDetails(){
    	Log.info("Inside Book Controller to Get the All Books Details");
    	return service.getAllBookDetails();
    	
    }
    
    /**
     * Method to save the book
     */
    @PostMapping(path="/books/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Book saveBookDetails(@RequestBody Book book){
    	Log.info("Inside Book Controller to save the Book Detail");
    	return service.saveBookDetails(book);
    	
    }
    
    /**
     * Method to Delete the book detail
     */
    @DeleteMapping(path="/books/delete/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteBook(@PathVariable String bookId){
    	Log.info("Inside Book Controller to delete book");
    	return service.deleteBook(bookId);
    	
    }
}
