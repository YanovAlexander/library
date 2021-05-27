package com.library.service;

import com.library.dto.BookDTO;
import com.library.model.Repository;
import com.library.model.entity.BookDAO;

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

}
