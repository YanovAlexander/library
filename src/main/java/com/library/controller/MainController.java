package com.library.controller;

import com.library.command.Command;
import com.library.command.Help;
import com.library.model.DataStorage;
import com.library.model.InMemoryDataStorage;
import com.library.model.entity.Book;
import com.library.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private View view;
    private List<Command> commands;

    public MainController(DataStorage storage, View view) {
        this.view = view;
        this.commands = new ArrayList<>(Arrays.asList(new Help(view)));
    }

    public void run() {
        view.write("Добро пожаловать в библиотеку. Введите команду help  для получения списка доступных команд.");
        doCommand();

    }

    private void doCommand(){
        while (true){
            String inputCommand = view.read();
            for(Command command : commands){
                if(command.canProcess(inputCommand)){
                    command.process();
                    break;
                }
            }

        }
    }

    /*public void run(){
        DataStorage dataStorage = new InMemoryDataStorage();

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
        boolean isFieldBlank = true;
        int pagesCount = 0;
        while (isFieldBlank) {
            try {
                System.out.println("Введите количество страниц: ");
                pagesCount = Integer.parseInt(scanner.nextLine());
                isFieldBlank = false;
            } catch (Exception e) {
                System.out.println("Вы ввели не целое число страниц, введите верное количество страниц.");
            }
        }
        System.out.println("Введите имя автора: ");
        String author = scanner.nextLine();
        Book book = new Book(bookName, pagesCount, author);
        dataStorage.addPublication(book);
        System.out.println("Ваша книга добавлена");
    }*/
}
