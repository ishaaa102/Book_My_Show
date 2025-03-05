package com.Isha.bookMyShow.service;

import com.Isha.bookMyShow.dto.SeatBookingRequest;
import com.Isha.bookMyShow.entity.SeatBooking;
import com.Isha.bookMyShow.repo.SeatBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SeatBookingService {

    private final SeatService seatService;
    private final BookingService bookingService;
    private final SeatBookingRepo seatBookingRepo;

    @Autowired
    public SeatBookingService(SeatService seatService, BookingService bookingService, SeatBookingRepo seatBookingRepo) {
        this.seatService = seatService;
        this.bookingService = bookingService;
        this.seatBookingRepo = seatBookingRepo;
    }

    public SeatBooking createSeatBooking(SeatBookingRequest seatBookingRequest) throws Exception {
        if (seatService.getSeatById(seatBookingRequest.getSeatId()) == null) {
            throw new Exception("Invalid seat ID");
        }
        if (bookingService.getBookingById(seatBookingRequest.getBookingId()) == null) {
            throw new Exception("Invalid booking ID");
        }

//        new SeatBooking(seatId, bookingId);
        
        SeatBooking seatBooking = SeatBooking.builder()
                .seatId(seatBookingRequest.getSeatId())
                .bookingId(seatBookingRequest.getBookingId())
                .build();
        
        return seatBookingRepo.save(seatBooking);
    }
    
    public List<SeatBooking> getAllSeatBooking(){
        return seatBookingRepo.findAll();
    }

    public SeatBooking getBySeatBookingId(String id){
        return seatBookingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("seat booking not found by id "+id));
    }

    public List<SeatBooking> getAllSeatBookingByBookingId(String bookingId) {
        return seatBookingRepo.findAllById(Collections.singleton(bookingId));
    }


}
