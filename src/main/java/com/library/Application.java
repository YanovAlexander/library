package com.library;

import java.util.Arrays;
import java.util.Scanner;

public class Application {


    public static void main(String[] args) {

        DataStorage dataStorage = new DataStorage();

        System.out.println("Добро пожаловать в библиотеку.  Введите команду help  для получения списка доступных команд.");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("help")) {
                System.out.println("Введите  help, чтобы увидеть список всех доступных команд.");
                System.out.println("Введите команду add help, чтобы добавить новую книгу в хранилище");
                System.out.println("Введите exit для выхода из программы.");
            } else if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("add book")) {
                addBookToDataStorage(scanner, dataStorage);
            } else {
                System.out.println("Такой команды нет в списке, пожалуйста, повторите ввод.");
            }
        }
        scanner.close();
    }

    private static void addBookToDataStorage(Scanner scanner, DataStorage dataStorage) {
        System.out.println("Введите название книги");
        String bookName = scanner.nextLine();
        System.out.println("Введите автора книги");
        String author = scanner.nextLine();
        int pagesCount = 0;
        while (true) {
            try {
                System.out.println("Введите количество страниц");
                pagesCount = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
               System.out.println("Вы ввели не целое число страниц, введите верное количество страниц.");
                continue;
            }
        }
        dataStorage.addPublication(new Book(bookName, pagesCount, author));
        System.out.println("Книга успешно добавлена");

    }
}
