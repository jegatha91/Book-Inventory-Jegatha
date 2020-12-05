package com.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

import com.book.entity.Book;
import com.book.repository.BookRepository;

@SpringBootApplication
@ComponentScan({"com.book"})
public class BookApplication {

    // start everything
    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

    @Profile("demo")
    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            repository.save(new Book("123","The Secrets of Nagas", "Amit", new Double("20.00")));
            repository.save(new Book("456","Half Girlfriend","Chetan Baghat", new Double("9.99")));
            repository.save(new Book("789","Men are from Mars, Women are from Venus", "John Gray", new Double("19.99")));
        };
    }
}