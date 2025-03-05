package com.Isha.bookMyShow.repo;

import com.Isha.bookMyShow.entity.Screen;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ScreenRepo extends MongoRepository<Screen, String> {
    List<Screen> findByTheatreId(String theatreId);
    void deleteByTheatreId(String theatreId);

}
