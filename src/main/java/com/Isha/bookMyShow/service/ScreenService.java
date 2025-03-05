package com.Isha.bookMyShow.service;

import com.Isha.bookMyShow.dto.ScreenRequest;
import com.Isha.bookMyShow.entity.Screen;
import com.Isha.bookMyShow.entity.Theatre;
import com.Isha.bookMyShow.repo.ScreenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenService {

    private final TheatreService theatreService;
    private final ScreenRepo screenRepo;
    private final SeatService seatService;

    @Autowired
    public ScreenService(@Lazy TheatreService theatreService, ScreenRepo screenRepo, @Lazy SeatService seatService) {
        this.theatreService = theatreService;
        this.screenRepo = screenRepo;
        this.seatService=seatService;
    }


    public Screen createScreen(ScreenRequest screenRequest) throws Exception {
        // Fetch theatre entity
        Theatre theatre = theatreService.getTheatreById(screenRequest.getTheatreId());

        // Check if theatre exists
        if (theatre == null) {
            throw new Exception("Invalid theatre ID: " + screenRequest.getTheatreId());
        }

        // Create and save screen
        // new Screen(theatre.getId(), screenName, noOfSeats);
        Screen screen = Screen.builder()
                .theatreId(theatre.getId())
                .screenName(screenRequest.getName())
                .totalSeats(screenRequest.getTotalSeats())
                .build();
        return screenRepo.save(screen);
    }

    public List<Screen> getAllScreens(){
        return screenRepo.findAll();
    }

    public Screen getScreenById(String id){
        return screenRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("screen not found by id "+id));
    }

    public List<Screen> getScreenByTheatreId(String theatreId) {
        return screenRepo.findByTheatreId(theatreId);
    }

    public Screen updateScreen(String id, ScreenRequest screenRequest){
        Screen screen = getScreenById(id);

        Screen updatedScreen= Screen.builder()
                .id(screen.getId())
                .theatreId(screenRequest.getTheatreId())
                .screenName(screenRequest.getName())
                .totalSeats(screenRequest.getTotalSeats())
                .build();

        return screenRepo.save(updatedScreen);
    }

    public void removeScreen(String screenId) {
        seatService.removeSeatsByScreenId(screenId);
        screenRepo.deleteById(screenId);
    }




}
