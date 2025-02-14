import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Booking {
    Map<String, List<Movie>> LocationToMovieMap= new HashMap<>();
    String city;
    User user;
    public Booking(String city,Map<String,List<Movie>> LocationToMovieMap, User user) {
        this.city = city;
        this.LocationToMovieMap= LocationToMovieMap;
        this.user=user;
    }
    void book(){
        Scanner sc= new Scanner(System.in);
        List<Movie>ListOfMovies=LocationToMovieMap.get(city);
        System.out.println("Which Movie You want to watch ?? ");
        int i = 1;
        for(Movie movie:ListOfMovies){
            System.out.print(i + ". ");
            i++;
            movie.display();
        }int  movieChoice=sc.nextInt();
        System.out.println("Nice choicee!!!");
        System.out.println();
        Movie wantedMovie= ListOfMovies.get(movieChoice-1);
        System.out.println("Which show You want to watch ?? ");
        List<Show>ListOfShows=wantedMovie.shows;
        i=1;
        for(Show show:ListOfShows){
            System.out.print(i+" ");i++;
            System.out.println(show.startTime);
        }int userChoiceOfShow= sc.nextInt();
        System.out.println("Congratulations your show is booked for "+ ListOfShows.get(userChoiceOfShow-1).startTime+" \nEnjoy!!! The Movie");

        UserBooking userBooking= new UserBooking();
        userBooking.addBooking(wantedMovie.name,ListOfShows.get(userChoiceOfShow-1).startTime);
        user.listOfBookings.add(userBooking);

    }

}
