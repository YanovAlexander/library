package com.library.model;

import com.library.model.entity.Publication;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDataStorage implements DataStorage {
    private List<Publication> publications;
    private final static int DEFAULT_CAPACITY = 16;

    public InMemoryDataStorage() {
        this(DEFAULT_CAPACITY);
    }

    public InMemoryDataStorage(int capacity) {
        this.publications = new ArrayList<>(capacity);
    }

    @Override
    public void addPublication(Publication publication) {
        this.publications.add(publication);
    }

    @Override
    public void remove(Publication publication) {
        this.publications.remove(publication);
    }

    @Override
    public List<Publication> findAll() {
        return publications;
    }
}
