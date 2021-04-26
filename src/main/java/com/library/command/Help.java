package com.library.command;

import com.library.view.View;

public class Help implements Command {

    private View view;

    public Help(View view) {
        this.view = view;
    }

    @Override
    public void process() {
        view.write("help - show a list of commands");
        view.write("exit - exit from an application");
        view.write("add_book - add book to library");
        view.write("find_all - show the list of publications");
    }

    @Override
    public String commandName() {
        return "help";
    }
}
