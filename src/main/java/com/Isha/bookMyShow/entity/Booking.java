package com.Isha.bookMyShow.entity;

import com.Isha.bookMyShow.dto.BookingRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Booking")
public class Booking {
    @Id
    private String id; //pk
    private String paymentId; // fk -> paymentTable
    private String showId;
    private BookingStatus status;

    public Booking() {
    }

    private Booking(Builder builder) {
        this.id=builder.id;
        this.paymentId = builder.paymentId;
        this.showId = builder.showId;
        book(builder.paymentStatus);
//        book(paymentStatus);
    }

    public static class Builder{
        private String id; //pk
        private String paymentId; // fk -> paymentTable
        private String showId;
        private PaymentStatus paymentStatus;

        public Builder id(String id){
            this.id=id;
            return this;
        }

        public Builder paymentId(String paymentId){
            this.paymentId=paymentId;
            return this;
        }

        public Builder showId(String showId){
            this.showId=showId;
            return this;
        }

        public Builder paymentStatus(PaymentStatus paymentStatus){
            this.paymentStatus=paymentStatus;
            return this;
        }

        public Booking build(){
            return new Booking(this);
        }
    }

    public static Builder builder(){
        return new Builder();
    }

    private void book(PaymentStatus paymentStatus) {
        if (paymentStatus == PaymentStatus.SUCCESS) {
            this.status = BookingStatus.CONFIRMED;
        } else {
            this.status = BookingStatus.PENDING;
        }
    }

    /*
 show id  -> bookings -> seats [ booked seats ] -> seatsNumber
 */
}
