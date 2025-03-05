package com.tekion.bookmyshow.repo;

import com.tekion.bookmyshow.model.Screen;

import java.util.*;

public class ScreenRepo {
    public static ScreenRepo INSTANCE = new ScreenRepo();
    private int id = 0;
    private Map<Integer, Screen> screenMap = new HashMap<>();

    private ScreenRepo() {
    }

    public Screen saveScreen(Screen screen) {
        id++;
        screen.setId(id);
        screenMap.put(id, screen);
        return screen;
    }

    public Screen removeScreen(int screenId) {
        return screenMap.remove(screenId);
    }

    public Screen getScreen(int screenId) {
        return screenMap.get(screenId);
    }

    public List<Screen> removeScreenByTheatreId(int theatreId) {
        List<Screen> screenToRemove = new ArrayList<>();
        for (Screen screen : screenMap.values()) {
            if (screen.getTheareId() == theatreId) {
                screenToRemove.add(screen);
            }
        }
        screenToRemove.forEach(screen -> screenMap.remove(screen.getId()));
        return screenToRemove;
    }

    public List<Screen> getScreenByTheatreId(int theatreId){
        List<Screen> listOfScreens = new ArrayList<>();
        for(Screen screen: screenMap.values()){
            if(screen.getTheareId()== theatreId){
                listOfScreens.add(screen);
            }
        }
        return listOfScreens;
    }
}
