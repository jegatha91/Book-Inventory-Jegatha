package com.book.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;


@Entity
public class Book {

    @Id
    private String bookId;

    private String name;

    private String author;
    
    @DecimalMin(value="1.00",inclusive = true)
    @NotNull
    private Double price;

    public Book() {
    }

	/**
	 * @param bookId
	 * @param name
	 * @param author
	 * @param price
	 */
	public Book(String bookId, String name, String author, Double price) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	/**
	 * @return the bookId
	 */
	public String getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", author=" + author + ", price=" + price + "]";
	}

    
}
