package com.library;

import java.util.Arrays;

public class DataStorage {
    private Publication[] publications;
    private int size;
    private final static int DEFAULT_SIZE = 16;
    private int cursor = 0;

    public DataStorage(int size) {
        this.size = size;
        this.publications = new Publication[size];
    }

    public DataStorage() {
        this(DEFAULT_SIZE);
    }

    public void addPublication(Publication publication) {
        if(cursor >= size){
            increaseDataStorage();
        }

            publications[cursor] = publication;
            cursor++;

    }

    private void increaseDataStorage(){
        publications = Arrays.copyOf(publications, size = size * 2);
    }
}
