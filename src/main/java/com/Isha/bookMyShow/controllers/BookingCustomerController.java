package com.Isha.bookMyShow.controllers;

import com.Isha.bookMyShow.dto.BookingRequest;
import com.Isha.bookMyShow.entity.Booking;
import com.Isha.bookMyShow.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingCustomerController {
    private final BookingService bookingService;

    @Autowired
    public BookingCustomerController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest bookingRequest) throws Exception {
        return ResponseEntity.ok(bookingService.createBooking(bookingRequest));
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Booking>> getAllBookings(){
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/viewById/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable String id){
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    // ToDo- cancel booking

}
