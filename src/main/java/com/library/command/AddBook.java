package com.library.command;

import com.library.dto.Genre;
import com.library.exceptions.DataStorageException;
import com.library.model.DataStorage;
import com.library.dto.BookDTO;
import com.library.view.View;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.library.command.Messages.*;

public class AddBook implements Command {
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
        view.write("Enter the book name:");
        String bookName = view.read();
        int pagesCount = getIntegerFromConsole(PAGE_NUMBER.getMessage(), PAGE_NUMBER.getErrorMessage());

        view.write("Author's name: ");
        String author = view.read();

        view.write("Add description: ");
        String description = view.read();

        String genres = Arrays.stream(Genre.values())
                .map(Genre::name)
                .collect(Collectors.joining(", "));

        Genre genre = getGenreFromConsole(String.format(GENRE.getMessage(), genres), GENRE.getErrorMessage());

        int publicationYear = getIntegerFromConsole(PUBLICATION_YEAR.getMessage(), PUBLICATION_YEAR.getErrorMessage());

        BookDTO bookDTO = new BookDTO(0, author, bookName, pagesCount, publicationYear, description, genre);
        try {
//            dataStorage.addPublication(bookDTO);
        }catch (DataStorageException ex){
            view.write(ex.getMessage());
            return;
        }
        view.write(String.format("The book %s added successfully", bookDTO.getName()));
    }

    private int getIntegerFromConsole(String message, String errorMessage) {
        int number = 0;
        boolean isFieldBlank = true;
        while (isFieldBlank) {
            try {
                view.write(message);
                number = Integer.parseInt(view.read());
                if (number <= 0) {
                    view.write(errorMessage);
                } else {
                    isFieldBlank = false;
                }
            } catch (Exception e) {
                view.write(errorMessage);
            }
        }
        return number;
    }

    private Genre getGenreFromConsole(String message, String errorMessage) {
        Genre genre = null;
        boolean isFieldBlank = true;
        while (isFieldBlank) {
            try {
                view.write(message);
                genre = Genre.valueOf(view.read());
                isFieldBlank = false;
            } catch (Exception e) {
                view.write(errorMessage);
            }
        }
        return genre;
    }
}
