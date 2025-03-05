package com.tekion.bookmyshow.model;

public class Seat {
    private int id; // pk
    private int screenId; // fk- screenTable
    private int categoryId;
    private int seatNumber;

    public Seat(int screenId, int categoryId, int seatNumber) {
        this.screenId = screenId;
        this.categoryId = categoryId;
        this.seatNumber = seatNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScreenId() {
        return screenId;
    }

    public int getId() {
        return id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
