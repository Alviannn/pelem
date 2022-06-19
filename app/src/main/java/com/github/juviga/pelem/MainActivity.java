package com.github.juviga.pelem;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.github.juviga.pelem.services.MovieService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText searchBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SharedData.MOVIE_SERVICE = retrofit.create(MovieService.class);

        searchBox = findViewById(R.id.searchBox);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Log.d("test", "masuk");
        fragmentManager.beginTransaction().replace(R.id.fragment_container, new MainFragment()).commit();
    }

    public void changeFragment(View view) {
        SharedData.searchText = searchBox.getText().toString().trim();
        if(!SharedData.searchText.isEmpty()){
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, new SearchFragment()).commit();
        }
    }
}