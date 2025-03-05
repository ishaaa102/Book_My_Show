package com.Isha.bookMyShow.controllers;

import com.Isha.bookMyShow.dto.SeatCategoryRequest;
import com.Isha.bookMyShow.dto.TheatreRequest;
import com.Isha.bookMyShow.entity.SeatCategory;
import com.Isha.bookMyShow.entity.Theatre;
import com.Isha.bookMyShow.service.SeatCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/seatCategory")
public class SeatCategoryAdminController {

    private final SeatCategoryService seatCategoryService;

    @Autowired
    public SeatCategoryAdminController(SeatCategoryService seatCategoryService) {
        this.seatCategoryService = seatCategoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<SeatCategory> createSeatCategory(@RequestBody SeatCategoryRequest seatCategoryRequest){
        return ResponseEntity.ok(seatCategoryService.createCategory(seatCategoryRequest));
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<SeatCategory>> getAllSeatCategories() {
        return ResponseEntity.ok(seatCategoryService.getAllSeatCategory());
    }

    @GetMapping("/viewById/{id}")
    public ResponseEntity<SeatCategory> getTSeatCategoryById(@PathVariable String id) {
        return ResponseEntity.ok(seatCategoryService.getSeatCategoryById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SeatCategory> updateSeatCategory(@PathVariable String id, @RequestBody SeatCategoryRequest seatCategoryRequest) {
        return ResponseEntity.ok(seatCategoryService.updateSeatCategory(id, seatCategoryRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSeatCategory(@PathVariable String id) {
        SeatCategory deletedSeatCategory = seatCategoryService.getSeatCategoryById(id);

        if (deletedSeatCategory == null) {
            return ResponseEntity.status(404).body("Seat category not found");
        }

        seatCategoryService.deleteSeatCategory(id);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("id", deletedSeatCategory.getId());
        response.put("price", deletedSeatCategory.getPrice());

        return ResponseEntity.ok(response);
    }


}

