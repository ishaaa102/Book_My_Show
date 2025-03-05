package com.Isha.bookMyShow.controllers;

import com.Isha.bookMyShow.entity.SeatCategory;
import com.Isha.bookMyShow.service.SeatCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer/seatCategory")
public class SeatCategoryCustomerController {

    private final SeatCategoryService seatCategoryService;

    @Autowired
    public SeatCategoryCustomerController(SeatCategoryService seatCategoryService) {
        this.seatCategoryService = seatCategoryService;
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<SeatCategory>> getAllSeatCategories() {
        return ResponseEntity.ok(seatCategoryService.getAllSeatCategory());
    }

    @GetMapping("/viewById/{id}")
    public ResponseEntity<SeatCategory> getTSeatCategoryById(@PathVariable String id) {
        return ResponseEntity.ok(seatCategoryService.getSeatCategoryById(id));
    }
}
