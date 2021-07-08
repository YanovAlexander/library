package com.library.model.mapper;

import com.library.dto.Gender;
import com.library.model.entity.AuthorDAO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDAOMapper implements RowMapper<AuthorDAO> {
    @Override
    public AuthorDAO mapRow(ResultSet rs, int rowNum) throws SQLException {
        AuthorDAO author = new AuthorDAO();
        author.setId(rs.getInt("authorId"));
        author.setFirstName(rs.getString("authorFirstName"));
        author.setLastName(rs.getString("authorLastName"));
        author.setGender(Gender.valueOf(rs.getString("authorGender")));
        author.setBirthDate(rs.getDate("authorBDay").toLocalDate());
        return author;
    }
}
