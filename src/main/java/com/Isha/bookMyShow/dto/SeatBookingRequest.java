package com.Isha.bookMyShow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SeatBookingRequest {
    private String seatId; // fk - seatTable
    private String bookingId;
}
