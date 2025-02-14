import java.util.*;

public class Dashboard {
    String name;
    Map<String, List<Movie>> LocationToMovieMap = new HashMap<>();
    User user;
    Dashboard(String name,User user,Map<String, List<Movie>> LocationToMovieMap) {
        this.name = name;
        this.user=user;
        this.LocationToMovieMap=LocationToMovieMap;
    }

    void show() {
        System.out.println("Welcome to your Dashboard, " + name + "!");
     System.out.println("Choose a city where you want to watch movies !");

        for (String city : LocationToMovieMap.keySet()) {
            System.out.println(" " + city);
            List<Movie> movies = LocationToMovieMap.get(city);
            int i = 1;
            for (Movie movie : movies) {
                System.out.print(i + ". ");
                movie.display();
                i++;
            }
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the city of your choice: ");
        String city = sc.nextLine().toLowerCase();

        if (!LocationToMovieMap.containsKey(city)) {
            System.out.println("Invalid city choice. Please try again.");
            return;
        }

        Booking booking = new Booking(city, LocationToMovieMap,user);
        booking.book();
    }
}

