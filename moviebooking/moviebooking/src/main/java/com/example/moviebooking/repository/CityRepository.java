package com.example.moviebooking.repository;

import com.example.moviebooking.model.City;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository extends MongoRepository<City, String> {
}
