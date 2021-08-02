package com.library.model.entity;

import com.library.dto.JournalType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "journal")
public class JournalDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "count_pages")
    private int countPages;
    @Column(name = "year")
    private int year;
    @Column(name = "description")
    private String description;
    @Column(name = "journal_type")
    @Enumerated(EnumType.STRING)
    private JournalType journalType;
    @Column(name = "journal_number")
    private int journalNumber;

    public JournalDAO() {
    }

    public JournalDAO(int id, String name, int countPages, int year, String description, JournalType journalType,
                      int journalNumber) {
        this.id = id;
        this.name = name;
        this.countPages = countPages;
        this.year = year;
        this.description = description;
        this.journalType = journalType;
        this.journalNumber = journalNumber;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JournalType getJournalType() {
        return journalType;
    }

    public void setJournalType(JournalType journalType) {
        this.journalType = journalType;
    }

    public int getJournalNumber() {
        return journalNumber;
    }

    public void setJournalNumber(int number) {
        this.journalNumber = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JournalDAO)) return false;
        JournalDAO that = (JournalDAO) o;
        return getCountPages() == that.getCountPages() && getYear() == that.getYear() && getJournalNumber() == that.getJournalNumber() && Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription()) && getJournalType() == that.getJournalType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCountPages(), getYear(), getDescription(), getJournalType(), getJournalNumber());
    }
}