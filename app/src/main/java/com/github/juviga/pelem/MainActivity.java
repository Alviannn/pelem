package com.github.juviga.pelem;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.juviga.pelem.services.MovieService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SharedData.MOVIE_SERVICE = retrofit.create(MovieService.class);
    }

}