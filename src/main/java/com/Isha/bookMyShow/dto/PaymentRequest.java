package com.Isha.bookMyShow.dto;

import com.Isha.bookMyShow.entity.PaymentMethod;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class PaymentRequest {
    private PaymentMethod payMethod;
    private int amount;
    private String time;
}
