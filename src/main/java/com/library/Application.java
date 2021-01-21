package com.library;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {

        System.out.println("Hello World");

        Publication publication = new Publication("Book", 100);
        Publication publicationToRemove = new Publication("Book", 100);

        DataStorage dataStorage = new DataStorage();
        dataStorage.addPublication(publication);

        dataStorage.remove(publicationToRemove);
        System.out.println(Arrays.toString(dataStorage.findAll()));
    }
}
