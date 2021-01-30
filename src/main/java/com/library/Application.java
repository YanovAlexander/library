package com.library;


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
                System.out.println("Введите exit для выхода из программы.");
                System.out.println("Введите add_book , чтобы добавить книгу в библиотеку");
            } else if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("add_book")) {
                addBookToDataStorage(scanner, dataStorage);
            } else {
                System.out.println("Такой команды нет в списке, пожалуйста, повторите ввод.");
            }
        }
        scanner.close();
    }

    private static void addBookToDataStorage(Scanner scanner, DataStorage dataStorage) {
        System.out.println("Введите название книги:");
        String bookName = scanner.nextLine();
        System.out.println("Ввкдите количество страниц: ");
        int pagesCount = 0;
        try {
            pagesCount = Integer.parseInt(scanner.nextLine());
        } catch (Exception e){
            System.out.println("Введите число страниц: ");
            pagesCount = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Введите имя автора: ");
        String author = scanner.nextLine();
        Book book = new Book(bookName, pagesCount, author);
        dataStorage.addPublication(book);
        System.out.println("Ваша книга добавлена");
    }
}
