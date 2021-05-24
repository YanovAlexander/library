package com.library;


import com.library.config.DatabaseConnectionManager;
import com.library.controller.MainController;
import com.library.model.DataStorage;
import com.library.model.InMemoryDataStorage;
import com.library.service.util.PropertiesConfig;
import com.library.view.Console;
import com.library.view.View;

public class Application {
    public static void main(String[] args) {
        PropertiesConfig propertiesLoader = new PropertiesConfig();
        propertiesLoader.loadPropertiesFile("application.properties");

        DatabaseConnectionManager ds = new DatabaseConnectionManager(propertiesLoader);
        DataStorage storage = new InMemoryDataStorage();
        View view = new Console();

        MainController controller = new MainController(storage, view);

        controller.run();
    }
}
