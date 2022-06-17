package com.github.juviga.pelem.models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie extends SimpleMovie {

    private String homepage;
    private String status;
    private String tagline;

    private List<Genre> genres;
    @SerializedName("production_companies")
    private List<Company> productionCompanies;

    private int runtime;

    public String getHomepage() {
        return homepage;
    }

    public String getStatus() {
        return status;
    }

    public String getTagline() {
        return tagline;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public List<Company> getProductionCompanies() {
        return productionCompanies;
    }

    public int getRuntime() {
        return runtime;
    }

    @NonNull
    @Override
    public String toString() {
        return "Movie{" +
               "homepage='" + homepage + '\'' +
               ", status='" + status + '\'' +
               ", tagline='" + tagline + '\'' +
               ", genres=" + genres +
               ", productionCompanies=" + productionCompanies +
               ", runtime=" + runtime +
               '}';
    }

}
