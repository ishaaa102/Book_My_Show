package com.Isha.bookMyShow.dto;

import com.Isha.bookMyShow.entity.PaymentStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Getter
@Setter
public class BookingRequest {
    private String payId;
    private String showId;
    private Set<String> seatIds;
}
