package com.tekion.bookmyshow.service;

import com.tekion.bookmyshow.model.SeatCategory;
import com.tekion.bookmyshow.repo.SeatCategoryRepo;

public class SeatCategoryService {
    public static SeatCategoryService INSTANCE = new SeatCategoryService();

    SeatCategoryRepo seatCategoryRepo;

    private SeatCategoryService() {
        this.seatCategoryRepo = SeatCategoryRepo.INSTANCE;
    }

    public SeatCategory createCategory(int price) {
        SeatCategory seatCategory = new SeatCategory(price);
        seatCategoryRepo.saveSeat(seatCategory);
        return seatCategory;
    }

    public SeatCategory getSeatCategoryById(int categoryId) {
        return seatCategoryRepo.getSeatCategory(categoryId);
    }
}
