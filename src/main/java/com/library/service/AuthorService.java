package com.library.service;

import com.library.dto.AuthorDTO;
import com.library.model.Repository;
import com.library.model.entity.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final Repository<AuthorDAO> repository;
    private final AuthorConverter authorConverter;

    @Autowired
    public AuthorService(Repository<AuthorDAO> repository, AuthorConverter authorConverter) {
        this.repository = repository;
        this.authorConverter = authorConverter;
    }


    public List<AuthorDTO> findAuthors() {
        return authorConverter.toAuthorDTOList(repository.findAll());
    }

    public AuthorDTO getAuthor(int id) {
        return authorConverter.toAuthorDTO(repository.findById(id));
    }
}
