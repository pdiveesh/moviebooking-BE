package com.example.moviebooking.repository;

import com.example.moviebooking.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, String> {
    List<Movie> findByCityName(String cityName);
    List<Movie> findByTheatreIdsContains(String theatreId);
    List<Movie> findByTheatreIdsIn(List<String> theatreIds);
}
