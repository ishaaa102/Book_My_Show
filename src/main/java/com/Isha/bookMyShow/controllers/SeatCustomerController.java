package com.Isha.bookMyShow.controllers;

import com.Isha.bookMyShow.dto.SeatRequest;
import com.Isha.bookMyShow.entity.Seat;
import com.Isha.bookMyShow.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/seat")
public class SeatCustomerController {

    private final SeatService seatService;

    @Autowired
    public SeatCustomerController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Seat>> getAllSeats() {
        return ResponseEntity.ok(seatService.getAllSeats());
    }

    @GetMapping("/viewById/{id}")
    public ResponseEntity<Seat> getTSeaById(@PathVariable String id) {
        return ResponseEntity.ok(seatService.getSeatById(id));
    }
}
