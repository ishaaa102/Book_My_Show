package com.Isha.bookMyShow.controllers;

import com.Isha.bookMyShow.dto.SeatRequest;
import com.Isha.bookMyShow.entity.Seat;
import com.Isha.bookMyShow.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/seat")
public class SeatAdminController {

    private final SeatService seatService;

    @Autowired
    public SeatAdminController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping("/create")
    public ResponseEntity<Seat> createSeat(@RequestBody SeatRequest seatRequest) throws Exception {
        return ResponseEntity.ok(seatService.createSeat(seatRequest));
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Seat>> getAllSeats() {
        return ResponseEntity.ok(seatService.getAllSeats());
    }

    @GetMapping("/viewById/{id}")
    public ResponseEntity<Seat> getTSeaById(@PathVariable String id) {
        return ResponseEntity.ok(seatService.getSeatById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Seat> updateSeat(@PathVariable String id, @RequestBody SeatRequest seatRequest) {
        return ResponseEntity.ok(seatService.updateSeat(id, seatRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSeat(@PathVariable String id) {
        Seat deletedSeat = seatService.getSeatById(id);

        if (deletedSeat == null) {
            return ResponseEntity.status(404).body("Seat not found");
        }

        seatService.removeSeat(id);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("id", deletedSeat.getId());
        response.put("screenId", deletedSeat.getScreenId());
        response.put("categoryId", deletedSeat.getCategoryId());
        response.put("seatNumber", deletedSeat.getSeatNumber());

        return ResponseEntity.ok(response);
    }
}


