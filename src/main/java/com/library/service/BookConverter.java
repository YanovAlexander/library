package com.library.service;

import com.library.dto.BookDTO;
import com.library.dto.Genre;
import com.library.model.entity.BookDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookConverter {
    public static BookDAO toBookDAO(BookDTO bookDTO){
        return new BookDAO(bookDTO.getId(), bookDTO.getAuthor(), bookDTO.getName(), bookDTO.getCountPages(),
                bookDTO.getPublicationYear(), bookDTO.getDescription(), bookDTO.getGenre());
    }

    public static BookDTO fromBookDAO(BookDAO bookDAO){
        return new BookDTO(bookDAO.getId(), bookDAO.getAuthor(), bookDAO.getName(), bookDAO.getCountPages(),
                bookDAO.getPublicationYear(), bookDAO.getDescription(), bookDAO.getGenre());
    }

    public static BookDAO toBookDAO(ResultSet resultSet) throws SQLException {
        BookDAO bookDAO = new BookDAO();
        while (resultSet.next()){
            bookDAO.setId(resultSet.getLong("id"));
            bookDAO.setName(resultSet.getString("name"));
            bookDAO.setAuthor(resultSet.getString("author"));
            bookDAO.setCountPages(resultSet.getInt("count_pages"));
            bookDAO.setPublicationYear(resultSet.getInt("publication_year"));
            bookDAO.setDescription(resultSet.getString("description"));
            bookDAO.setGenre(Genre.valueOf(resultSet.getString("genre")));
        }
        return bookDAO;
    }
}
