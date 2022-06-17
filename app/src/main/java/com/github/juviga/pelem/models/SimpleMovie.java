package com.github.juviga.pelem.models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class SimpleMovie {

    private int id;

    @SerializedName("genre_ids")
    private int[] genreIds;

    private double popularity;
    @SerializedName("vote_average")
    private double voteAverage;
    private double voteCount;

    @SerializedName("original_language")
    private String language;
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("original_title")
    private String originalTitle;
    private String title;

    public int getId() {
        return id;
    }

    public int[] getGenreIds() {
        return genreIds;
    }

    public double getPopularity() {
        return popularity;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public double getVoteCount() {
        return voteCount;
    }

    public String getLanguage() {
        return language;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    @NonNull
    @Override
    public String toString() {
        return "SimpleMovie{" +
               "id=" + id +
               ", genreIds=" + Arrays.toString(genreIds) +
               ", popularity=" + popularity +
               ", voteAverage=" + voteAverage +
               ", voteCount=" + voteCount +
               ", language='" + language + '\'' +
               ", overview='" + overview + '\'' +
               ", releaseDate='" + releaseDate + '\'' +
               ", backdropPath='" + backdropPath + '\'' +
               ", posterPath='" + posterPath + '\'' +
               ", originalTitle='" + originalTitle + '\'' +
               ", title='" + title + '\'' +
               '}';
    }
}
