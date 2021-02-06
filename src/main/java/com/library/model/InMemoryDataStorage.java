package com.library.model;

import com.library.model.entity.Publication;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDataStorage<T extends Publication> implements DataStorage<T> {
    private List<T> publications;
    private final static int DEFAULT_CAPACITY = 16;

    public InMemoryDataStorage() {
        this(DEFAULT_CAPACITY);
    }

    public InMemoryDataStorage(int capacity) {
        this.publications = new ArrayList<>(capacity);
    }

    @Override
    public void addPublication(T publication) {
        this.publications.add(publication);
    }

    @Override
    public void remove(T publication) {
        this.publications.remove(publication);
    }

    @Override
    public List <T> findAll() {
        return publications;
    }
}
