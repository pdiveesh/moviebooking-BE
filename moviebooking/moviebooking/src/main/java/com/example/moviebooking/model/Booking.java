package com.example.moviebooking.model;



import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.List;

@Document(collection = "bookings")
public class Booking {
    @Id
    private String id;
    private String user;
    private List<String> seatIds;

    public Booking() {}

    public Booking(String user, List<String> seatIds) {
        this.user = user;
        this.seatIds = seatIds;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<String> getSeatIds() {
        return seatIds;
    }

    public void setSeatIds(List<String> seatIds) {
        this.seatIds = seatIds;
    }
}
