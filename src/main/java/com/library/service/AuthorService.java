package com.library.service;

import com.library.dto.AuthorDTO;
import com.library.model.Repository;
import com.library.model.entity.AuthorDAO;

import java.util.List;

public class AuthorService {

    private final Repository<AuthorDAO> repository;

    public AuthorService(Repository<AuthorDAO> repository) {
        this.repository = repository;
    }


    public List<AuthorDTO> findAuthors() {
        return AuthorConverter.toAuthorDTOList(repository.findAll());
    }

    public AuthorDTO getAuthor(int id) {
        return AuthorConverter.toAuthorDTO(repository.findById(id));
    }
}
