package com.example.moviebooking.service;

import com.example.moviebooking.model.Booking;
import com.example.moviebooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(String movieId, String theatreId, LocalDate date, LocalTime time, List<String> seatIds, String userId) {
        Booking booking = new Booking(movieId, theatreId, date, time, seatIds, userId);
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookings(String movieId, String theatreId, LocalDate date, LocalTime time) {
        return bookingRepository.findByMovieIdAndTheatreIdAndDateAndTime(movieId, theatreId, date, time);
    }

    public List<Booking> getBookingsBySeats(List<String> seatIds) {
        return bookingRepository.findBySeatIdsIn(seatIds);
    }
}
