package com.Isha.bookMyShow.repo;

import com.Isha.bookMyShow.entity.Seat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepo extends MongoRepository<Seat, String> {

    // Find all seats by screen ID
    List<Seat> findByScreenId(String screenId);

    // Delete all seats by screen ID
    void deleteByScreenId(String screenId);

    // Count the total number of seats by screen ID
    int countByScreenId(String screenId);
}
