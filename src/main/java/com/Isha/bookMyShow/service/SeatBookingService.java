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

    private final SeatBookingRepo seatBookingRepo;

    @Autowired
    public SeatBookingService( SeatBookingRepo seatBookingRepo) {
        this.seatBookingRepo = seatBookingRepo;
    }

    public SeatBooking createSeatBooking(String seatId,String bookingId) throws Exception {


//        new SeatBooking(seatId, bookingId);
        
        SeatBooking seatBooking = SeatBooking.builder()
                .seatId(seatId)
                .bookingId(bookingId)
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
