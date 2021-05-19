package com.library;


import com.library.config.DatabaseConnectionManager;
import com.library.controller.MainController;
import com.library.model.DataStorage;
import com.library.model.InMemoryDataStorage;
import com.library.util.PropertiesLoader;
import com.library.view.Console;
import com.library.view.View;

public class Application {
    public static void main(String[] args) {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        propertiesLoader.loadPropertiesFile("application.properties");

        DatabaseConnectionManager ds = new DatabaseConnectionManager(propertiesLoader.getProperty("host"),
                propertiesLoader.getProperty("database.name"),
                propertiesLoader.getProperty("username"),
                propertiesLoader.getProperty("password"));
        DataStorage storage = new InMemoryDataStorage();
        View view = new Console();

        MainController controller = new MainController(storage, view);

        controller.run();
    }
}
