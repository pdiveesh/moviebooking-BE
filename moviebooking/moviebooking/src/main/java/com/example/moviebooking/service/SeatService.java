package com.example.moviebooking.service;

import com.example.moviebooking.controller.BookingRequest;
import com.example.moviebooking.model.Seat;
import com.example.moviebooking.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public Seat addSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public List<Seat> getSeats() {
        return seatRepository.findAll();
    }

    public Optional<Seat> getSeatById(String seatId) {
        return seatRepository.findById(seatId);
    }

    public Seat updateSeatPrice(String seatId, double newPrice) {
        Optional<Seat> seatOptional = seatRepository.findById(seatId);
        if (seatOptional.isPresent()) {
            Seat seat = seatOptional.get();
            seat.setPrice(newPrice);
            return seatRepository.save(seat);
        }
        return null;
    }

    public void deleteSeat(String seatId) {
        seatRepository.deleteById(seatId);
    }

    public List<Seat> getSeatsByMovieAndTheatre(String movieId, String theatreId) {
        return seatRepository.findByMovieIdAndTheatreId(movieId, theatreId);
    }



    @Transactional
    public boolean bookSeats(BookingRequest bookingRequest) {
        // Check if seats are available
        List<Seat> seats = seatRepository.findByMovieIdAndTheatreId(bookingRequest.getMovieId(), bookingRequest.getTheatreId());

        if (seats == null || seats.isEmpty()) {
            return false; // No seats found
        }

        Set<String> requestedSeats = new HashSet<>(bookingRequest.getSeats());
        List<Seat> seatsToBook = new ArrayList<>();
        boolean allAvailable = true;

        for (Seat seat : seats) {
            if (requestedSeats.contains(seat.getSeatNumber())) {
                if ("BOOKED".equals(seat.getStatus())) {
                    allAvailable = false;
                    break;
                } else {
                    seat.setStatus("BOOKED");
                    seatsToBook.add(seat);
                }
            }
        }

        if (!allAvailable) {
            return false; // Some seats were already booked
        }

        seatRepository.saveAll(seatsToBook);
        return true;
    }
}
