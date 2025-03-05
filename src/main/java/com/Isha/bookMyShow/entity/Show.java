package com.Isha.bookMyShow.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Show")
public class Show {

    @Id
    private String id; // pk
    private String movieId; // fk - movieTable
    private String screenId; // fk - screenTable
    private String startTime;

    public Show() {
    }

    private Show(Builder builder) {
        this.id=builder.id;
        this.movieId = builder.movieId;
        this.screenId = builder.screenId;
        this.startTime = builder.startTime;
    }

    public static class Builder{
        private String id; // pk
        private String movieId; // fk - movieTable
        private String screenId; // fk - screenTable
        private String startTime;

        public Builder id(String id){
            this.id=id;
            return this;
        }

        public Builder movieId(String movieId){
            this.movieId=movieId;
            return this;
        }

        public Builder screenId(String screenId){
            this.screenId=screenId;
            return this;
        }

        public Builder startTime(String startTime){
            this.startTime=startTime;
            return this;
        }

        public Show build(){
            return new Show(this);
        }
    }

    public static Builder builder(){
        return new Builder();
    }

    public String toString(){
        return "Show{movieId="+movieId+", screenId="+screenId+", show time='"+startTime+"'}";
    }
}
