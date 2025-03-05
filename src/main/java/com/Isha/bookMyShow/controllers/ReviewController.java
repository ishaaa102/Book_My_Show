package com.Isha.bookMyShow.controllers;

import com.Isha.bookMyShow.dto.ReviewRequest;
import com.Isha.bookMyShow.dto.ScreenRequest;
import com.Isha.bookMyShow.entity.Review;
import com.Isha.bookMyShow.entity.Screen;
import com.Isha.bookMyShow.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody ReviewRequest reviewRequest) throws Exception {
        Review review = reviewService.createReview(reviewRequest);
        return ResponseEntity.ok(review);
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Review>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @GetMapping("/viewById/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable String id) {
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable String id, @RequestBody ReviewRequest reviewRequest) {
        return ResponseEntity.ok(reviewService.updateReview(id,reviewRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable String id) {
        Review deletedReview = reviewService.getReviewById(id);

        if (deletedReview == null) {
            return ResponseEntity.status(404).body("Screen not found");
        }

        reviewService.deleteReview(id);

        return ResponseEntity.ok(deletedReview);
    }
}
