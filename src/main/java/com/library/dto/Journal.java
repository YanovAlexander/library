package com.library.dto;

import java.util.Objects;

public class Journal extends Publication {
    private int number;

    public Journal(String name, int countPages, int number, int publicationYear) {
        super(name, countPages, publicationYear);
        this.number = number;
    }

    @Override
    public String print() {
        return "Journal{" + super.print() + ", number=" + this.number + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Journal)) return false;
        if (!super.equals(o)) return false;
        Journal journal = (Journal) o;
        return number == journal.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
