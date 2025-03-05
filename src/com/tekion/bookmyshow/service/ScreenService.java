package com.tekion.bookmyshow.service;

import com.tekion.bookmyshow.model.Screen;
import com.tekion.bookmyshow.repo.ScreenRepo;

import java.util.List;

public class ScreenService {
    public static final ScreenService INSTANCE = new ScreenService();
    TheatreService theatreService;

    ScreenRepo screenRepo;

    private ScreenService() {
        this.screenRepo = ScreenRepo.INSTANCE;
        this.theatreService = TheatreService.INSTANCE;
    }

    public Screen createScreen(int theatreId, String screenName, int noOfSeats) throws Exception {
        if (theatreService.getThreatreById(theatreId) == null) {
            throw new Exception("Invalid theater is provided");
        }
        Screen screen = new Screen(theatreId, screenName, noOfSeats);
        screenRepo.saveScreen(screen);
        return screen;
    }

    public Screen removeScreen(int screenId){
        return screenRepo.removeScreen(screenId);
    }

    public Screen getScreenById(int screenId) {
        return screenRepo.getScreen(screenId);
    }

    public List<Screen> removeScreenByTheatreId(int theatreId){
        return screenRepo.removeScreenByTheatreId(theatreId);
    }

    public List<Screen> getScreenByTheatreID(int theatreId){
        return screenRepo.getScreenByTheatreId(theatreId);
    }
}
