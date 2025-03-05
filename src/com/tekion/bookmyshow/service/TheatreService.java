package com.tekion.bookmyshow.service;

import com.tekion.bookmyshow.model.Address;
import com.tekion.bookmyshow.model.Theatre;
import com.tekion.bookmyshow.repo.TheatreRepo;

import java.util.List;

public class TheatreService {

    public static final TheatreService INSTANCE = new TheatreService();

    TheatreRepo theatreRepo;

    private TheatreService() {
        this.theatreRepo = TheatreRepo.INSTANCE;
    }

    public Theatre createTheatre(String theatreName, Address address) {
        Theatre theatre = new Theatre(theatreName, address);
        theatreRepo.saveTheatre(theatre);
        return theatre;
    }

    public Theatre removeTheatre(int theatreId) throws Exception {
        if(theatreRepo.removeTheatre(theatreId)==null){
            throw new Exception("invalid theatre id");
        }
       return theatreRepo.removeTheatre(theatreId);
    }

    public Theatre getThreatreById(int theatreId) {
        return theatreRepo.getTheatre(theatreId);
    }

    public List<Theatre> getTheatres(){
        return theatreRepo.getTheatres();
    }

}
