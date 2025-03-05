package com.Isha.bookMyShow.service;

import com.Isha.bookMyShow.dto.MovieRequest;
import com.Isha.bookMyShow.entity.GenreType;
import com.Isha.bookMyShow.entity.Movie;
import com.Isha.bookMyShow.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepo movieRepo;

    @Autowired
    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public Movie createMovie(MovieRequest movieRequest) {
        // new Movie(duration, movieName, description, genreType, directorName);
        Movie movie = Movie.builder()
                .duration(movieRequest.getDuration())
                .name(movieRequest.getName())
                .description(movieRequest.getDescription())
                .genreType(movieRequest.getGenreType())
                .directorName(movieRequest.getDirectorName())
                .build();
        return movieRepo.save(movie);
    }

    public List<Movie> getAllMovies(){
        return movieRepo.findAll();
    }

    public Movie getMovieById(String id) {
        return movieRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("movie not found of id "+id));
    }

    public Movie updateMovie(String id, MovieRequest movieRequest){
        Movie movie= getMovieById(id);

        Movie updatedMovie= Movie.builder()
                .id(movie.getId())
                .duration(movieRequest.getDuration())
                .name(movieRequest.getName())
                .description(movieRequest.getDescription())
                .genreType(movieRequest.getGenreType())
                .directorName(movieRequest.getDirectorName())
                .build();
        return movieRepo.save(updatedMovie);
    }

    public Movie removeMovie(String movieId) {
        Movie deletedMovie = getMovieById(movieId);
        if(deletedMovie==null){
            return null;
        }
        movieRepo.deleteById(movieId);
        return deletedMovie;
    }
}
