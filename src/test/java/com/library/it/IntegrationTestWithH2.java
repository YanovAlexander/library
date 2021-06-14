package com.library.it;

import com.library.config.DatabaseTestConnectionManager;
import com.library.model.BookRepository;
import com.library.service.BookService;
import com.library.view.Console;
import com.library.view.View;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class IntegrationTestWithH2 {
    private ConfigurableInputStream in = new ConfigurableInputStream();
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private View view = new Console(in, out);
    private static DatabaseTestConnectionManager connectionManager = new DatabaseTestConnectionManager();
    private BookRepository bookRepository = new BookRepository(connectionManager.getDataSource());
    private BookService bookService = new BookService(bookRepository);


    @Before
    public void init() {
        //TODO add cleaning h2 database
    }

    @After
    public void destroy() {
        out.reset();
        try {
            in.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getActualResult() {
        return new String(out.toByteArray(), StandardCharsets.UTF_8).replaceAll("\r\n", "\n");
    }

}
