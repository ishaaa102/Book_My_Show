package com.Isha.bookMyShow.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class ScreenRequest {
    private String theatreId;
    private String name;
    private int totalSeats;
}
