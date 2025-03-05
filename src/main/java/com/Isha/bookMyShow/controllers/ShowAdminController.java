package com.Isha.bookMyShow.controllers;

import com.Isha.bookMyShow.dto.ShowRequest;
import com.Isha.bookMyShow.entity.Show;
import com.Isha.bookMyShow.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/show")
public class ShowAdminController {

    private final ShowService showService;

    @Autowired
    public ShowAdminController(ShowService showService) {
        this.showService = showService;
    }

    @PostMapping("/create")
    public ResponseEntity<Show> createShow(@RequestBody ShowRequest showRequest) throws Exception {
        return ResponseEntity.ok(showService.createShow(showRequest));
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Show>> getALLShows(){
        return ResponseEntity.ok(showService.getAllShows());
    }

    @GetMapping("/viewById/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable String id){
        return ResponseEntity.ok(showService.getShowById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable String id, @RequestBody ShowRequest showRequest){
        return ResponseEntity.ok(showService.updateShow(id, showRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteShow(@PathVariable String id){
        Show show = showService.deleteShow(id);
        if(show==null){
            return ResponseEntity.status(404).body("show not found");
        }

        return ResponseEntity.ok(show);
    }
}

