package com.Isha.bookMyShow.service;

import com.Isha.bookMyShow.dto.ShowRequest;
import com.Isha.bookMyShow.entity.Movie;
import com.Isha.bookMyShow.entity.Show;
import com.Isha.bookMyShow.repo.ShowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    private final ShowRepo showRepo;
    private final MovieService movieService;
    private final ScreenService screenService;

    @Autowired
    public ShowService(ShowRepo showRepo, MovieService movieService, ScreenService screenService) {
        this.showRepo = showRepo;
        this.movieService = movieService;
        this.screenService = screenService;
    }

    public Show createShow(ShowRequest showRequest) throws Exception {
        if (movieService.getMovieById(showRequest.getMovieId()) == null) { // Checking if movie exists
            throw new Exception("Invalid movie ID");
        }

        if (screenService.getScreenById(showRequest.getScreenId()) == null) { // Checking if screen exists
            throw new Exception("Invalid screen ID");
        }

        Show show = Show.builder()
                .movieId(showRequest.getMovieId())
                .screenId(showRequest.getScreenId())
                .startTime(showRequest.getStartTime())
                .build();
        return showRepo.save(show); // Saving show in database
    }

    public List<Show> getAllShows(){
        return showRepo.findAll();
    }

    public Show getShowById(String showId){
        return showRepo.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found with id "+ showId));
    }

    public Show updateShow(String showId, ShowRequest showRequest){
        Show show = getShowById(showId);

        Show updatedShow = Show.builder()
                .id(show.getId())
                .movieId(showRequest.getMovieId())
                .screenId(showRequest.getScreenId())
                .startTime(showRequest.getStartTime())
                .build();

        return showRepo.save(updatedShow);
    }

    public Show deleteShow(String showId){
        Show deletedShow = getShowById(showId);
        showRepo.deleteById(showId);
        return deletedShow;
    }

    public List<Show> getShowsByScreenId(String screenId) {
        return showRepo.findByScreenId(screenId); // Fetching shows for a specific screen
    }
}
