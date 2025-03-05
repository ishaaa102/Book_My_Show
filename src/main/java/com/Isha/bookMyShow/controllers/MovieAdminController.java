package com.Isha.bookMyShow.controllers;

import com.Isha.bookMyShow.dto.MovieRequest;
import com.Isha.bookMyShow.entity.Movie;
import com.Isha.bookMyShow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/movie")
public class MovieAdminController {

    private final MovieService movieService;

    @Autowired
    public MovieAdminController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/create")
    public ResponseEntity<Movie> createMovie(@RequestBody MovieRequest movieRequest) throws Exception {
        Movie movie = movieService.createMovie(movieRequest);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/viewById/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String id){
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable String id, @RequestBody MovieRequest movieRequest){
        return ResponseEntity.ok(movieService.updateMovie(id, movieRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable String id){
        Movie movie=movieService.removeMovie(id);
        if(movie==null){
            return ResponseEntity.status(404).body("Movie not found");
        }
        return ResponseEntity.ok(movie);
    }


//        Map<String, Object> response= new LinkedHashMap<>();
//        response.put("id", deletedMovie.getId());
//        response.put("duration", deletedMovie.getDuration());
//        response.put("name", deletedMovie.getName());
//        response.put("description", deletedMovie.getDescription());
//        response.put("genreType", deletedMovie.getGenreType());
//        response.put("directorName", deletedMovie.getDirectorName());

}

