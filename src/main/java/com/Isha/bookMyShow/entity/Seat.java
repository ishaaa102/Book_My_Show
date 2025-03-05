package com.Isha.bookMyShow.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Seat")
public class Seat {

    @Id
    private String id; // pk
    private String screenId; // fk- screenTable
    private String categoryId;
    private int seatNumber;

    public Seat() {
    }

    private Seat(Builder builder) {
        this.id=builder.id;
        this.screenId = builder.screenId;
        this.categoryId = builder.categoryId;
        this.seatNumber = builder.seatNumber;
    }

    public static class Builder{
        private String id; // pk
        private String screenId; // fk- screenTable
        private String categoryId;
        private int seatNumber;

        public Builder id(String id){
            this.id=id;
            return this;
        }

        public Builder screenId(String screenId){
            this.screenId=screenId;
            return this;
        }

        public Builder categoryId(String categoryId){
            this.categoryId=categoryId;
            return this;
        }

        public Builder seatNumber(int seatNumber){
            this.seatNumber=seatNumber;
            return this;
        }

        public Seat  build(){
            return new Seat(this);
        }
    }

    public static Builder builder(){
        return new Builder();
    }
}

