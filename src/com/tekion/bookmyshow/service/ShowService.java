package com.tekion.bookmyshow.service;

import com.tekion.bookmyshow.model.Show;
import com.tekion.bookmyshow.repo.ShowRepo;

import java.util.List;

public class ShowService {
    public static ShowService INSTANCE = new ShowService();

    MovieService movieService;
    ScreenService screenService;
    ShowRepo showRepo;

    public ShowService() {
        this.showRepo = ShowRepo.INSTANCE;
        this.movieService = MovieService.INSTANCE;
        this.screenService = ScreenService.INSTANCE;
    }

    public Show createShow(int movieId, int screenId, String showTime) throws Exception {
        if (movieService.getMovieById(movieId) == null) {
            throw new Exception("invalid movie id");
        }

        if (screenService.getScreenById(screenId) == null) {
            throw new Exception("invalid screen id");
        }

        Show show = new Show(movieId, screenId, showTime);
        showRepo.saveShow(show);
        return show;
    }

    public Show removeShow(int showId){
        return showRepo.removeShow(showId);
    }

    public Show getShowById(int showId) {
        return showRepo.getShow(showId);
    }

    public List<Show> getShowsByScreenId(int screenId){
        return showRepo.getShowsByScreenId(screenId);
    }
}
