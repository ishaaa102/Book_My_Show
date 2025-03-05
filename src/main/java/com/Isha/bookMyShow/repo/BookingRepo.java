package com.Isha.bookMyShow.repo;

import com.Isha.bookMyShow.entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface BookingRepo extends MongoRepository<Booking, String> {

    List<Booking> findByShowId(String showId);
    Booking findByPaymentId(String paymentId);
}
