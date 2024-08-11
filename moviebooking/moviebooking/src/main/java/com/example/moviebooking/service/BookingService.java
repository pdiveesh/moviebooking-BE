package com.example.moviebooking.service;

import com.example.moviebooking.model.Booking;
import com.example.moviebooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(String user, List<String> seatIds) {
        Booking booking = new Booking(user, seatIds);
        return bookingRepository.save(booking);
    }
}
