package com.library;

public class Publication {
    private String name;
    private int countPage;

    public Publication(String name, int countPage) {
        this.name = name;
        this.countPage = countPage;
    }

    @Override
    public String toString() {
        return "name='" + this.name +
                ", countPage=" + this.countPage;
    }
}
