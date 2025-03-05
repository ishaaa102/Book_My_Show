package com.Isha.bookMyShow.service;

import com.Isha.bookMyShow.dto.SeatRequest;
import com.Isha.bookMyShow.entity.Screen;
import com.Isha.bookMyShow.entity.Seat;
import com.Isha.bookMyShow.entity.Show;
import com.Isha.bookMyShow.repo.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    private final SeatRepo seatRepo;
    private final ScreenService screenService;
    private final SeatCategoryService seatCategoryService;

    @Autowired
    public SeatService(SeatRepo seatRepo, ScreenService screenService, SeatCategoryService seatCategoryService) {
        this.seatRepo = seatRepo;
        this.screenService = screenService;
        this.seatCategoryService = seatCategoryService;
    }

    public Seat createSeat(SeatRequest seatRequest) throws Exception {

        Screen screen = screenService.getScreenById(seatRequest.getScreenId());
        if (screen == null) {
            throw new Exception("wrong screen id");
        }

        if(seatCategoryService.getSeatCategoryById(seatRequest.getCategoryId())==null){
            throw new Exception("invalid seat category id");
        }

        int seatCount = seatRepo.countByScreenId(seatRequest.getScreenId());
        if (seatCount == screen.getTotalSeats()) {
            throw new Exception("More seats than capacity");
        }

//        Seat seat= new Seat(screenId, categoryId, seatCount + 1);

        Seat seat = Seat.builder()
                .screenId(seatRequest.getScreenId())
                .categoryId(seatRequest.getCategoryId())
                .seatNumber(seatRequest.getSeatNumber())
                .build();
        return seatRepo.save(seat);
    }

    public List<Seat> getAllSeats(){
        return seatRepo.findAll();
    }

    public Seat getSeatById(String id){
        return seatRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat not found with id "+ id));
    }

    public List<Seat> getSeatsByScreenId(String screenId) {
        return seatRepo.findByScreenId(screenId);
    }

    public Seat updateSeat(String id, SeatRequest seatRequest){
        Seat seat= getSeatById(id);

        Seat updatedSeat= Seat.builder()
                .id(seat.getId())
                .screenId(seatRequest.getScreenId())
                .categoryId(seatRequest.getCategoryId())
                .seatNumber(seatRequest.getSeatNumber())
                .build();

        return seatRepo.save(updatedSeat);
    }

    public Seat removeSeat(String seatId) {

        Seat deletedSeat = getSeatById(seatId);
        seatRepo.deleteById(seatId);
        return deletedSeat;
    }

    public void removeSeatsByScreenId(String screenId) {
        seatRepo.deleteByScreenId(screenId);
    }
}
