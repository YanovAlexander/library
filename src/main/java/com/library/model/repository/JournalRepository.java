package com.library.model.repository;

import com.library.model.entity.JournalDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<JournalDAO, Integer> {

}
