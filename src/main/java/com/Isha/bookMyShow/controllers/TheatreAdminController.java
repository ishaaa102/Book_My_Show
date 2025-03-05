package com.Isha.bookMyShow.controllers;

import com.Isha.bookMyShow.dto.TheatreRequest;
import com.Isha.bookMyShow.entity.Theatre;
import com.Isha.bookMyShow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/theatre")
public class TheatreAdminController {

    private final TheatreService theatreService;

    @Autowired
    public TheatreAdminController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping("/create")
    public ResponseEntity<Theatre> createTheatre(@RequestBody TheatreRequest theatreRequest) {
        Theatre theatre = theatreService.createTheatre(theatreRequest);
        return ResponseEntity.ok(theatre);
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Theatre>> getAllTheatres() {
        return ResponseEntity.ok(theatreService.getAllTheatres());
    }

    @GetMapping("/viewById/{id}")
    public ResponseEntity<Theatre> getTheatreById(@PathVariable String id) {
        return ResponseEntity.ok(theatreService.getTheatreById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Theatre> updateTheatre(@PathVariable String id, @RequestBody TheatreRequest theatreRequest) {
        return ResponseEntity.ok(theatreService.updateTheatre(id, theatreRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTheatre(@PathVariable String id) {
        Theatre deletedTheatre = theatreService.getTheatreById(id); // Fetch theatre details before deletion

        if (deletedTheatre == null) {
            return ResponseEntity.status(404).body("Theatre not found");
        }

        theatreService.deleteTheatre(id); // Perform deletion

        // Create a response object with required details
        // Use LinkedHashMap to maintain insertion order
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("id", deletedTheatre.getId());
        response.put("name", deletedTheatre.getName());
        response.put("address", deletedTheatre.getAddress());

        return ResponseEntity.ok(response);
    }

}
