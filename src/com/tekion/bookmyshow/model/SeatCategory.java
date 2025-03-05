package com.tekion.bookmyshow.model;

// todo - this can be enum
public class SeatCategory {
    private int id; //pk
    private int price;

    public SeatCategory(int price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }
}
