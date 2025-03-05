package com.tekion.bookmyshow.repo;

import com.tekion.bookmyshow.model.Seat;

import java.util.*;

public class SeatRepo {
    public static SeatRepo INSTANCE = new SeatRepo();
    private int id = 0;
    private Map<Integer, Seat> seatMap = new HashMap<>();

    private SeatRepo() {

    }

    public Seat saveSeat(Seat seat) {
        id++;
        seat.setId(id);
        seatMap.put(id, seat);
        return seat;
    }

    public int getTotalSeatByScreenId(int screenId) {
        return (int) seatMap.values().stream().filter(seat -> seat.getScreenId() == screenId).count();
    }

    public List<Seat> removeSeatByScreenId(int screenId){
        List<Seat> seatToRemove = new ArrayList<>();
        for(Seat seat: seatMap.values()){
            if(seat.getScreenId()==screenId){
                seatToRemove.add(seat);
            }
        }
        for (Seat seat:seatToRemove){
            seatMap.remove(seat.getId());
        }
//        seatToRemove.forEach(seat -> seatMap.remove(seat.getId()));
        return seatToRemove;
    }

    public Seat removeSeat(int seatId){
        return seatMap.remove(seatId);
    }

    public Seat getSeatBySeatId(int seatId){
        return seatMap.get(seatId);
    }

    public List<Seat> getSeatsByScreenId(int screenId){
        List<Seat> seatList = new ArrayList<>();
        for(Seat seat: seatMap.values()){
            if(seat.getScreenId()==screenId){
                seatList.add(seat);
            }
        }
        return seatList;
    }


}
