package com.tekion.bookmyshow.service;

import com.tekion.bookmyshow.model.SeatBooking;
import com.tekion.bookmyshow.repo.SeatBookingRepo;

import java.util.List;

public class SeatBookingService {
    public static final SeatBookingService INSTANCE= new SeatBookingService();

    private SeatService seatService;
    private BookingService bookingService;
    private SeatBookingRepo seatBookingRepo;

    private SeatBookingService() {
        seatService=SeatService.INSTANCE;
        bookingService=BookingService.INSTANCE;
        seatBookingRepo=SeatBookingRepo.INSTANCE;
    }

    public SeatBooking createSeatBooking(int seatId, int bookingId) throws Exception {
        if(seatService.getSeatBySeatId(seatId)==null) {
            throw new Exception("Invalid seat id");
        }
        if(bookingService.getBookingByBookingId(bookingId)==null){
            throw new Exception("Invalid booking id");
        }
        SeatBooking seatBooking = new SeatBooking(seatId, bookingId);
        return seatBookingRepo.saveSeatBooking(seatBooking);
    }

    public List<SeatBooking> getSeatBookingByBookingId(int bookingId){
        return seatBookingRepo.getSeatBookingByBookingId(bookingId);
    }

}
