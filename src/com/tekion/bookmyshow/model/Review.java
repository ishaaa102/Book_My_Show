package com.tekion.bookmyshow.model;

public class Review {
    private int id; //pk
    private int movieId; // fk -> movietable
    private String comment;
    private int rating;

    public Review(int movieId, String comment, int rating) {
        this.movieId = movieId;
        this.comment = comment;
        this.rating = rating;
    }

    public void setId(int id) {
        this.id = id;
    }
}
