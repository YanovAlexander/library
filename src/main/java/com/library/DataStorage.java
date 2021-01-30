package com.library;

public interface DataStorage {
    void addPublication(Publication publication);
    void remove(Publication publication);
    Publication[] findAll();

}
