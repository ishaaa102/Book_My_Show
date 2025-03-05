package com.tekion.bookmyshow.service;

import com.tekion.bookmyshow.model.User;
import com.tekion.bookmyshow.model.UserType;
import com.tekion.bookmyshow.repo.UserRepo;

public class UserService {
    public static UserService INSTANCE = new UserService();
    UserRepo userRepo;

    private UserService() {
        userRepo = UserRepo.INSTANCE;
    }

    public void validateUser(String userName, String password, UserType type) throws Exception {
        User user = userRepo.getUserByUsername(userName);
        if(user.getPassword().equals(password) && user.getType()==type){
            return;
        }
            throw new Exception("Invalid user name or passwords");
    }


}
