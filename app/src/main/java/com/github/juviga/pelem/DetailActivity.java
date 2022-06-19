package com.github.juviga.pelem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.juviga.pelem.models.Company;
import com.github.juviga.pelem.models.Genre;
import com.github.juviga.pelem.models.Movie;

import javax.microedition.khronos.opengles.GL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private ImageView imgBackdrop, imgPoster, imgBack;
    private TextView tvTitle, tvGenres, tvOverview, tvPopularity, tvReleaseDate, tvStatus, tvCompanies;
    private Movie mMovie;
    private String[] genres, companies;
    private Genre genre;
    private Company company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgBack = findViewById(R.id.img_back_icon);
        imgBackdrop = findViewById(R.id.img_backdrop);
        imgPoster = findViewById(R.id.img_poster);
        tvTitle = findViewById(R.id.tv_title);
        tvGenres = findViewById(R.id.tv_genre_content);
        tvOverview = findViewById(R.id.tv_overview_content);
        tvPopularity = findViewById(R.id.tv_popularity_content);
        tvReleaseDate = findViewById(R.id.tv_release_date_content);
        tvStatus = findViewById(R.id.tv_status_content);
        tvCompanies = findViewById(R.id.tv_company_content);

        SharedData.MOVIE_SERVICE.getDetail(SharedData.idMovie).enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                mMovie = response.body();
                Log.d("LMAO", mMovie.getBackdropPath());
                Glide.with(getApplicationContext()).load("https://www.themoviedb.org/t/p/w533_and_h300_bestv2"+mMovie.getBackdropPath()).into(imgBackdrop);
                Glide.with(getApplicationContext()).load("https://image.tmdb.org/t/p/w600_and_h900_bestv2"+mMovie.getPosterPath()).into(imgPoster);
                tvTitle.setText(mMovie.getTitle());

                genres = new String[mMovie.getGenres().size()];
                for (int i = 0; i < mMovie.getGenres().size(); i++) {
                    genre = mMovie.getGenres().get(i);
                    genres[i] = genre.getName();
                }
                tvGenres.setText(String.join(", ", genres));
                tvOverview.setText(mMovie.getOverview());
                tvPopularity.setText(String.valueOf(mMovie.getPopularity()));
                tvReleaseDate.setText(mMovie.getReleaseDate());
                tvStatus.setText(mMovie.getStatus());

                companies = new String[mMovie.getProductionCompanies().size()];
                for (int i = 0; i < mMovie.getProductionCompanies().size(); i++) {
                    company = mMovie.getProductionCompanies().get(i);
                    companies[i] = company.getName();
                }
                tvCompanies.setText(String.join(", ", companies));
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                t.printStackTrace();
            }
        });


        imgBack.setOnClickListener(view -> finish());
    }
}