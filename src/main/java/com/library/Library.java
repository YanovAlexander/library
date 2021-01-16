package com.library;

import java.util.Objects;

public class Library {
    public static void printPublications(Publication[] publications) {
        if (Objects.isNull(publications) || publications.length == 0) {
            System.out.println("Нет публикаций для печати");
            return;
        }
        for (Publication publication : publications) {
            if (Objects.nonNull(publication)) {
                System.out.println(publication.print());
            }
        }

    }

    public static void main(String[] args) {
        printPublications(null);
        printPublications(new Publication[0]);
        printPublications(new Publication[]{new Journal("PC", 100, 1, 2021)});
        printPublications(new Publication[]{new Book("Witcher", 200, "Andrzej Sapkowski")});
        printPublications(new Publication[]{new Book("Master & Margarita", 300, "Mikhail Bulgakov"),
                new Journal("Gamer", 101, 10, 2018)});
        printPublications(new Publication[]{new Book("Master & Margarita", 300, "Mikhail Bulgakov"), null,
                new Journal("Gamer", 101, 10, 2018)});

        DataStorage dataStorage = new DataStorage(1);
        dataStorage.addPublication(new Book("Witcher", 200, "Andrzej Sapkowski"));
        dataStorage.addPublication(new Book("Witcher", 200, "Andrzej Sapkowski"));
    }
}
