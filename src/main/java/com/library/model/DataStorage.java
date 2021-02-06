package com.library.model;

import com.library.model.entity.Publication;

public interface DataStorage {
    void addPublication(Publication publication);
    void remove(Publication publication);
    Publication[] findAll();

}
