package com.Isha.bookMyShow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequest {
    private String id; //pk
    private String movieId; // fk -> movietable
    private String comment;
    private int rating;
}
