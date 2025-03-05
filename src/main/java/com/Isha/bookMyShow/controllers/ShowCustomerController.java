package com.Isha.bookMyShow.controllers;

import com.Isha.bookMyShow.dto.ShowRequest;
import com.Isha.bookMyShow.entity.Show;
import com.Isha.bookMyShow.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/show")
public class ShowCustomerController {

    private final ShowService showService;

    @Autowired
    public ShowCustomerController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/getAll")
    public List<Show> getAllShows(){
        return showService.getAllShows();
    }

    @GetMapping("/getById/{id}")
    public Show getShowById(@PathVariable String id){
        return showService.getShowById(id);
    }

}
