package com.tekion.bookmyshow.service;

import com.tekion.bookmyshow.model.GenreType;
import com.tekion.bookmyshow.model.Movie;
import com.tekion.bookmyshow.repo.MovieRepo;

public class MovieService {
    public static MovieService INSTANCE = new MovieService();

    MovieRepo movieRepo;

    private MovieService() {
        this.movieRepo = MovieRepo.INSTANCE;
    }

    public Movie createmMovie(String duration, String movieName, String description, GenreType genreType, String directorName) {
        Movie movie = new Movie(duration, movieName, description, genreType, directorName);
        movieRepo.saveMovie(movie);
        return movie;
    }

    public Movie getMovieById(int movieId) {
        return movieRepo.getMovie(movieId);
    }

    public Movie removeMovie(int movieId){
        return movieRepo.removeMovie(movieId);
    }
}
