package com.example.moviebooking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "seat")
public class Seat {
    @Id
    private String id;
    private String seatNumber;  // Added seatNumber field
    private String movieId;
    private String theatreId;
    private double price;
    private String status;

    // Constructors, getters, and setters
    public Seat() {}

    public Seat(String seatNumber, String movieId, String theatreId, double price, String status) {
        this.seatNumber = seatNumber;
        this.movieId = movieId;
        this.theatreId = theatreId;
        this.price = price;
        this.status = status;
    }

    // Getter and setter for seatNumber
    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
