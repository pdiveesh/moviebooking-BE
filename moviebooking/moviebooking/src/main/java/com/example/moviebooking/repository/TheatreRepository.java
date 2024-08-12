package com.example.moviebooking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.moviebooking.model.Theatre;

import java.util.List;

public interface TheatreRepository extends MongoRepository<Theatre, String> {
    List<Theatre> findByCity(String city);
    List<Theatre> findAllById(Iterable<String> ids);
}
