package com.example.moviebooking.service;

import com.example.moviebooking.model.Movie;
import com.example.moviebooking.model.Theatre;
import com.example.moviebooking.repository.TheatreRepository;
import com.example.moviebooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private MovieRepository movieRepository;

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public Optional<Theatre> getTheatreById(String id) {
        return theatreRepository.findById(id);
    }

    public List<Theatre> getTheatresByCity(String cityName) {
        return theatreRepository.findByCity(cityName);
    }


    public List<Theatre> findTheatresByCityAndMovieId(String cityName, String movieId) {
        // Fetch the movie by ID
        Optional<Movie> movie = movieRepository.findById(movieId);

        if (!movie.isPresent() || !movie.get().getCityName().equals(cityName)) {
            return List.of(); // Return an empty list if no movie is found or city mismatch
        }

        // Fetch theatres based on movie's theatre IDs
        List<String> theatreIds = movie.get().getTheatreIds();
        System.out.println("Theatre IDs from movie: " + theatreIds);

        List<Theatre> theatres = theatreRepository.findAllById(theatreIds);
        System.out.println("Theatres fetched from repository: " + theatres);

        // Filter theatres by city
        List<Theatre> filteredTheatres = theatres.stream()
                .filter(theatre -> theatre.getCity().trim().equalsIgnoreCase(cityName.trim()))
                .collect(Collectors.toList());

        System.out.println("Filtered theatres: " + filteredTheatres);
        return filteredTheatres;
    }



    public Theatre addTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public Theatre updateTheatre(String id, Theatre theatreDetails) {
        Theatre theatre = theatreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theatre not found"));
        theatre.setName(theatreDetails.getName());
        theatre.setCity(theatreDetails.getCity());
        theatre.setTicketPrice(theatreDetails.getTicketPrice());
        theatre.setSeats(theatreDetails.getSeats());
        theatre.setImage(theatreDetails.getImage());
        return theatreRepository.save(theatre);
    }

    public void deleteTheatre(String id) {
        theatreRepository.deleteById(id);
    }
}
