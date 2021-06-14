package com.library.model.entity;

import com.library.dto.JournalType;

import java.util.Objects;

public class JournalDAO {
    private long id;
    private String name;
    private int countPages;
    private int year;
    private String description;
    private JournalType journalType;
    private int number;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JournalDAO)) return false;
        JournalDAO that = (JournalDAO) o;
        return getCountPages() == that.getCountPages() && getYear() == that.getYear() && getNumber() == that.getNumber() && Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription()) && getJournalType() == that.getJournalType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCountPages(), getYear(), getDescription(), getJournalType(), getNumber());
    }
}