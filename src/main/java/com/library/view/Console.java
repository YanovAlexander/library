package com.library.view;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Console implements View {

    private Scanner scanner;
    private OutputStream out;

    public Console(InputStream is, OutputStream out) {
        scanner = new Scanner(is);
        this.out = out;
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public void write(String message) {
        try {
            out.write(message.getBytes());
            out.write("\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}