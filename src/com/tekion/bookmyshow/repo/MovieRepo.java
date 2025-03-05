package com.tekion.bookmyshow.repo;

import com.tekion.bookmyshow.model.Movie;

import java.util.HashMap;
import java.util.Map;

public class MovieRepo {
    public static MovieRepo INSTANCE = new MovieRepo();
    private int id = 0;
    private Map<Integer, Movie> movieMap = new HashMap<>();

    private MovieRepo() {
    }

    public Movie saveMovie(Movie movie) {
        id++;
        movie.setId(id);
        movieMap.put(id, movie);
        return movie;
    }

    public Movie getMovie(int moviId) {
        return movieMap.get(moviId);
    }

    public Movie removeMovie(int movieId){
        return movieMap.remove(movieId);
    }
}
