package com.library.model;

public interface Repository<T> {

    long addPublication(T entity);

    T findById(long id);
}
