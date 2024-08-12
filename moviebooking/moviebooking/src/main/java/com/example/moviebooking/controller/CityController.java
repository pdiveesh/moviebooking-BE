package com.example.moviebooking.controller;

import com.example.moviebooking.model.City;
import com.example.moviebooking.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getCities() {
        return cityService.getAllCities();
    }

    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody City city) {
        City addedCity = cityService.addCity(city);
        return ResponseEntity.ok(addedCity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable String id) {
        cityService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }
}
