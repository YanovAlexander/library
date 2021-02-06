package com.library.model.entity;

import java.util.Objects;

public class Journal extends Publication {
    private int number;
    private int publicationYear;

    public Journal(String name, int countPages, int number, int publicationYear) {
        super(name, countPages);
        this.number = number;
        this.publicationYear = publicationYear;
    }

    @Override
    public String print() {
        return "Journal{" + super.print() + ", number=" + this.number + ", year=" + this.publicationYear + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Journal)) return false;
        if (!super.equals(o)) return false;
        Journal journal = (Journal) o;
        return number == journal.number && publicationYear == journal.publicationYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, publicationYear);
    }
}
