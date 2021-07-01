package com.library.service;

import com.library.dto.AuthorDTO;
import com.library.dto.BookDTO;
import com.library.model.entity.AuthorDAO;
import com.library.model.entity.BookDAO;

public class BookConverter {
    public static BookDAO toBookDAO(BookDTO bookDTO) {
        return new BookDAO(bookDTO.getId(), fromAuthorDTO(bookDTO.getAuthor()), bookDTO.getName(), bookDTO.getCountPages(),
                bookDTO.getPublicationYear(), bookDTO.getDescription(), bookDTO.getGenre());
    }

    public static BookDTO fromBookDAO(BookDAO bookDAO) {
        return new BookDTO(bookDAO.getId(), fromAuthorDAO(bookDAO.getAuthor()), bookDAO.getName(), bookDAO.getCountPages(),
                bookDAO.getPublicationYear(), bookDAO.getDescription(), bookDAO.getGenre());
    }

    private static AuthorDTO fromAuthorDAO(AuthorDAO author) {
        return new AuthorDTO(author.getId(), author.getFirstName(),
                author.getLastName(), author.getGender(), author.getBirthDate());
    }

    private static AuthorDAO fromAuthorDTO(AuthorDTO author) {
        return new AuthorDAO(author.getId(), author.getFirstName(),
                author.getLastName(), author.getGender(), author.getBirthDate());
    }
}
