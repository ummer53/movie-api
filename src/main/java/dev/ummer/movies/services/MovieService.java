package dev.ummer.movies.services;

import dev.ummer.movies.models.Movie;
import dev.ummer.movies.repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> AllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(ObjectId id) {  //optional because it can return null
       return movieRepository.findById(id);
    }

    public Optional<Movie> singleMovieByImdbId(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
