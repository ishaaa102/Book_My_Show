package com.tekion.bookmyshow.repo;

import com.tekion.bookmyshow.model.SeatCategory;

import java.util.HashMap;
import java.util.Map;

public class SeatCategoryRepo {
    public static SeatCategoryRepo INSTANCE = new SeatCategoryRepo();
    private Map<Integer, SeatCategory> seatCategoryMap = new HashMap<>();
    private int id = 0;

    private SeatCategoryRepo() {
    }

    public SeatCategory saveSeat(SeatCategory category) {
        id++;
        category.setId(id);
        seatCategoryMap.put(id, category);
        return category;
    }

    public SeatCategory getSeatCategory(int categoryId) {
        return seatCategoryMap.get(categoryId);
    }
}
