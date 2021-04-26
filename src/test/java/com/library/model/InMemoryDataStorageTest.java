package com.library.model;

import com.library.exceptions.DataStorageException;
import com.library.model.entity.Book;
import com.library.model.entity.Publication;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class InMemoryDataStorageTest {

    private DataStorage dataStorage;

    @Before
    public void init() {
        dataStorage = new InMemoryDataStorage();
    }

    @Test
    public void testShouldSaveBook_happyPath() {
        //given
        Book expected = new Book("Concurrency in practice", 800, "Brian Goetz", 2010);
        //when
        dataStorage.addPublication(expected);
        //then
        final List<Publication> publications = dataStorage.findAll();
        Book actual = (Book) publications.get(0);

        assertEquals(expected, actual);
        assertEquals(1, publications.size());
    }

    @Test
    public void testShouldSaveBook_whenBookIsNull() {
        //given
        Book expected = null;
        //when
        //then
        assertThrows("Publication can't be null", DataStorageException.class,
                () -> dataStorage.addPublication(expected));
    }
}