package com.Isha.bookMyShow.service;

import com.Isha.bookMyShow.dto.UserRequest;
import com.Isha.bookMyShow.entity.User;
import com.Isha.bookMyShow.entity.UserType;
import com.Isha.bookMyShow.repo.DashboardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final UserService userService;
    private final DashboardRepo dashboardRepo;

    @Autowired
    public DashboardService(UserService userService, DashboardRepo dashboardRepo) {
        this.userService = userService;
        this.dashboardRepo = dashboardRepo;
    }

    public UserType signIn(UserRequest userRequest) throws Exception {
        User user = userService.getUserByUsername(userRequest.getUsername());
        if (user != null && user.getPassword().equals(userRequest.getPassword())) {
            return user.getType();
        }
        throw new Exception("Invalid username or password");
    }

    public void signUp(UserRequest userRequest) throws Exception {
        if(userService.getUserByUsername(userRequest.getUsername())!=null){
            throw new Exception("this username already exists");
        }

        User newUser = userService.createUser(userRequest);
    }

}
