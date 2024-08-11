package com.example.moviebooking.repository;

import com.example.moviebooking.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
    // Additional query methods if needed
}
