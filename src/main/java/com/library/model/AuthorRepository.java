package com.library.model;

import com.library.model.entity.AuthorDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorDAO, Integer> {
}
