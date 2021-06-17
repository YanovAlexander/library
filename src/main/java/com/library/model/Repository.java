package com.library.model;

import java.util.List;

public interface Repository<T> {

    long addPublication(T entity);

    T findById(long id);

    List<T> findAll();

    void update(T entity);
}
