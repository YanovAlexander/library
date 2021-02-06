package com.library.model;

import com.library.model.entity.Publication;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDataStorage implements DataStorage {
    List<Publication> publications;
    private final static int DEFAULT_SIZE = 16;


    public InMemoryDataStorage() {
        this(DEFAULT_SIZE);
    }

    public InMemoryDataStorage(int size) {
        this.publications = new ArrayList<>(size);
    }

    @Override
    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    @Override
    public void remove(Publication publication) {
        publications.remove(publication);
    }

    @Override
    public List<Publication> findAll() {
        return publications;
    }
}
