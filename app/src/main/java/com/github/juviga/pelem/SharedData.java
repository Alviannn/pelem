package com.github.juviga.pelem;

import com.github.juviga.pelem.models.SimpleMovie;
import com.github.juviga.pelem.services.MovieService;

import java.util.ArrayList;
import java.util.List;

public class SharedData {

    public static final String API_KEY = "8a818bf41fc4f44ca1681cd3f25531cc";
    public static MovieService MOVIE_SERVICE;
    public static List<SimpleMovie>popularList = new ArrayList<>();
    public static List<SimpleMovie>nowPlayingList = new ArrayList<>();
    public static List<SimpleMovie>upcomingList = new ArrayList<>();
    public static SimpleMovie currentMovie;

}
