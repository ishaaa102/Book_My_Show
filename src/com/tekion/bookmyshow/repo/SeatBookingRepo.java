package com.tekion.bookmyshow.repo;

import com.tekion.bookmyshow.model.SeatBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatBookingRepo {
    public static final SeatBookingRepo INSTANCE= new SeatBookingRepo();
    private int id=0;
    private Map<Integer, SeatBooking> seatBookingMap = new HashMap<>();

    private SeatBookingRepo() {
    }

    public SeatBooking saveSeatBooking(SeatBooking seatBooking){
        id++;
        seatBooking.setId(id);
        seatBookingMap.put(id, seatBooking);
        return seatBooking;
    }

    public List<SeatBooking> getSeatBookingByBookingId(int bookingId){
        List<SeatBooking> seatBookingList= new ArrayList<>();
        for(SeatBooking seatBooking: seatBookingMap.values()){
            if(seatBooking.getBookingId()==bookingId){
                seatBookingList.add(seatBooking);
            }
        }
        return seatBookingList;
    }


}
