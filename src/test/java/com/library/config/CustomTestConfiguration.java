package com.library.config;

import com.library.model.BookRepository;
import com.library.service.BookConverter;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@org.springframework.boot.test.context.TestConfiguration
public class CustomTestConfiguration {

    @Autowired
    private BookRepository bookRepository;

    @Bean
    public BookConverter bookConverter() {
     return new BookConverter();
    }

    @Bean
    public BookService bookService() {
        return new BookService(bookRepository, bookConverter());
    }
}
