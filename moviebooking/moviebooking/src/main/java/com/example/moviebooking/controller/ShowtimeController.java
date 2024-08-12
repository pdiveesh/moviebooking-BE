package com.example.moviebooking.controller;

import com.example.moviebooking.model.Showtime;
import com.example.moviebooking.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/showtimes")
public class ShowtimeController {

    @Autowired
    private ShowtimeService showtimeService;

    @GetMapping

    public List<Showtime> getShowtimesByMovieAndTheatre(
            @RequestParam(value = "movieId", required = false) String movieId,
            @RequestParam(value = "theatreId", required = false) String theatreId) {
        if (movieId != null && theatreId != null) {
            // Fetch showtimes by both movieId and theatreId
            return showtimeService.getShowtimesByMovieAndTheatre(movieId, theatreId);
        } else if (movieId != null) {
            // Fetch showtimes by movieId only
            return showtimeService.getShowtimesByMovie(movieId);
        } else if (theatreId != null) {
            // Fetch showtimes by theatreId only
            return showtimeService.getShowtimesByTheatre(theatreId);
        } else {
            // Fetch all showtimes
            return showtimeService.getAllShowtimes(); // Ensure this method is implemented in your service
        }
    }


    @GetMapping("/all")
    public List<Showtime> getAllShowtimes() {
        return showtimeService.getAllShowtimes();
    }
    @PostMapping
    public Showtime createShowtime(@RequestBody Showtime showtime) {
        return showtimeService.createShowtime(showtime);
    }

    @DeleteMapping("/{id}")
    public void deleteShowtime(@PathVariable String id) {
        showtimeService.deleteShowtime(id);
    }
}
