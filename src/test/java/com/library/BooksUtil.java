package com.library;

import com.library.dto.AuthorDTO;
import com.library.dto.BookDTO;
import com.library.dto.enums.Gender;
import com.library.dto.enums.Genre;
import com.library.model.entity.AuthorDAO;
import com.library.model.entity.BookDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BooksUtil {

    public final static String BOOK_NAME = "Master & Margarita";

    public static List<BookDAO> prepareBooks(AuthorDAO authorDAO) {
        List<BookDAO> books = new ArrayList<>();
        books.add(new BookDAO(1, authorDAO,
                "Master & Margarita", 100, 1890, "", Genre.FANTASY));
        return books;
    }

    public static AuthorDAO getAuthor() {
        return new AuthorDAO(1, "Mikhail", "Bulgakov", Gender.MALE, LocalDate.now(), Collections.emptySet());
    }

    public static BookDTO getBookDTO(int authorId) {
        return new BookDTO(1, authorId,
                "Master & Margarita", 100, 1890, "", Genre.FANTASY);
    }

    public static BookDAO getBookDAO(AuthorDAO authorDAO) {
        return new BookDAO(1, authorDAO,
                "Master & Margarita", 100, 1890, "", Genre.FANTASY);
    }

    public static AuthorDTO getAuthorDTO() {
        return new AuthorDTO(1, "Mikhail", "Bulgakov", Gender.MALE, LocalDate.now(), Collections.emptySet());
    }
}
