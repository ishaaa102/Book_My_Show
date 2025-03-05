package com.tekion.bookmyshow.model;

public class Screen {
    private int id;// pk
    private int theareId;// fk - theatre table
    private String name;
    private int toatlSeats;

    public Screen(int theareId, String screenName, int noOfSeats) {
        this.theareId = theareId;
        this.name = screenName;
        this.toatlSeats = noOfSeats;
    }

    public int getTheareId() {
        return theareId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getToatlSeats() {
        return toatlSeats;
    }
}
