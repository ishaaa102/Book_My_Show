package com.tekion.bookmyshow.service;

import com.tekion.bookmyshow.model.Review;
import com.tekion.bookmyshow.repo.ReviewRepo;

public class ReviewService {
    public static ReviewService INSTANCE = new ReviewService();

    ReviewRepo reviewRepo;
    MovieService movieService;

    private ReviewService() {
        this.reviewRepo = ReviewRepo.INSTANCE;
        this.movieService = MovieService.INSTANCE;
    }

    public Review createReview(int movieId, String comment, int rating) throws Exception {
        if (movieService.getMovieById(movieId) == null) {
            throw new Exception("invalid movie id");
        }

        if (rating < 0 || rating > 10) {
            throw new Exception("invalid rating");
        }
        Review review = new Review(movieId, comment, rating);
        reviewRepo.saveReview(review);
        return review;
    }
}
