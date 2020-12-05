package com.book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class BookNotFoundException extends RuntimeException {

    
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String exception) {
        super(exception);
    }

}
