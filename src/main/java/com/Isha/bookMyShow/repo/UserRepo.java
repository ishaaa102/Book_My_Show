package com.Isha.bookMyShow.repo;

import com.Isha.bookMyShow.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
    User findByUsername(String username);
}




//    public static UserRepo INSTANCE= new UserRepo();
//    private final Map<String, User> userMap = new HashMap<>();
//
//    private UserRepo() {
//        addUserToMap();
//    }
//
//    public void addUserToMap(){
//        userMap.put("isha", new User("isha", "123", UserType.ADMIN));
//        userMap.put("mahin", new User("mahin", "123", UserType.ADMIN));
//        userMap.put("rupesh", new User("rupesh", "123", UserType.CUSTOMER));
//        userMap.put("deep", new User("deep", "123", UserType.CUSTOMER));
//        userMap.put("tushar", new User("tushar", "123", UserType.CUSTOMER));
//    }
//
//    public User getUserByUsername(String userName){
//        return userMap.get(userName);
//    }
//}
