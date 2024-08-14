package com.example.moviebooking.repository;

import com.example.moviebooking.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {
    List<Booking> findByMovieIdAndTheatreIdAndShowTime(String movieId, String theatreId, String showTime);
    List<Booking> findByUserId(String userId);
}
