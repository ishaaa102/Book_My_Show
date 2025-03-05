package com.tekion.bookmyshow.model;

public class Booking {
    private int id; //pk
    private int paymentId; // fk -> paymentTable
    private int showId;
    private BookingStatus status;

    public Booking(int payId, int showId, PaymentStatus paymentStatus) {
        this.paymentId = payId;
        this.showId = showId;
        book(paymentStatus);
    }

    private void book(PaymentStatus paymentStatus) {
        if (paymentStatus == PaymentStatus.SUCCESS) {
            this.status = BookingStatus.CONFIRMED;
        } else {
            this.status = BookingStatus.PENDING;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShowId() {
        return showId;
    }

    public int getId() {
        return id;
    }

    public BookingStatus getStatus() {
        return status;
    }

    /*
 show id  -> bookings -> seats [ booked seats ] -> seatsNumber
 */
}
