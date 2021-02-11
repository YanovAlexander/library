package com.library;


import com.library.controller.MainController;
import com.library.model.DataStorage;
import com.library.model.InMemoryDataStorage;
import com.library.model.entity.Publication;
import com.library.view.Console;
import com.library.view.View;

public class Application {
    public static void main(String[] args) {
        DataStorage<Publication> storage = new InMemoryDataStorage<>();
        View view = new Console();

        MainController controller = new MainController(storage, view);

        controller.run();
    }
}
