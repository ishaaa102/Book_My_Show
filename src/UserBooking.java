import java.util.ArrayList;
import java.util.HashMap;
import  java.util.List;
import java.util.Map;

public class UserBooking {
//    String name;
    Map<String,List<String>> userBooking= new HashMap<>();
    public void addBooking(String movieName, String time) {
        userBooking.putIfAbsent(movieName, new ArrayList<>());

        userBooking.get(movieName).add(time);

        System.out.println("Booking confirmed for " + movieName + " at " + time);
        System.out.println();
    }

    public void showBookings() {
        if (userBooking.isEmpty()) {
            System.out.println("No bookings found!");
            return;
        }

        for (Map.Entry<String, List<String>> entry : userBooking.entrySet()) {
            System.out.println( entry.getKey() + " → " + entry.getValue());
        }
    }

}
