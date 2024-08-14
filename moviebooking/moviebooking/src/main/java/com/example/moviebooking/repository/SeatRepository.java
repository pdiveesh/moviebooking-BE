package com.example.moviebooking.repository;

import com.example.moviebooking.model.Seat;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface SeatRepository extends MongoRepository<Seat, String> {
    List<Seat> findByMovieIdAndTheatreId(String movieId, String theatreId);
}
