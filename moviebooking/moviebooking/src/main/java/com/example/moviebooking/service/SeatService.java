package com.example.moviebooking.service;

import com.example.moviebooking.model.Seat;
import com.example.moviebooking.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
