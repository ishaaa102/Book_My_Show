package com.Isha.bookMyShow.repo;

import com.Isha.bookMyShow.entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.HashMap;
import java.util.Map;

public interface MovieRepo extends MongoRepository<Movie, String> {

}
