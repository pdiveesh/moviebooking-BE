package com.example.moviebooking.repository;

import com.example.moviebooking.model.Showtime;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends MongoRepository<Showtime, String> {
}
