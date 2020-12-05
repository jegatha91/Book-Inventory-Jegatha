package com.book.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.exception.BookNotFoundException;
import com.book.exception.InvalidRequestException;
import com.book.repository.BookRepository;
@Service
public class BookService {

	
	@Autowired
    private BookRepository repo;
    
    /**
     * Logger Reference
     */
    private static final Logger Log = LoggerFactory.getLogger("BookService.class");
    
    /**
     * Method to Book Detail based on id
     * @param bookId
     * @return Optional<Book>
     */
    public Optional<Book> getBookDetails(String bookId){
    	Optional<Book> response = null;
    	response = repo.findById(bookId);
    	if(response.isPresent()) {
    		Log.info("Book Found");
    		return response;
    	}else
    	{
    		Log.error("Book Details not Found");
    		throw new BookNotFoundException("Book not Found");
    	}
    }
    
    /**
     * Method to get all Book Details
     * @param bookId
     * @return List<Book>
     */
    public List<Book> getAllBookDetails(){
    	return repo.findAll();
    }
    
    
    /**
     * Method to save or update Book Details
     * @param Book
     * @return Book
     */
    public Book saveBookDetails(Book book){
    	if(!(book.getBookId().contentEquals("")||book.getName().contentEquals("")||book.getAuthor().contentEquals(""))) {
    		Log.info("Saving Book Details");
    	return repo.save(book);
    	}
    	else
    	{
    		Log.error("The save request is not valid");
    		throw new InvalidRequestException("Request is Invalid, Please enter all the required details");
    	}
    }
    
    /**
     * Method to delete a book based on bookId
     * @param bookId
     * @return String
     */
    public String deleteBook(String bookId){
    	String finalResponse = "Book Removed from Database";
    	Optional<Book> response = null;
    	response = repo.findById(bookId);
    	if(response.isPresent()) {
    		Log.info("Book Found. Delete Initiated");
    		repo.deleteById(bookId);
    		return finalResponse;
    	}
    	else
    	{
    		Log.error("Book Details not Found");
    		throw new BookNotFoundException("Book not Found");
    	}
    	
    }
}
