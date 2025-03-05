package com.Isha.bookMyShow.service;

import com.Isha.bookMyShow.dto.UserRequest;
import com.Isha.bookMyShow.entity.User;
import com.Isha.bookMyShow.entity.UserType;
import com.Isha.bookMyShow.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(UserRequest userRequest){
        User user= User.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .type(userRequest.getType())
                .build();

        return userRepo.save(user);
    }

    public User getUserByUsername(String userName) {
        try {
            return userRepo.findByUsername(userName);
        } catch (Exception e) {
            throw new RuntimeException("Error in fetching the user with username: " + userName, e);
        }
    }

}
