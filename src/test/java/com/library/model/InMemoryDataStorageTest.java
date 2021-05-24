package com.library.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class InMemoryDataStorageTest {
/*
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

    @Test
    public void testEquals_happyPath() {
        Book actual = new Book("Concurrency in practice", 800, "Brian Goetz", 2010);
        Book expected = new Book("Concurrency in practice", 800, "Brian Goetz", 2010);

        assertEquals(actual, expected);
    }

    @Test
    public void testShouldRemovePublication_happyPath(){
        Book actual = new Book("Concurrency in practice", 800, "Brian Goetz", 2010);
        dataStorage.addPublication(actual);
        dataStorage.remove(actual);
        assertEquals(0, dataStorage.findAll().size());
    }
    @Test
    public void testShouldRemovePublication_whenPublicationIsNull(){
        assertThrows("Publication can't be null", DataStorageException.class,
                ()-> dataStorage.remove(null));
    }*/
}