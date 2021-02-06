package com.library.model;

import com.library.model.entity.Publication;

import java.util.List;

public interface DataStorage {
    void addPublication(Publication publication);
    void remove(Publication publication);
    List<Publication> findAll();

}
