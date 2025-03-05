package com.tekion.bookmyshow.repo;

import com.tekion.bookmyshow.model.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TheatreRepo {
    public static final TheatreRepo INSTANCE = new TheatreRepo();
    private int id = 0;
    private Map<Integer, Theatre> theatreMap = new HashMap<>();

    private TheatreRepo() {
    }

    public Theatre saveTheatre(Theatre theatre) {
        id = id + 1;
        theatre.setId(id);
        theatreMap.put(id, theatre);
        return theatre;
    }

    public Theatre removeTheatre(int theatreId){
        return theatreMap.remove(theatreId);
    }

    public Theatre getTheatre(int theatreId) {
        return theatreMap.get(theatreId);
    }

    public List<Theatre> getTheatres(){
        List<Theatre> theatres=new ArrayList<>();
        for(Theatre theatre:theatreMap.values()){
            theatres.add(theatre);
        }
        return theatres;
    }
}
