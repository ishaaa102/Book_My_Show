package com.tekion.bookmyshow.repo;

import com.tekion.bookmyshow.model.Show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowRepo {
    public static ShowRepo INSTANCE = new ShowRepo();
    private int id = 0;
    private Map<Integer, Show> showMap = new HashMap<>();

    public ShowRepo() {
    }

    public Show saveShow(Show show) {
        id++;
        show.setId(id);
        showMap.put(id, show);
        return show;

    }

    public Show removeShow(int showId){
        return showMap.remove(showId);
    }

    public Show getShow(int showId) {
        return showMap.get(showId);
    }

    public List<Show> getShowsByScreenId(int screenId){
        List<Show> showList = new ArrayList<>();
        for(Show show : showMap.values()){
            if(show.getScreenId()==screenId){
                showList.add(show);
            }
        }
        return showList;
    }
}
