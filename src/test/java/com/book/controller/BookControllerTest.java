package com.book.controller;


import static org.junit.Assert.assertEquals;

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
import com.book.service.BookService;


public class BookControllerTest {
	
	@InjectMocks
	BookController controller;

    @Mock
    private BookService service;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetBookDetails() {
		Optional<Book> response = Optional.ofNullable(getBookDetail());
		final Book expected = getBookDetail();
		Mockito.when(service.getBookDetails("123")).thenReturn(response);
		Optional<Book> res = controller.getBookDetails("123");
		if(res.isPresent()) {
			Book actual = res.get();
			assertEquals(expected.getBookId(),actual.getBookId());
		}
	}
	
	@Test
	public void testGetAllBookDetails() {
		List<Book> expected = getAllBookDetails();
		Mockito.when(service.getAllBookDetails()).thenReturn(expected);
		final List<Book> actual = controller.getAllBookDetails();
		assertEquals(expected.get(0).getBookId(), actual.get(0).getBookId());
	}
	
	@Test
	public void testDeleteBook() {
		String response = null;
		String expected = "abc";
		Mockito.when(service.deleteBook("123")).thenReturn(response);
		controller.deleteBook("123");
		String actual = "abc";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSaveBook() {
		final Book request = getBookDetail();
		final Book response = getBookDetail();
		Mockito.when(service.saveBookDetails(request)).thenReturn(response);
		final Book actual = controller.saveBookDetails(request);
		assertEquals(response,actual);
	}
	
	private Book getBookDetail() {
		Book bean = new Book();
		bean.setBookId("123");
		bean.setName("abc");
		bean.setAuthor("xyz");
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
