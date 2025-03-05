package com.Isha.bookMyShow.controllers;

import com.Isha.bookMyShow.dto.ScreenRequest;
import com.Isha.bookMyShow.entity.Screen;
import com.Isha.bookMyShow.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/screen")
public class ScreenCustomerController {

    private final ScreenService screenService;

    @Autowired
    public ScreenCustomerController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Screen>> getAllScreens() {
        return ResponseEntity.ok(screenService.getAllScreens());
    }

    @GetMapping("/viewById/{id}")
    public ResponseEntity<Screen> getScreenById(@PathVariable String id) {
        return ResponseEntity.ok(screenService.getScreenById(id));
    }

}
