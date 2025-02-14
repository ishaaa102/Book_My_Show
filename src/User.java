import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    String password;
    List<UserBooking> listOfBookings = new ArrayList<>();

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.listOfBookings = new ArrayList<>(); // bookings list
    }

    public void addBooking(UserBooking booking) {
        listOfBookings.add(booking);
    }
    public void showBooking(){
        for( UserBooking userbooking:listOfBookings){
            userbooking.showBookings();
        }
    }
}
