package dev.ummer.movies.repositories;

import dev.ummer.movies.models.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    @Query()
    Optional<Movie> findMovieByImdbId(String imdbId);
}
