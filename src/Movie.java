import java.util.ArrayList;
import java.util.List;

public class Movie {
    String name;
    int duration;
    ArrayList<Show> shows;

    Movie(){

    }
    public Movie(String name, int duration, ArrayList<Show> shows) {
        this.name = name;

        this.duration = duration;
        this.shows = shows;
    }


    void display() {
        System.out.print( name   + " Duration: " + duration + " min) → Shows: ");
        for (Show show : shows) {
            System.out.print(show.startTime + "  " );
        }
        System.out.println();
    }
}
