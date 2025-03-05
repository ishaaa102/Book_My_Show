package com.Isha.bookMyShow.controllers;

import com.Isha.bookMyShow.dto.ScreenRequest;
import com.Isha.bookMyShow.dto.TheatreRequest;
import com.Isha.bookMyShow.entity.Screen;
import com.Isha.bookMyShow.entity.Theatre;
import com.Isha.bookMyShow.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/screen")
public class ScreenAdminController {

    private final ScreenService screenService;

    @Autowired
    public ScreenAdminController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @PostMapping("/create")
    public ResponseEntity<Screen> createScreen(@RequestBody ScreenRequest screenRequest) throws Exception {
        Screen screen = screenService.createScreen(screenRequest);
        return ResponseEntity.ok(screen);
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Screen>> getAllScreens() {
        return ResponseEntity.ok(screenService.getAllScreens());
    }

    @GetMapping("/viewById/{id}")
    public ResponseEntity<Screen> getScreenById(@PathVariable String id) {
        return ResponseEntity.ok(screenService.getScreenById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Screen> updateScreen(@PathVariable String id, @RequestBody ScreenRequest screenRequest) {
        return ResponseEntity.ok(screenService.updateScreen(id, screenRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteScreen(@PathVariable String id) {
        Screen deletedScreen = screenService.getScreenById(id);

        if (deletedScreen == null) {
            return ResponseEntity.status(404).body("Screen not found");
        }

        screenService.removeScreen(id);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("id", deletedScreen.getId());
        response.put("theatreId", deletedScreen.getTheatreId());
        response.put("name", deletedScreen.getName());
        response.put("totalSeats", deletedScreen.getTotalSeats());

        return ResponseEntity.ok(response);
    }


}

