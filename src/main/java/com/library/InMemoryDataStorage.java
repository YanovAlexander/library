package com.library;

import java.util.Arrays;

public class InMemoryDataStorage implements DataStorage {
    private Publication[] publications;
    private final static int DEFAULT_SIZE = 16;
    private int size;
    private int cursor = 0;

    public InMemoryDataStorage() {
        this(DEFAULT_SIZE);
    }

    public InMemoryDataStorage(int size) {
        this.size = size;
        this.publications = new Publication[this.size];
    }

    @Override
    public void addPublication(Publication publication) {
        if (cursor >= size) {
            increaseDataStorage();
        }
        publications[cursor] = publication;
        cursor++;
    }

    private void increaseDataStorage() {
        size = size * 2;
        publications = Arrays.copyOf(this.publications, size);
    }

    @Override
    public void remove(Publication publication) {
        for (int i = 0; i < publications.length; i++) {
            if (publications[i] != null) {
                if (publications[i].equals(publication)) {
                    publications[i] = null;
                }
            }

        }
    }

    @Override
    public Publication[] findAll() {
        return publications;
    }
}
