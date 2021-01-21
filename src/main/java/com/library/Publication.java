package com.library;

import java.util.Objects;

public class Publication {
    private String name;
    private int countPages;

    public Publication(String name, int countPages) {
        this.name = name;
        this.countPages = countPages;
    }

    public String print() {
        return "name =" + this.name + ", count pages" + this.countPages;
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
