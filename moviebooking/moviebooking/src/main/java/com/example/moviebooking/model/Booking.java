package com.example.moviebooking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Document(collection = "bookings")
public class Booking {

    @Id
    private String id;
    private String movieId;
    private String theatreId;
    private LocalDate date;
    private LocalTime time;
    private List<String> seatIds;
    private String userId; // Optional, for tracking the user who made the booking

    // Constructors
    public Booking() {}

    public Booking(String movieId, String theatreId, LocalDate date, LocalTime time, List<String> seatIds, String userId) {
        this.movieId = movieId;
        this.theatreId = theatreId;
        this.date = date;
        this.time = time;
        this.seatIds = seatIds;
        this.userId = userId;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMovieId() { return movieId; }
    public void setMovieId(String movieId) { this.movieId = movieId; }

    public String getTheatreId() { return theatreId; }
    public void setTheatreId(String theatreId) { this.theatreId = theatreId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }

    public List<String> getSeatIds() { return seatIds; }
    public void setSeatIds(List<String> seatIds) { this.seatIds = seatIds; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
}
