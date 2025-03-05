package com.tekion.bookmyshow.model;

public class Movie {
    private int id;// pk
    private String duration;
    private String name;
    private String description;
    private GenreType genreType;
    private String directorName;

    // todo - we can have average rating

    public Movie(String name, String duration, String description, GenreType genreType, String directorName) {
        this.duration = duration;
        this.name = name;
        this.description = description;
        this.genreType = genreType;
        this.directorName = directorName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return "Movie{duration="+duration+", name='"+name+"', genreType='"+genreType+"', directorName='"+directorName+"'}";
    }
}
