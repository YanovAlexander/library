package com.library.command;

import com.library.view.View;

public class Help implements Command{
    private View view;

    public Help(View view) {
        this.view = view;
    }

    @Override
    public void process() {
        view.write("help - список всех доступных команд.");
        view.write("exit - выхода из программы.");
        view.write("add_book - добавить книгу в библиотеку");
    }

    @Override
    public String commandName() {
        return "help";
    }
}
