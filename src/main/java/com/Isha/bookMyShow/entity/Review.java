package com.Isha.bookMyShow.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Review")
public class Review {

    @Id
    private String id; //pk
    private String movieId; // fk -> movietable
    private String comment;
    private int rating;

    public Review() {
    }

    private Review(Builder builder) {
        this.id=builder.id;
        this.movieId = builder.movieId;
        this.comment = builder.comment;
        this.rating = builder.rating;
    }

    public static class Builder {
        private String id; //pk
        private String movieId; // fk -> movietable
        private String comment;
        private int rating;

        public Builder id(String id){
            this.id=id;
            return this;
        }

        public Builder movieId(String movieId){
            this.movieId=movieId;
            return this;
        }

        public Builder comment(String comment){
            this.comment=comment;
            return this;
        }

        public Builder rating(int rating){
            this.rating=rating;
            return this;
        }

        public Review build(){
            return new Review(this);
        }
    }

    public static Builder builder(){
        return new Builder();
    }
}
