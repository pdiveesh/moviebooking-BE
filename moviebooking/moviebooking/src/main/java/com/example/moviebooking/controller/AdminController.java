package com.example.moviebooking.controller;

import com.example.moviebooking.model.Seat;
import com.example.moviebooking.model.SeatConfig;
import com.example.moviebooking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")// Allow specific origin
public class AdminController {

    @Autowired
    private SeatService seatService;

    @PostMapping("/setSeats")
    public ResponseEntity<String> setSeats(@RequestBody List<SeatConfig> seatConfig) {
        seatService.clearSeats(); // Optionally clear existing seats
        seatService.addSeats(seatConfig);
        return ResponseEntity.ok("Seats added successfully");
    }

    @GetMapping("/seats")
    public ResponseEntity<List<Seat>> getSeats() {
        List<Seat> seats = seatService.getAllSeats();
        return ResponseEntity.ok(seats);
    }
}
