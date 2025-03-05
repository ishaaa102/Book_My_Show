package com.Isha.bookMyShow.dto;

import com.Isha.bookMyShow.entity.PaymentStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class BookingRequest {
    private String payId;
    private String showId;
}
