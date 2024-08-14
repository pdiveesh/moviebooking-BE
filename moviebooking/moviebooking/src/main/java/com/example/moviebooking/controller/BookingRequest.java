package com.example.moviebooking.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class BookingRequest {
    private String movieId;
    private String theatreId;
    private LocalDate date;
    private LocalTime time;
    private List<String> seats;
    private String userId;

    // Getters and Setters
    public String getMovieId() { return movieId; }
    public void setMovieId(String movieId) { this.movieId = movieId; }

    public String getTheatreId() { return theatreId; }
    public void setTheatreId(String theatreId) { this.theatreId = theatreId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }

    public List<String> getSeats() { return seats; }
    public void setSeats(List<String> seats) { this.seats = seats; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
}
