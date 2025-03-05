package com.tekion.bookmyshow.model;

public class SeatBooking {
    private int id; // pk
    private int seatId; // fk - seatTable
    private int bookingId;

    public void setId(int id) {
        this.id = id;
    }

    public SeatBooking(int seatId, int bookingId) {
        this.seatId = seatId;
        this.bookingId = bookingId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getSeatId() {
        return seatId;
    }
}
