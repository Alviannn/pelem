package com.github.juviga.pelem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.juviga.pelem.models.Movie;

import javax.microedition.khronos.opengles.GL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private ImageView imgBackdrop, imgPoster;
    private TextView tvTitle, tvGenres, tvOverview, tvPopularity, tvReleaseDate, tvStatus, tvCompanies;
    private Movie mMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        SharedData.MOVIE_SERVICE.getDetail(SharedData.idMovie).enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                mMovie = response.body();
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });

        imgBackdrop = findViewById(R.id.img_backdrop);
        imgPoster = findViewById(R.id.img_poster);
        tvTitle = findViewById(R.id.tv_title);
        tvGenres = findViewById(R.id.tv_genre_content);
        tvOverview = findViewById(R.id.tv_overview_content);
        tvPopularity = findViewById(R.id.tv_popularity_content);
        tvReleaseDate = findViewById(R.id.tv_release_date_content);
        tvStatus = findViewById(R.id.tv_status_content);
        tvCompanies = findViewById(R.id.tv_company_content);

        Glide.with(this).load("https://www.themoviedb.org/t/p/w533_and_h300_bestv2"+mMovie.getBackdropPath()).into(imgBackdrop);
        Glide.with(this).load("https://image.tmdb.org/t/p/w600_and_h900_bestv2"+mMovie.getPosterPath()).into(imgBackdrop);
        tvTitle.setText(mMovie.getTitle());
        tvGenres.setText(mMovie.getGenres().toString());
        tvOverview.setText(mMovie.getOverview());
        tvPopularity.setText(String.valueOf(mMovie.getPopularity()));
        tvReleaseDate.setText(mMovie.getReleaseDate());
        tvStatus.setText(mMovie.getStatus());
        tvCompanies.setText(mMovie.getProductionCompanies().toString());
    }
}