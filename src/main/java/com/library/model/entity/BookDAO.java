package com.library.model.entity;

import com.library.dto.enums.Genre;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book")
public class BookDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="author_id", nullable=false)
    private AuthorDAO author;
    @Column(name = "name")
    private String name;
    @Column(name = "count_pages")
    private int countPages;
    @Column(name = "publication_year")
    private int publicationYear;
    @Column(name = "description")
    private String description;
    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Genre genre;


    public BookDAO() {
    }

    public BookDAO(int id, AuthorDAO author, String name, int countPages, int publicationYear, String description, Genre genre) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.countPages = countPages;
        this.publicationYear = publicationYear;
        this.description = description;
        this.genre = genre;
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
        return id == bookDAO.id && countPages == bookDAO.countPages && publicationYear == bookDAO.publicationYear && Objects.equals(name, bookDAO.name) && Objects.equals(description, bookDAO.description) && genre == bookDAO.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countPages, publicationYear, description, genre);
    }

    public AuthorDAO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDAO author) {
        this.author = author;
    }
}
