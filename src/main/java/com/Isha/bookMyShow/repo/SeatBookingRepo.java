package com.Isha.bookMyShow.repo;

import com.Isha.bookMyShow.entity.SeatBooking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SeatBookingRepo extends MongoRepository<SeatBooking, String> {

}
