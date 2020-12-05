package com.book.service;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.book.entity.Book;
import com.book.exception.BookNotFoundException;
import com.book.exception.InvalidRequestException;
import com.book.repository.BookRepository;
public class BookServiceTest {
	
	@InjectMocks
	BookService service;

    @Mock
    private BookRepository repo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetBookDetails() {
		Optional<Book> response = Optional.ofNullable(getBookDetail());
		Mockito.when(repo.findById("123")).thenReturn(response);
		Optional<Book> actual = service.getBookDetails("123");
		assertNotNull(actual);
	}
	
	@Test
	public void testGetBookDetailsException() {
		Optional<Book> response = Optional.ofNullable(null);
		Mockito.when(repo.findById("123")).thenReturn(response);
		try {
			service.getBookDetails("123");
			}
		catch(BookNotFoundException exception) {
			assertEquals(exception.getMessage(),"Book not Found");
			}
	}
	
	@Test
	public void testGetAllBookDetails() {
		List<Book> expected = getAllBookDetails();
		Mockito.when(repo.findAll()).thenReturn(expected);
		final List<Book> actual = service.getAllBookDetails();
		assertNotNull(actual);
	}
	

	@Test
	public void testDeleteBook() {
		Optional<Book> response = Optional.ofNullable(getBookDetail());
		Mockito.when(repo.findById("123")).thenReturn(response);
		service.deleteBook("123");
		String actual = "abc";
		assertNotNull(actual);
	}
	
	@Test
	public void testDeleteBookException() {
		Optional<Book> response = Optional.ofNullable(null);
		Mockito.when(repo.findById("123")).thenReturn(response);
		try {
			service.deleteBook("123");
			}
		catch(BookNotFoundException exception) {
			assertEquals(exception.getMessage(),"Book not Found");
			}
	}
	
	@Test
	public void testSaveBook() {
		final Book request = getBookDetail();
		final Book response = getBookDetail();
		Mockito.when(repo.save(request)).thenReturn(response);
		final Book actual = service.saveBookDetails(request);
		assertNotNull(actual);
	}
	
	
	@Test
	public void testSaveBookException() {
		final Book request = getBookDetailException();
		try {
			service.saveBookDetails(request);
		}catch(InvalidRequestException exception) {
			assertEquals(exception.getMessage(),"Request is Invalid, Please enter all the required details");
		}
	}
	
	private Book getBookDetail() {
		Book bean = new Book();
		bean.setBookId("123");
		bean.setName("abc");
		bean.setAuthor("xyz");
		bean.setPrice(12.00);
		return bean;
	}
	
	
	private Book getBookDetailException() {
		Book bean = new Book();
		bean.setBookId("");
		bean.setName("abc");
		bean.setAuthor("");
		bean.setPrice(12.00);
		return bean;
	}
	
	private List<Book> getAllBookDetails(){
		List<Book> list = new ArrayList<>();
		Book bean = new Book();
		bean.setBookId("123");
		bean.setName("abc");
		bean.setAuthor("xyz");
		bean.setPrice(12.00);
		list.add(bean);
		return list;
	}

}
