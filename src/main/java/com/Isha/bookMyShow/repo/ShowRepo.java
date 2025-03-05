package com.Isha.bookMyShow.repo;

import com.Isha.bookMyShow.entity.Show;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepo extends MongoRepository<Show, String> {
    // Method to find all shows by screen ID
    List<Show> findByScreenId(String screenId);
}
