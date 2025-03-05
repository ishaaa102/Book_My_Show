package com.Isha.bookMyShow.repo;

import com.Isha.bookMyShow.entity.SeatCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.HashMap;
import java.util.Map;

public interface SeatCategoryRepo extends MongoRepository<SeatCategory, String> {
    void deleteById(String id);
}
