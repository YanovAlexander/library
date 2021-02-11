package com.library.controller;

import com.library.command.AddBook;
import com.library.command.Command;
import com.library.command.Help;
import com.library.model.DataStorage;
import com.library.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {
    private View view;
    private List<Command> commands;

    public MainController(DataStorage dataStorage, View view) {
        this.view = view;
        this.commands = new ArrayList<>(Arrays.asList(
                new Help(view), new AddBook(view, dataStorage)
        ));
    }

    public void run() {
        view.write("Добро пожаловать в библиотеку.");
        doCommand();
    }

    private void doCommand() {
        boolean isNotExit = true;
        while (isNotExit) {
            view.write("Введите команду help  для получения списка доступных команд.");
            String inputCommand = view.read();
            for (Command command : commands) {
                if (command.canProcess(inputCommand)) {
                    command.process();
                    break;
                } else if (inputCommand.equalsIgnoreCase("exit")) {
                    view.write("Сессия окончена. Вы покидаете библиотеку.");
                    isNotExit = false;
                    break;
                }
            }
        }
    }



    /*
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
     */


}
