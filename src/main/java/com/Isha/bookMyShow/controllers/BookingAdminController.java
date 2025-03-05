package com.Isha.bookMyShow.controllers;

import com.Isha.bookMyShow.entity.Booking;
import com.Isha.bookMyShow.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingAdminController {
    private final BookingService bookingService;

    @Autowired
    public BookingAdminController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Booking>> getAllBookings(){
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/viewById/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable String id){
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

}
