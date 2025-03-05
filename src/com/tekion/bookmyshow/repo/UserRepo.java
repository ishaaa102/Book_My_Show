package com.tekion.bookmyshow.repo;

import com.tekion.bookmyshow.model.User;
import com.tekion.bookmyshow.model.UserType;

import java.util.HashMap;
import java.util.Map;

public class UserRepo {
    public static UserRepo INSTANCE= new UserRepo();
    private final Map<String, User> userMap = new HashMap<>();

    private UserRepo() {
        addUserToMap();
    }

    public void addUserToMap(){
        userMap.put("isha", new User("isha", "123", UserType.ADMIN));
        userMap.put("mahin", new User("mahin", "123", UserType.ADMIN));
        userMap.put("rupesh", new User("rupesh", "123", UserType.CUSTOMER));
        userMap.put("deep", new User("deep", "123", UserType.CUSTOMER));
        userMap.put("tushar", new User("tushar", "123", UserType.CUSTOMER));
    }

    public User getUserByUsername(String userName){
        return userMap.get(userName);
    }
}
