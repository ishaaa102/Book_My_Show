package com.Isha.bookMyShow.repo;

import com.Isha.bookMyShow.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.HashMap;
import java.util.Map;

public interface ReviewRepo extends MongoRepository<Review, String> {

}
