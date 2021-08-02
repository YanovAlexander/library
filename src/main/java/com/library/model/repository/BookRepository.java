package com.library.model.repository;

import com.library.model.entity.BookDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository  extends JpaRepository<BookDAO, Integer> {

    @Query("select b from BookDAO b where b.name=?1")
    List<BookDAO> getByName(String name);
}
