package com.library.command;

import com.library.model.DataStorage;
import com.library.model.entity.Publication;
import com.library.view.View;

import java.util.List;

public class FindAll implements Command {

    private View view;
    private DataStorage dataStorage;

    public FindAll(View view, DataStorage dataStorage) {
        this.view = view;
        this.dataStorage = dataStorage;
    }

    @Override
    public void process() {
        List<Publication> allPublications = dataStorage.findAll();
        if(allPublications.isEmpty()){
            view.write("Библиотека пустая. Добавьте книгу.");
        }
        for (Publication name : allPublications) {
            view.write(name.print());
        }
    }

    @Override
    public String commandName() {
        return "find_all";
    }

}
