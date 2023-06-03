package dev.ummer.movies.services;

import dev.ummer.movies.models.Movie;
import dev.ummer.movies.models.Review;
import dev.ummer.movies.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody)); // create review and returns the review object

        mongoTemplate.update(Movie.class)
                .matching((Criteria.where("imdbId").is(imdbId)))  //wherere clausee
                .apply(new Update().push("reviewId").value(review))//Update clause
                .first();   // updates the first match

        return review;
    }
}
