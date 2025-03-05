package com.Isha.bookMyShow.service;

import com.Isha.bookMyShow.dto.SeatCategoryRequest;
import com.Isha.bookMyShow.entity.SeatCategory;
import com.Isha.bookMyShow.repo.SeatCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatCategoryService {

    private final SeatCategoryRepo seatCategoryRepo;

    @Autowired
    public SeatCategoryService(SeatCategoryRepo seatCategoryRepo) {
        this.seatCategoryRepo = seatCategoryRepo;
    }

    public SeatCategory createCategory(SeatCategoryRequest seatCategoryRequest) {
        SeatCategory seatCategory = SeatCategory.builder()
                .price(seatCategoryRequest.getPrice())
                .build();
        return seatCategoryRepo.save(seatCategory);
    }

    public List<SeatCategory> getAllSeatCategory(){
        return seatCategoryRepo.findAll();
    }

    public SeatCategory getSeatCategoryById(String categoryId) {
        return seatCategoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Seat category not found with id "+ categoryId));
    }

    public SeatCategory updateSeatCategory(String categoryId, SeatCategoryRequest seatCategoryRequest){
        SeatCategory seatCategory= getSeatCategoryById(categoryId);

        SeatCategory updatedSeatCategory= SeatCategory.builder()
                .id(seatCategory.getId())
                .price(seatCategoryRequest.getPrice())
                .build();

        return seatCategoryRepo.save(updatedSeatCategory);
    }

    public void deleteSeatCategory(String categoryId){
         seatCategoryRepo.deleteById(categoryId);
    }

}

