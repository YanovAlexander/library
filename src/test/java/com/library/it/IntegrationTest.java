package com.library.it;

import com.library.Application;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {

    private ConfigurableInputStream in;
    private ByteArrayOutputStream out;


    @Before
    public void init() {
        in = new ConfigurableInputStream();
        out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new PrintStream(out));
    }

    @After
    public void clear() {
        out.reset();
    }

    @Test
    public void testHelpCommand_happyPath() {
        //given
        in.add("help");
        in.add("exit");

        //when
        Application.main(new String[0]);

        assertEquals("Welcome to the library\n" +
                "Please enter a command or help to retrieve command list\n" +
                "help - show a list of commands\n" +
                "exit - exit from an application\n" +
                "add_book - add book to library\n" +
                "find_all - show the list of publications\n" +
                "Please enter a command or help to retrieve command list\n" +
                "Good Bye!\n", getActualResult());
    }

    @Test
    public void testAddBookCommand_happyPath(){
        //given
        in.add("add_book");
        in.add("Master i Margarita");
        in.add("294");
        in.add("Mickail Bulgakov");
        in.add("1968");
        in.add("exit");

        //when
        Application.main(new String[0]);

        //then
        Assert.assertEquals("Welcome to the library\n" +
                "Please enter a command or help to retrieve command list\n" +
                "Enter the book name:\n" +
                "Enter number of pages: \n" +
                "Author's name: \n" +
                "Enter the publication's year: \n" +
                "The book Master i Margarita added successfully\n" +
                "Please enter a command or help to retrieve command list\n" +
                "Good Bye!\n", getActualResult());
    }

    @Test
    public void testAddBookCommand_WrongNumbersFormatForPageCount(){
        //given
        in.add("add_book");
        in.add("Master i Margarita");
        in.add("-294");
        in.add("294");
        in.add("Mickail Bulgakov");
        in.add("1968");
        in.add("exit");

        //when
        Application.main(new String[0]);

        Assert.assertEquals("Welcome to the library\n" +
                "Please enter a command or help to retrieve command list\n" +
                "Enter the book name:\n" +
                "Enter number of pages: \n" +
                "Wrong format, enter integer.\n" +
                "Enter number of pages: \n" +
                "Author's name: \n" +
                "Enter the publication's year: \n" +
                "The book Master i Margarita added successfully\n" +
                "Please enter a command or help to retrieve command list\n" +
                "Good Bye!\n", getActualResult());
    }

    @Test
    public void testAddBookCommand_WrongNumbersFormatForPublicationYear(){
        //given
        in.add("add_book");
        in.add("Master i Margarita");
        in.add("294");
        in.add("Mickail Bulgakov");
        in.add("gfg");
        in.add("1968");
        in.add("exit");

        //when
        Application.main(new String[0]);

        Assert.assertEquals("Welcome to the library\n" +
                "Please enter a command or help to retrieve command list\n" +
                "Enter the book name:\n" +
                "Enter number of pages: \n" +
                "Author's name: \n" +
                "Enter the publication's year: \n" +
                "Wrong data, enter the number\n" +
                "Enter the publication's year: \n" +
                "The book Master i Margarita added successfully\n" +
                "Please enter a command or help to retrieve command list\n" +
                "Good Bye!\n", getActualResult());
    }

    @Test
    public void testAddBookCommand_AddDuplicateBookException(){
        //given
        in.add("add_book");
        in.add("Master i Margarita");
        in.add("-294");
        in.add("294");
        in.add("Mickail Bulgakov");
        in.add("1968");
        in.add("add_book");
        in.add("Master i Margarita");
        in.add("-294");
        in.add("294");
        in.add("Mickail Bulgakov");
        in.add("1968");
        in.add("exit");

        //when
        Application.main(new String[0]);

        Assert.assertEquals("Welcome to the library\n" +
                "Please enter a command or help to retrieve command list\n" +
                "Enter the book name:\n" +
                "Enter number of pages: \n" +
                "Wrong format, enter integer.\n" +
                "Enter number of pages: \n" +
                "Author's name: \n" +
                "Enter the publication's year: \n" +
                "The book Master i Margarita added successfully\n" +
                "Please enter a command or help to retrieve command list\n" +
                "Enter the book name:\n" +
                "Enter number of pages: \n" +
                "Wrong format, enter integer.\n" +
                "Enter number of pages: \n" +
                "Author's name: \n" +
                "Enter the publication's year: \n" +
                "This publication already exist, add another publication\n" +
                "Please enter a command or help to retrieve command list\n" +
                "Good Bye!\n", getActualResult());
    }

    private String getActualResult() {
        return new String(out.toByteArray(), StandardCharsets.UTF_8).replaceAll("\r\n", "\n");
    }
}
