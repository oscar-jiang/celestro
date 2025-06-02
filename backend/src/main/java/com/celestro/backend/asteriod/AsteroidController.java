package com.celestro.backend.asteriod;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/asteroids")
public class AsteroidController {

    private final AsteroidService asteroidService;

    public AsteroidController(AsteroidService asteroidService) {
        this.asteroidService = asteroidService;
    }

    @GetMapping
    public ResponseEntity<List<Asteroid>> getAllAsteroids() {
        return new ResponseEntity<List<Asteroid>>(asteroidService.allAsteroids(), HttpStatus.OK);
    }

    @GetMapping("/hazardous")
    public ResponseEntity<List<Asteroid>> getHazardousAsteroids() {
        return new ResponseEntity<List<Asteroid>>(asteroidService.hazardousAsteroids(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asteroid> getAsteroidById(@PathVariable Long id) {
        return asteroidService.asteroidById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Asteroid createAsteroid(@RequestBody Asteroid asteroid) {
        return asteroidService.saveAsteroid(asteroid);
    }
}
