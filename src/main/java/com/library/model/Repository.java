package com.library.model;

import java.util.List;

public interface Repository<T> {

    int addPublication(T entity);

    T findById(int id);

    List<T> findAll();

    void update(T entity);
}
