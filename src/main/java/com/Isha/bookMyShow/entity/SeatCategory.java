package com.Isha.bookMyShow.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "SeatCategory")
public class SeatCategory {

    @Id
    private String id; //pk
    private int price;

    public SeatCategory() {
    }

    private SeatCategory(Builder builder) {
        this.id=builder.id;
        this.price = builder.price;
    }

    public static class Builder{
        private String id; //pk
        private int price;

        public Builder id(String id){
            this.id=id;
            return this;
        }

        public Builder price(int price){
            this.price=price;
            return this;
        }

        public SeatCategory build(){
            return new SeatCategory(this);
        }
    }

    public static Builder builder(){
        return new Builder();
    }

}