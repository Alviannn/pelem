package com.github.juviga.pelem.models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pagination {

    private int page;

    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("total_results")
    private int totalResults;

    private List<SimpleMovie> results;

    public int getPage() {
        return page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<SimpleMovie> getResults() {
        return results;
    }

    @NonNull
    @Override
    public String toString() {
        return "Pagination{" +
               "page=" + page +
               ", totalPages=" + totalPages +
               ", totalResults=" + totalResults +
               ", results=" + results +
               '}';
    }

}
