package com.example.moviebooking.repository;

import com.example.moviebooking.model.Seat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeatRepository extends MongoRepository<Seat, String> {
    // Additional query methods if needed
}
