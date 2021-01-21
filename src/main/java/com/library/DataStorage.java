package com.library;

import java.util.Arrays;

public class DataStorage {
    private Publication[] publications;
    private final static int DEFAULT_SIZE = 16;
    private int size;
    private int cursor = 0;

    public DataStorage() {
        this(DEFAULT_SIZE);
    }

    public DataStorage(int size) {
        this.size = size;
        this.publications = new Publication[this.size];
    }

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

    public void remove(Publication publication){
        for (int i = 0; i < publications.length; i++) {
            if(publications[i] != null) {
                if (publications[i].equals(publication)) {
                    publications[i] = null;
                }
            }

        }
    }

    public Publication[] findAll(){
        return publications;
    }
}
