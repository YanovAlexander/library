package com.library.config;

import com.library.model.repository.BookRepository;
import com.library.model.repository.UserRepository;
import com.library.service.BookConverter;
import com.library.service.BookService;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@org.springframework.boot.test.context.TestConfiguration
public class CustomTestConfiguration {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Bean
    public BookConverter bookConverter() {
     return new BookConverter();
    }

    @Bean
    public BookService bookService() {
        return new BookService(bookRepository, bookConverter());
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository, bCryptPasswordEncoder());
    }

    @Bean(name = "passwordEncoder")
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
