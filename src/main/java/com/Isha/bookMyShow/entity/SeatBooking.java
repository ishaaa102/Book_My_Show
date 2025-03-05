package com.Isha.bookMyShow.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "SeatBooking")
public class SeatBooking {

    @Id
    private String id; // pk
    private String seatId; // fk - seatTable
    private String bookingId;

    public SeatBooking() {
    }

    private SeatBooking(Builder builder) {
        this.id=builder.id;
        this.seatId = builder.seatId;
        this.bookingId = builder.bookingId;
    }

    public static class Builder{
        private String id; // pk
        private String seatId; // fk - seatTable
        private String bookingId;

        public Builder id(String id){
            this.id=id;
            return this;
        }

        public Builder seatId(String seatId){
            this.seatId=seatId;
            return this;
        }

        public Builder bookingId(String bookingId){
            this.bookingId=bookingId;
            return this;
        }

        public SeatBooking build(){
            return new SeatBooking(this);
        }
    }

    public static Builder builder(){
        return new Builder();
    }
}
