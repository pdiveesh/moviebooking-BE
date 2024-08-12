package com.example.moviebooking.service;

import com.example.moviebooking.model.Showtime;
import com.example.moviebooking.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    public List<Showtime> getShowtimesByMovieAndTheatre(String movieId, String theatreId) {
        return showtimeRepository.findByMovieIdAndTheatreId(movieId, theatreId);
    }

    public List<Showtime> getShowtimesByMovie(String movieId) {
        return showtimeRepository.findByMovieId(movieId);
    }

    public List<Showtime> getShowtimesByTheatre(String theatreId) {
        return showtimeRepository.findByTheatreId(theatreId);
    }

    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    public Showtime createShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    public void deleteShowtime(String id) {
        showtimeRepository.deleteById(id);
    }
}
