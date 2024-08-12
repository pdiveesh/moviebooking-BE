package com.example.moviebooking.repository;

import com.example.moviebooking.model.Theatre;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TheatreRepository extends MongoRepository<Theatre, String> {
    List<Theatre> findByCity(String cityName);
    // Query to find theatres by city name
}
