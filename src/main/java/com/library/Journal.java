package com.library;

public class Journal extends Publication{

    int number;
    int publicationYear;

    public Journal(String name, int countPages, String name1, int countPages1, int number, int publicationYear) {
        super(name, countPages);
        this.number = number;
        this.publicationYear = publicationYear;
    }

    @Override
    public String print(){
        return "Journal{" + super.print() + ", number=" + this.number + ",year=" + this.publicationYear + "}";

    }
}
