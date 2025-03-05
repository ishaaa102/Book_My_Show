package com.Isha.bookMyShow.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Movie")
public class Movie {

    @Id
    private String id;// pk
    private String duration;
    private String name;
    private String description;
    private GenreType genreType;
    private String directorName;

    // todo - we can have average rating


    public Movie() {
    }

    private Movie(Builder builder) {
        this.id=builder.id;
        this.duration = builder.duration;
        this.name = builder.name;
        this.description = builder.description;
        this.genreType = builder.genreType;
        this.directorName = builder.directorName;
    }

    public static class Builder{
        private String id;// pk
        private String duration;
        private String name;
        private String description;
        private GenreType genreType;
        private String directorName;

        public Builder id(String id){
            this.id=id;
            return this;
        }

        public Builder duration(String duration){
            this.duration=duration;
            return this;
        }

        public Builder name(String name){
            this.name=name;
            return this;
        }

        public Builder description(String description){
            this.description=description;
            return this;
        }

        public Builder genreType(GenreType genreType){
            this.genreType=genreType;
            return this;
        }

        public Builder directorName(String directorName){
            this.directorName=directorName;
            return this;
        }

        public Movie build(){
            return new Movie(this);
        }
    }

    public static Builder builder(){
        return new Builder();
    }

    public String toString(){
        return "Movie{duration="+duration+", name='"+name+"', genreType='"+genreType+"', directorName='"+directorName+"'}";
    }
}
