package com.Isha.bookMyShow.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class ShowRequest {
    private String movieId;
    private String screenId;
    private String startTime;
}
