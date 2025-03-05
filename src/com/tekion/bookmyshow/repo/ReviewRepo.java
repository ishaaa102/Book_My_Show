package com.tekion.bookmyshow.repo;

import com.tekion.bookmyshow.model.Review;

import java.util.HashMap;
import java.util.Map;

public class ReviewRepo {
    public static ReviewRepo INSTANCE = new ReviewRepo();
    private int id = 0;
    private Map<Integer, Review> reviewMap = new HashMap<>();

    private ReviewRepo() {
    }

    public Review saveReview(Review review) {
        id++;
        review.setId(id);
        reviewMap.put(id, review);
        return review;
    }
}
