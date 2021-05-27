package com.library.it;

import com.library.command.AddBook;
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
    private BookRepository bookRepository = new BookRepository(connectionManager);
    private BookService bookService = new BookService(bookRepository);
    private AddBook addBookCommand = new AddBook(view, bookService);

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

    @Test
    public void addBook_happyPath() {
        in.add("add_book");
        in.add("Master i Margarita");
        in.add("294");
        in.add("Bulgakov");
        in.add("acbd");
        in.add("HORROR");
        in.add("1989");

        addBookCommand.process();

        Assert.assertEquals("Enter the book name:\n" +
                "Enter number of pages: \n" +
                "Wrong format, enter integer.\n" +
                "Enter number of pages: \n" +
                "Author's name: \n" +
                "Add description: \n" +
                "Enter genre from list ROMANCE, DETECTIVE, FANTASY, HISTORICAL, HORROR, WOMEN_FICTION:\n" +
                "Enter the publication's year: \n" +
                "The book add_book added successfully\n", getActualResult());
    }

    @Test
    public void addBookWithIncorrectGenre_happyPath() {
        in.add("add_book");
        in.add("Master i Margarita");
        in.add("294");
        in.add("Bulgakov");
        in.add("acbd");
        in.add("HORROR121");
        in.add("HORROR");
        in.add("1989");

        addBookCommand.process();

        Assert.assertEquals("Enter the book name:\n" +
                "Enter number of pages: \n" +
                "Wrong format, enter integer.\n" +
                "Enter number of pages: \n" +
                "Author's name: \n" +
                "Add description: \n" +
                "Enter genre from list ROMANCE, DETECTIVE, FANTASY, HISTORICAL, HORROR, WOMEN_FICTION:\n" +
                "Wrong genre, choose from list.\n" +
                "Enter genre from list ROMANCE, DETECTIVE, FANTASY, HISTORICAL, HORROR, WOMEN_FICTION:\n" +
                "Enter the publication's year: \n" +
                "The book add_book added successfully\n", getActualResult());
    }

    private String getActualResult() {
        return new String(out.toByteArray(), StandardCharsets.UTF_8).replaceAll("\r\n", "\n");
    }

}
