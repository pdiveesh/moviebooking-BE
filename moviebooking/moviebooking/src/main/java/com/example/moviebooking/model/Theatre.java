package com.example.moviebooking.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = "theatres")
public class Theatre {
    @Id
    private String id;
    private String name;
    private String city;
    private double ticketPrice;
    private int seats;
    private String image;
    private Set<String> bookedSeats;

    public Set<String> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(Set<String> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
