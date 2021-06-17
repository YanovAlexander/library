package com.library.service;

import com.library.dto.BookDTO;
import com.library.model.Repository;
import com.library.model.entity.BookDAO;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private final Repository<BookDAO> repository;

    public BookService(Repository<BookDAO> repository) {
        this.repository = repository;
    }

    public BookDTO addBook(BookDTO bookDTO) {
        BookDAO bookDAO = BookConverter.toBookDAO(bookDTO);
        long id = repository.addPublication(bookDAO);
        BookDAO created = repository.findById(id);
        return BookConverter.fromBookDAO(created);
    }


    public List<BookDTO> findAll() {
        final List<BookDAO> books = repository.findAll();
        return books.stream()
                .map(BookConverter::fromBookDAO)
                .collect(Collectors.toList());
    }

    public BookDTO findById(long id) {
        return BookConverter.fromBookDAO(repository.findById(id));
    }

    public void update(BookDTO bookDTO) {
        repository.update(BookConverter.toBookDAO(bookDTO));
    }
}
