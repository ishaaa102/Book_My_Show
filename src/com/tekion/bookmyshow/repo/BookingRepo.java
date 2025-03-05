package com.tekion.bookmyshow.repo;

import com.tekion.bookmyshow.model.Booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingRepo {
    public static BookingRepo INSTANCE = new BookingRepo();
    private int id = 0;
    private Map<Integer, Booking> bookingMap = new HashMap<>();

    private BookingRepo() {
    }

    public Booking saveBooking(Booking booking) {
        id++;
        booking.setId(id);
        bookingMap.put(id, booking);

        return booking;
    }

    public Booking getBookingByBookingId(int bookingId){
        return bookingMap.get(bookingId);
    }

    public List<Booking> getBookingByShowId(int showId){
        List<Booking> bookingList = new ArrayList<>();
        for(Booking booking : bookingMap.values()){
            if(booking.getShowId()==showId){
                bookingList.add(booking);
            }
        }
        return bookingList;
    }
}
