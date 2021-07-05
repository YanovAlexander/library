package com.library.service;

import com.library.dto.AuthorDTO;
import com.library.model.entity.AuthorDAO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorConverter {

    public List<AuthorDTO> toAuthorDTOList(List<AuthorDAO> authors) {
        return authors.stream()
                .map(this::toAuthorDTO)
                .collect(Collectors.toList());
    }

    public AuthorDTO toAuthorDTO(AuthorDAO authorDAO) {
        return new AuthorDTO(authorDAO.getId(), authorDAO.getFirstName(),
                authorDAO.getLastName(), authorDAO.getGender(),
                authorDAO.getBirthDate());
    }


}
