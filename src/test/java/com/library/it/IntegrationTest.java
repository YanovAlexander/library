package com.library.it;

import com.library.Application;
import org.junit.After;
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

    private String getActualResult() {
        return new String(out.toByteArray(), StandardCharsets.UTF_8).replaceAll("\r\n", "\n");
    }
}
