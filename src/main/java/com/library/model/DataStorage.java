package com.library.model;

import com.library.model.entity.Publication;

import java.util.List;

public interface DataStorage<T extends Publication> {
    void addPublication(T publication);
    void remove(T publication);
    List<T> findAll();

}
