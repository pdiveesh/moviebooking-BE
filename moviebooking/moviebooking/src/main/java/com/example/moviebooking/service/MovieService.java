package com.example.moviebooking.service;

import com.example.moviebooking.model.Movie;
import com.example.moviebooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(String id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie addOrUpdateMovie(Movie movie) {
        System.out.println("Saving movie: " + movie); // Debug statement
        return movieRepository.save(movie);
    }

    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> getMoviesByCity(String cityName) {
        return movieRepository.findByCityName(cityName);
    }

    public List<Movie> getMoviesByTheatre(String theatreId) {
        return movieRepository.findByTheatreIdsContains(theatreId);
    }
}
