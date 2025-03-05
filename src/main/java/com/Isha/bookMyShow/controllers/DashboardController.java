package com.Isha.bookMyShow.controllers;

import com.Isha.bookMyShow.dto.UserRequest;
import com.Isha.bookMyShow.entity.UserType;
import com.Isha.bookMyShow.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @PostMapping("/signin")
    public UserType signIn(@RequestBody UserRequest userRequest) throws Exception {
        return dashboardService.signIn(userRequest);
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody UserRequest userRequest) throws Exception {
        dashboardService.signUp(userRequest);
    }
}
