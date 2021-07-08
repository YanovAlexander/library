package com.library.model.mapper;

import com.library.dto.Genre;
import com.library.model.entity.AuthorDAO;
import com.library.model.entity.BookDAO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAOMapper implements RowMapper<BookDAO> {
    @Override
    public BookDAO mapRow(ResultSet rs, int rowNum) throws SQLException {
        AuthorDAOMapper mapper = new AuthorDAOMapper();
        BookDAO book = new BookDAO();
        book.setId(rs.getInt("bookId"));
        book.setName(rs.getString("bookName"));
        book.setCountPages(rs.getInt("bookPages"));
        book.setPublicationYear(rs.getInt("bookPublicationYear"));
        book.setDescription(rs.getString("bookDescription"));
        book.setGenre(Genre.valueOf(rs.getString("bookGenre")));
        AuthorDAO author = mapper.mapRow(rs, rowNum);
        book.setAuthor(author);
        return book;
    }
}
