package com.library.command;

import com.library.model.DataStorage;
import com.library.model.entity.Book;
import com.library.view.View;

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
        boolean isFieldBlank = true;
        int pagesCount = 0;
        while (isFieldBlank) {
            try {
                view.write("Введите количество страниц: ");
                pagesCount = Integer.parseInt(view.read());
                isFieldBlank = false;
            } catch (Exception e) {
                view.write("Вы ввели не целое число страниц, введите верное количество страниц.");
            }
        }
        view.write("Введите имя автора: ");
        String author = view.read();
        Book book = new Book(bookName, pagesCount, author);
        dataStorage.addPublication(book);
        view.write("Ваша книга добавлена");
    }
}
