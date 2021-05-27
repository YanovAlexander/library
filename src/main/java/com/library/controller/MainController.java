package com.library.controller;

import com.library.command.AddBook;
import com.library.command.Command;
import com.library.command.FindAll;
import com.library.command.Help;
import com.library.model.DataStorage;
import com.library.service.BookService;
import com.library.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {
    private View view;
    private List<Command> commands;

    public MainController(DataStorage dataStorage, View view, BookService bookService) {
        this.view = view;
        this.commands = new ArrayList<>(Arrays.asList(
                new Help(view), new AddBook(view, bookService), new FindAll(view, dataStorage)
        ));
    }

    public void run() {
        view.write("Welcome to the library");
        doCommand();
    }

    private void doCommand() {
        boolean isNotExit = true;
        while (isNotExit) {
            view.write("Please enter a command or help to retrieve command list");
            String inputCommand = view.read();
            for (Command command : commands) {
                if (command.canProcess(inputCommand)) {
                    command.process();
                    break;
                } else if (inputCommand.equalsIgnoreCase("exit")) {
                    view.write("Good Bye!");
                    isNotExit = false;
                    break;
                }
            }
        }
    }
}
