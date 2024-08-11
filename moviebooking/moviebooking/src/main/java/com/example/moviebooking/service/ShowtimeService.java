package com.example.moviebooking.service;

import com.example.moviebooking.model.Showtime;
import com.example.moviebooking.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    public Optional<Showtime> getShowtimeById(String id) {
        return showtimeRepository.findById(id);
    }

    public Showtime addShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    public Showtime updateShowtime(String id, Showtime showtimeDetails) {
        Showtime showtime = showtimeRepository.findById(id).orElseThrow(() -> new RuntimeException("Showtime not found"));
        showtime.setTicketPrice(showtimeDetails.getTicketPrice());
        showtime.setStartDate(showtimeDetails.getStartDate());
        showtime.setEndDate(showtimeDetails.getEndDate());
        showtime.setMovieId(showtimeDetails.getMovieId());
        showtime.setTheatreId(showtimeDetails.getTheatreId());
        return showtimeRepository.save(showtime);
    }

    public void deleteShowtime(String id) {
        showtimeRepository.deleteById(id);
    }
}
