package com.github.juviga.pelem.services;

import com.github.juviga.pelem.SharedData;
import com.github.juviga.pelem.models.Movie;
import com.github.juviga.pelem.models.Pagination;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {

    @GET("movie/{movieId}?api_key=" + SharedData.API_KEY)
    Call<Movie> getDetail(@Path("movieId") int movieId);

    @GET("movie/popular?api_key=" + SharedData.API_KEY)
    Call<Pagination> getPopulars(@Query("page") int page);

    @GET("movie/upcoming?api_key=" + SharedData.API_KEY)
    Call<Pagination> getUpcoming(@Query("page") int page);

    @GET("movie/now_playing?api_key=" + SharedData.API_KEY)
    Call<Pagination> getNowPlaying(@Query("page") int page);

    @GET("search/movie?api_key=" + SharedData.API_KEY)
    Call<Pagination> search(@Query("query") String title, @Query("page") int page);

}
