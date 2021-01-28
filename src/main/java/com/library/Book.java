package com.library;

import java.util.Objects;

public class Book extends Publication {
    private String author;

    public Book(String name, int countPages, String author) {
        super(name, countPages);
        this.author = author;
    }

    @Override
    public String print() {
        return "Book{" + super.print() + ", author= " + this.author + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author);
    }
}
