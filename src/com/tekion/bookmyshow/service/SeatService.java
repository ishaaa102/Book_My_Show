package com.tekion.bookmyshow.service;

import com.tekion.bookmyshow.model.Screen;
import com.tekion.bookmyshow.model.Seat;
import com.tekion.bookmyshow.repo.SeatRepo;

import java.util.List;

public class SeatService {
    public static SeatService INSTANCE = new SeatService();

    SeatRepo seatRepo;
    ScreenService screenService;
    SeatCategoryService seatCategoryService;

    private SeatService() {
        this.seatRepo = SeatRepo.INSTANCE;
        this.screenService = ScreenService.INSTANCE;
        this.seatCategoryService = SeatCategoryService.INSTANCE;
    }

    public Seat createSeat(int screenId, int categoryId) throws Exception {
        final Screen screen = screenService.getScreenById(screenId);
        if (screen == null) {
            throw new Exception("wrong screen id");
        }

        if(seatCategoryService.getSeatCategoryById(categoryId)==null){
            throw new Exception("invalid seat category id");
        }

        int seatCount = seatRepo.getTotalSeatByScreenId(screenId);
        if (seatCount > screen.getToatlSeats()) {
            throw new Exception("More seat than capacity");
        }
        Seat seat = new Seat(screenId, categoryId, seatCount + 1);
        seatRepo.saveSeat(seat);
        return seat;
    }

    public void removeSeatsByScreenId(int screenId){
        seatRepo.removeSeatByScreenId(screenId);
    }

    public Seat removeSeat(int seatId){
        return seatRepo.removeSeat(seatId);
    }

    public Seat getSeatBySeatId(int seatId){
        return seatRepo.getSeatBySeatId(seatId);
    }

    public List<Seat> getSeatsByScreenId(int screenId){
        return seatRepo.getSeatsByScreenId(screenId);
    }



}
