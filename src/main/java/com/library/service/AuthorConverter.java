package com.library.service;

import com.library.dto.AuthorDTO;
import com.library.model.entity.AuthorDAO;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorConverter {

    public static List<AuthorDTO> toAuthorDTOList(List<AuthorDAO> authors) {
        return authors.stream()
                .map(AuthorConverter::toAuthorDTO)
                .collect(Collectors.toList());
    }

    public static AuthorDTO toAuthorDTO(AuthorDAO authorDAO) {
        return new AuthorDTO(authorDAO.getId(), authorDAO.getFirstName(),
                authorDAO.getLastName(), authorDAO.getGender(),
                authorDAO.getBirthDate());
    }


}
