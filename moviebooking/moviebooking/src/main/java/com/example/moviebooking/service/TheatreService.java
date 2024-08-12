package com.example.moviebooking.service;

import com.example.moviebooking.model.Theatre;
import com.example.moviebooking.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public Optional<Theatre> getTheatreById(String id) {
        return theatreRepository.findById(id);
    }

    public List<Theatre> getTheatresByCity(String cityName) {
        return theatreRepository.findByCity(cityName);
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
