package com.library.model.entity;

public class Publication {
    private String name;
    private int countPages;
    private int publicationYear;

    public Publication(String name, int countPages, int publicationYear) {
        this.name = name;
        this.countPages = countPages;
        this.publicationYear = publicationYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String print() {
        return "name=" + this.name + ", count pages=" + this.countPages + "year=" + this.publicationYear;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null){
            return false;
        }
        if(this == o){
            return true;
        }
        if(this.getClass() != o.getClass()){
            return false;
        }
        Publication that = (Publication) o;
        return this.name.equals(that.name) && this.countPages == that.countPages;
    }
}
