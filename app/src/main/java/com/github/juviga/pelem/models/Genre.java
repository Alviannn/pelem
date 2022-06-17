package com.github.juviga.pelem.models;

import androidx.annotation.NonNull;

public class Genre {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return "Genre{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }

}
