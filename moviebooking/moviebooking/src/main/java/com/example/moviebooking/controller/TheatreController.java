package com.example.moviebooking.controller;

import com.example.moviebooking.model.Theatre;
import com.example.moviebooking.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @GetMapping
    public List<Theatre> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theatre> getTheatreById(@PathVariable String id) {
        return theatreService.getTheatreById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/city/{cityName}")
    public List<Theatre> getTheatresByCity(@PathVariable String cityName) {
        return theatreService.getTheatresByCity(cityName);
    }

    @GetMapping("/byCityAndMovie")
    public List<Theatre> getTheatresByCityAndMovieId(@RequestParam String cityName, @RequestParam String movieId) {
        System.out.println("Received request with cityName: " + cityName + " and movieId: " + movieId);
        List<Theatre> theatres = theatreService.findTheatresByCityAndMovieId(cityName, movieId);
        System.out.println("Theatres returned by service: " + theatres);
        return theatres;
    }

    @PostMapping
    public Theatre createTheatre(@RequestBody Theatre theatre) {
        return theatreService.addTheatre(theatre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Theatre> updateTheatre(@PathVariable String id, @RequestBody Theatre theatreDetails) {
        return ResponseEntity.ok(theatreService.updateTheatre(id, theatreDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheatre(@PathVariable String id) {
        theatreService.deleteTheatre(id);
        return ResponseEntity.noContent().build();
    }
}
