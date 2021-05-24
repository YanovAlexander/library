package com.library.model;

import com.library.dto.Publication;
import java.util.List;

public interface DataStorage {
    void addPublication(Publication publication);
    void remove(Publication publication);
    List<Publication> findAll();
}
