package com.Isha.bookMyShow.service;

import com.Isha.bookMyShow.dto.ReviewRequest;
import com.Isha.bookMyShow.entity.Review;
import com.Isha.bookMyShow.entity.Show;
import com.Isha.bookMyShow.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepo reviewRepo;
    private final MovieService movieService;

    @Autowired
    public ReviewService(ReviewRepo reviewRepo, MovieService movieService) {
        this.reviewRepo = reviewRepo;
        this.movieService = movieService;
    }

    public Review createReview(ReviewRequest reviewRequest) throws Exception {
        if (movieService.getMovieById(reviewRequest.getMovieId()) == null) {
            throw new Exception("Invalid movie ID");
        }

        if (reviewRequest.getRating() < 0 || reviewRequest.getRating() > 10) {
            throw new Exception("Invalid rating. Must be between 0 and 10.");
        }

        // new Review(movieId, comment, rating);
        Review review = Review.builder()
                .movieId(reviewRequest.getMovieId())
                .comment(reviewRequest.getComment())
                .rating(reviewRequest.getRating())
                .build();
        return reviewRepo.save(review);
    }

    public List<Review> getAllReviews(){
        return reviewRepo.findAll();
    }

    public Review getReviewById(String id){
        return reviewRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("review not found of id "+id));
    }

    public Review updateReview(String id, ReviewRequest reviewRequest){
        Review review = getReviewById(id);

        Review updatedReview= Review.builder()
                .id(review.getId())
                .movieId(reviewRequest.getMovieId())
                .comment(reviewRequest.getComment())
                .rating(reviewRequest.getRating())
                .build();

        return reviewRepo.save(updatedReview);
    }

    public Review deleteReview(String id){

        Review deletedReview = getReviewById(id);
        reviewRepo.deleteById(id);
        return deletedReview;
    }

}
