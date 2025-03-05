package com.tekion.bookmyshow.model;

public class Show {
    private int id; // pk
    private int movieId; // fk - movieTable
    private int screenId; // fk - screenTable
    private String startTime;

    public Show(int movieId, int screenId, String startTime) {
        this.movieId = movieId;
        this.screenId = screenId;
        this.startTime = startTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScreenId() {
        return screenId;
    }

    public int getMovieId() {
        return movieId;
    }

    public String toString(){
        return "Show{movieId="+movieId+", screenId="+screenId+", show time='"+startTime+"'}";
    }
}
