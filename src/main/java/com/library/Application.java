package com.library;


import com.library.config.DatabaseConnectionManager;
import com.library.controller.MainController;
import com.library.model.BookRepository;
import com.library.model.DataStorage;
import com.library.model.InMemoryDataStorage;
import com.library.model.Repository;
import com.library.model.entity.BookDAO;
import com.library.service.BookService;
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

        Repository<BookDAO> bookRepository = new BookRepository(ds);
        BookService bookService = new BookService(bookRepository);
        MainController controller = new MainController(storage, view, bookService);

        controller.run();
    }
}
