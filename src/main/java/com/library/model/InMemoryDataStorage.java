package com.library.model;

import com.library.exceptions.DataStorageException;
import com.library.model.entity.Publication;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        if (Objects.isNull(publication)) {
            throw new DataStorageException("Publication can't be null");
        }

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
