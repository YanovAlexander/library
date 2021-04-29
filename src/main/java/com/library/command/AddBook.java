package com.library.command;

import com.library.model.DataStorage;
import com.library.model.entity.Book;
import com.library.view.View;

import static com.library.command.Messages.*;

public class AddBook implements Command{
    private View view;
    private DataStorage dataStorage;

    public AddBook(View view, DataStorage dataStorage) {
        this.view = view;
        this.dataStorage = dataStorage;
    }

    @Override
    public void process() {
        addBookToDataStorage(dataStorage);
    }

    @Override
    public String commandName() {
        return "add_book";
    }

    private void addBookToDataStorage(DataStorage dataStorage) {
        view.write("Введите название книги:");
        String bookName = view.read();
        int pagesCount = getIntegerFromConsole(PAGE_NUMBER.getMessage(), PAGE_NUMBER.getErrorMessage());

        view.write("Введите имя автора: ");
        String author = view.read();

        int publicationYear = getIntegerFromConsole(PUBLICATION_YEAR.getMessage(), PUBLICATION_YEAR.getErrorMessage());

        Book book = new Book(bookName, pagesCount, author, publicationYear);
        dataStorage.addPublication(book);
        view.write("Ваша книга добавлена");
    }

    private int getIntegerFromConsole(String message, String errorMessage) {
        int number = 0;
        boolean isFieldBlank = true;
        while (isFieldBlank) {
            try {
                view.write(message);
                number = Integer.parseInt(view.read());
                isFieldBlank = false;
            } catch (Exception e) {
                view.write(errorMessage);
            }
        }
        return number;
    }
}
