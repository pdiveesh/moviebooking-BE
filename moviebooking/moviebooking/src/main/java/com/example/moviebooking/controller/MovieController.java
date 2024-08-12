package com.example.moviebooking.controller;

import com.example.moviebooking.model.Movie;
import com.example.moviebooking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable String id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        System.out.println("Adding movie with theatres: " + movie.getTheatreIds()); // Debug statement
        return movieService.addOrUpdateMovie(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable String id, @RequestBody Movie movie) {
        movie.setId(id);
        return movieService.addOrUpdateMovie(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable String id) {
        movieService.deleteMovie(id);
    }

    @GetMapping("/city/{cityName}")
    public List<Movie> getMoviesByCity(@PathVariable String cityName) {
        return movieService.getMoviesByCity(cityName);
    }

    @GetMapping("/theatre/{theatreName}")
    public List<Movie> getMoviesByTheatre(@PathVariable String theatreName) {
        return movieService.getMoviesByTheatre(theatreName);
    }


}
