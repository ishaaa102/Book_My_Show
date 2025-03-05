package com.Isha.bookMyShow.repo;

import com.Isha.bookMyShow.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashboardRepo extends MongoRepository<User, String> {
}




