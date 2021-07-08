package com.library.service;

import com.library.dto.AuthorDTO;
import com.library.model.AuthorRepository;
import com.library.model.entity.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository repository;
    private final AuthorConverter authorConverter;

    @Autowired
    public AuthorService(AuthorRepository repository, AuthorConverter authorConverter) {
        this.repository = repository;
        this.authorConverter = authorConverter;
    }


    public List<AuthorDTO> findAuthors() {
        return authorConverter.toAuthorDTOList(repository.findAll());
    }

    public AuthorDTO getAuthor(int id) {
        Optional<AuthorDAO> author = repository.findById(id);
        return author.map(authorConverter::toAuthorDTO)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }
}
