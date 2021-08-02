package com.library.service;

import com.library.dto.AuthorDTO;
import com.library.dto.BookDTO;
import com.library.model.repository.BookRepository;
import com.library.model.entity.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository repository;
    private final BookConverter bookConverter;

    @Autowired
    public BookService(BookRepository repository, BookConverter bookConverter) {
        this.repository = repository;
        this.bookConverter = bookConverter;
    }

    public BookDTO addBook(BookDTO bookDTO, AuthorDTO author) {
        BookDAO bookDAO = bookConverter.toBookDAO(bookDTO, author);
        BookDAO savedBook = repository.save(bookDAO);
        return bookConverter.fromBookDAO(savedBook);
    }

    public List<BookDTO> findAll() {
        final List<BookDAO> books = repository.findAll();
        return books.stream()
                .map(bookConverter::fromBookDAO)
                .collect(Collectors.toList());
    }

    public BookDTO findById(int id) {
        return repository.findById(id).map(bookConverter::fromBookDAO)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public void update(BookDTO bookDTO, AuthorDTO author) {
        repository.save(bookConverter.toBookDAO(bookDTO, author));
    }
}
