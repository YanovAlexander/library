package com.library.service;

import com.library.dto.BookDTO;
import com.library.model.Repository;
import com.library.model.entity.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final Repository<BookDAO> repository;
    private final BookConverter bookConverter;

    @Autowired
    public BookService(Repository<BookDAO> repository, BookConverter bookConverter) {
        this.repository = repository;
        this.bookConverter = bookConverter;
    }

    public BookDTO addBook(BookDTO bookDTO) {
        BookDAO bookDAO = bookConverter.toBookDAO(bookDTO);
        int id = repository.save(bookDAO);
        BookDAO created = repository.findById(id);
        return bookConverter.fromBookDAO(created);
    }

    public List<BookDTO> findAll() {
        final List<BookDAO> books = repository.findAll();
        return books.stream()
                .map(bookConverter::fromBookDAO)
                .collect(Collectors.toList());
    }

    public BookDTO findById(int id) {
        return bookConverter.fromBookDAO(repository.findById(id));
    }

    public void update(BookDTO bookDTO) {
        repository.update(bookConverter.toBookDAO(bookDTO));
    }
}
