package com.library.dto;

import java.util.Objects;

public class BookDTO {

    private long id;
    private String author;
    private String name;
    private int countPages;
    private int publicationYear;
    private String description;
    private Genre genre;

    public BookDTO() {
    }

    public BookDTO(long id, String author, String name, int countPages, int publicationYear, String description, Genre genre) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.countPages = countPages;
        this.publicationYear = publicationYear;
        this.description = description;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDTO bookDTO = (BookDTO) o;
        return id == bookDTO.id && countPages == bookDTO.countPages && publicationYear == bookDTO.publicationYear && Objects.equals(author, bookDTO.author) && Objects.equals(name, bookDTO.name) && Objects.equals(description, bookDTO.description) && genre == bookDTO.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, name, countPages, publicationYear, description, genre);
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", countPages=" + countPages +
                ", publicationYear=" + publicationYear +
                ", description='" + description + '\'' +
                ", genre=" + genre +
                '}';
    }
}
