package com.Isha.bookMyShow.controllers;

import com.Isha.bookMyShow.entity.Theatre;
import com.Isha.bookMyShow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/theatre")
public class TheatreCustomerController {

    private final TheatreService theatreService;

    @Autowired
    public TheatreCustomerController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Theatre>> getAllTheatres() {
        return ResponseEntity.ok(theatreService.getAllTheatres());
    }

    @GetMapping("/viewById/{id}")
    public ResponseEntity<Theatre> getTheatreById(@PathVariable String id) {
        return ResponseEntity.ok(theatreService.getTheatreById(id));
    }
}


