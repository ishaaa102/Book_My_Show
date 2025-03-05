package com.Isha.bookMyShow.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class SeatRequest {
    String screenId;
    String categoryId;
    int seatNumber;
}
