package com.github.juviga.pelem.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Company {

    private int id;
    private String name;

    @SerializedName("origin_country")
    private String country;

    @Nullable
    @SerializedName("logo_path")
    private String logoPath;

    @NonNull
    @Override
    public String toString() {
        return "Company{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", country='" + country + '\'' +
               ", logoPath='" + logoPath + '\'' +
               '}';
    }
}
