package com.Isha.bookMyShow.repo;

import com.Isha.bookMyShow.entity.Theatre;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface TheatreRepo extends MongoRepository<Theatre, String> {
    void deleteById(String id);
}
