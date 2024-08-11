package com.example.moviebooking.service;

import com.example.moviebooking.model.Seat;
import com.example.moviebooking.model.SeatConfig;
import com.example.moviebooking.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public void clearSeats() {
        seatRepository.deleteAll();
    }

    public void addSeats(List<SeatConfig> seatConfigs) {
        for (SeatConfig config : seatConfigs) {
            for (int i = 1; i <= config.getSeats(); i++) {
                Seat seat = new Seat(config.getRow(), i);
                seatRepository.save(seat);
            }
        }
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seat getSeatById(String id) {
        return seatRepository.findById(id).orElse(null);
    }

    public void updateSeat(Seat seat) {
        seatRepository.save(seat);
    }
}
