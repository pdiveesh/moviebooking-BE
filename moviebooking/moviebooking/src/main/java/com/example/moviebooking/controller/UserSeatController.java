package com.example.moviebooking.controller;

import com.example.moviebooking.model.Seat;
import com.example.moviebooking.service.SeatService;
import com.example.moviebooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*") // Allow requests from any origin
public class UserSeatController {

    @Autowired
    private SeatService seatService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/seats")
    public ResponseEntity<List<Seat>> getAvailableSeats() {
        List<Seat> seats = seatService.getAllSeats();
        // Filter out booked seats
        List<Seat> availableSeats = seats.stream()
                .filter(seat -> !seat.isBooked())
                .collect(Collectors.toList());
        return ResponseEntity.ok(availableSeats);
    }

    @PostMapping("/bookSeats")
    public ResponseEntity<String> bookSeats(@RequestParam String user, @RequestBody List<String> seatIds) {
        List<Seat> seats = seatIds.stream().map(seatService::getSeatById).collect(Collectors.toList());

        if (seats.stream().anyMatch(seat -> seat == null || seat.isBooked())) {
            return ResponseEntity.badRequest().body("One or more seats are not available.");
        }

        seats.forEach(seat -> seat.setBooked(true));
        seats.forEach(seatService::updateSeat);

        // Ensure the createBooking method handles both parameters
        bookingService.createBooking(user, seatIds);

        return ResponseEntity.ok("Seats booked successfully.");
    }




}
