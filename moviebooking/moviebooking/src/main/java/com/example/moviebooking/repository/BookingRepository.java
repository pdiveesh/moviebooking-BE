package com.example.moviebooking.repository;

import com.example.moviebooking.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {

    List<Booking> findByMovieIdAndTheatreIdAndDateAndTime(String movieId, String theatreId, LocalDate date, LocalTime time);

    List<Booking> findBySeatIdsIn(List<String> seatIds);
}
