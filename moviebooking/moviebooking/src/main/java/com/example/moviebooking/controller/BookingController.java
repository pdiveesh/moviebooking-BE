package com.example.moviebooking.controller;

import com.example.moviebooking.model.Booking;
import com.example.moviebooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<Booking> bookSeats(@RequestBody BookingRequest request) {
        Booking booking = bookingService.createBooking(
                request.getMovieId(),
                request.getTheatreId(),
                request.getDate(),
                request.getTime(),
                request.getSeats(),
                request.getUserId()
        );
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/by-movie-theatre")
    public ResponseEntity<List<Booking>> getBookings(
            @RequestParam String movieId,
            @RequestParam String theatreId,
            @RequestParam String date,
            @RequestParam String time) {
        LocalDate localDate = LocalDate.parse(date);
        LocalTime localTime = LocalTime.parse(time);
        List<Booking> bookings = bookingService.getBookings(movieId, theatreId, localDate, localTime);
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/by-seats")
    public ResponseEntity<List<Booking>> getBookingsBySeats(@RequestParam List<String> seatIds) {
        List<Booking> bookings = bookingService.getBookingsBySeats(seatIds);
        return ResponseEntity.ok(bookings);
    }
}
