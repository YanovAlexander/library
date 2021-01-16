package com.library;

public class DataStorage {
    private Publication[] publications;
    private int size;
    private final static int DEFAULT_SIZE = 16;

    public DataStorage(int size) {
        this.size = size;
        this.publications = new Publication[size];
    }

    public DataStorage() {
        this(DEFAULT_SIZE);
    }
}
