package com.example.moviebooking.repository;

import com.example.moviebooking.model.Showtime;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ShowtimeRepository extends MongoRepository<Showtime, String> {

    List<Showtime> findByMovieIdAndTheatreId(String movieId, String theatreId);

    List<Showtime> findByMovieId(String movieId);

    List<Showtime> findByTheatreId(String theatreId);

    // No need to define findAll() as it is inherited from MongoRepository
}
