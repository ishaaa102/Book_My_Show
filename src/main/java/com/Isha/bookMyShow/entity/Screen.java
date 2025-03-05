package com.Isha.bookMyShow.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Screen")
public class Screen {

    @Id
    private String id;// pk
    private String theatreId;// fk - theatre table
    private String name;
    private int totalSeats;

    public Screen() {
    }

    private Screen(Builder builder) {
        this.id=builder.id;
        this.theatreId = builder.theatreId;
        this.name = builder.name;
        this.totalSeats = builder.totalSeats;
    }

    public static class Builder{
        private String id;// pk
        private String theatreId;// fk - theatre table
        private String name;
        private int totalSeats;

        public Builder id(String id){
            this.id=id;
            return this;
        }

        public Builder theatreId(String theatreId){
            this.theatreId=theatreId;
            return this;
        }

        public Builder screenName(String name){
            this.name=name;
            return this;
        }

        public Builder totalSeats(int totalSeats){
            this.totalSeats=totalSeats;
            return this;
        }

        public Screen build(){
            return new Screen(this);
        }
    }

    public static Builder builder(){
        return new Builder();
    }
}

