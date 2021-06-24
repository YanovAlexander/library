package com.library.model.entity;

import com.library.dto.Genre;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import java.util.Objects;

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "Book")
public class BookDAO {
    private int id;
    private String author;
    private String name;
    private int countPages;
    private int publicationYear;
    private String description;
    private Genre genre;


    public BookDAO() {
    }

    public BookDAO(int id, String author, String name, int countPages, int publicationYear, String description, Genre genre) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        BookDAO bookDAO = (BookDAO) o;
        return id == bookDAO.id && countPages == bookDAO.countPages && publicationYear == bookDAO.publicationYear && Objects.equals(author, bookDAO.author) && Objects.equals(name, bookDAO.name) && Objects.equals(description, bookDAO.description) && genre == bookDAO.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, name, countPages, publicationYear, description, genre);
    }

    @Override
    public String toString() {
        return "BookDAO{" +
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
