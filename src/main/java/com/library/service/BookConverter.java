package com.library.service;

import com.library.dto.AuthorDTO;
import com.library.dto.BookDTO;
import com.library.model.entity.AuthorDAO;
import com.library.model.entity.BookDAO;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {
    public BookDAO toBookDAO(BookDTO bookDTO, AuthorDTO author) {
        return new BookDAO(bookDTO.getId(), fromAuthorDTO(author), bookDTO.getName(), bookDTO.getCountPages(),
                bookDTO.getPublicationYear(), bookDTO.getDescription(), bookDTO.getGenre());
    }

    public BookDTO fromBookDAO(BookDAO bookDAO) {
        return new BookDTO(bookDAO.getId(), fromAuthorDAO(bookDAO.getAuthor()).getId(), bookDAO.getName(), bookDAO.getCountPages(),
                bookDAO.getPublicationYear(), bookDAO.getDescription(), bookDAO.getGenre());
    }

    private AuthorDTO fromAuthorDAO(AuthorDAO author) {
        return new AuthorDTO(author.getId(), author.getFirstName(),
                author.getLastName(), author.getGender(), author.getBirthDate());
    }

    private AuthorDAO fromAuthorDTO(AuthorDTO author) {
        return new AuthorDAO(author.getId(), author.getFirstName(),
                author.getLastName(), author.getGender(), author.getBirthDate());
    }
}
