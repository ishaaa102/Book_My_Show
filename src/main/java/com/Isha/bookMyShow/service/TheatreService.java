package com.Isha.bookMyShow.service;

import com.Isha.bookMyShow.dto.TheatreRequest;
import com.Isha.bookMyShow.entity.Review;
import com.Isha.bookMyShow.entity.Screen;
import com.Isha.bookMyShow.entity.Theatre;
import com.Isha.bookMyShow.repo.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    private final TheatreRepo theatreRepo;
    private final ScreenService screenService;

    @Autowired
    public TheatreService(TheatreRepo theatreRepo, ScreenService screenService) {
        this.theatreRepo = theatreRepo;
        this.screenService = screenService;
    }

    // Create a theatre using TheatreRequest
    public Theatre createTheatre(TheatreRequest theatreRequest) {
        Theatre theatre = Theatre.builder()
                .name(theatreRequest.getName())
                .address(theatreRequest.getAddress())
                .build();
        return theatreRepo.save(theatre);
    }

    public List<Theatre> getAllTheatres() {
        return theatreRepo.findAll();
    }

    // Get a theatre by ID
    public Theatre getTheatreById(String theatreId) {
        return theatreRepo.findById(theatreId)
                .orElseThrow(() -> new RuntimeException("Theatre not found with ID: " + theatreId));
    }

    // Update a theatre using TheatreRequest
    public Theatre updateTheatre(String theatreId, TheatreRequest theatreRequest) {
        Theatre theatre = getTheatreById(theatreId);

        Theatre updatedTheatre = Theatre.builder()
                .id(theatre.getId())
                .name(theatreRequest.getName())
                .address(theatreRequest.getAddress())
                .build();

        return theatreRepo.save(updatedTheatre);
    }

    // Delete a theatre (removes associated screens)
    public Theatre deleteTheatre(String theatreId) {
        List<Screen> screens = screenService.getScreenByTheatreId(theatreId);
        screens.forEach(screen -> screenService.removeScreen(screen.getId()));

        Theatre deletedTheatre = getTheatreById(theatreId);
        theatreRepo.deleteById(theatreId);
        return deletedTheatre;
    }

    public List<Theatre> getTheatres() {
        return theatreRepo.findAll();
    }
}
