package com.Isha.bookMyShow.repo;

import com.Isha.bookMyShow.entity.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.HashMap;
import java.util.Map;

public interface PaymentRepo extends MongoRepository<Payment, String> {

}
