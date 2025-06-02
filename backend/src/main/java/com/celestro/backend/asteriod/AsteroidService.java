package com.celestro.backend.asteriod;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsteroidService {
    private AsteroidRepository asteroidRepository;

    public AsteroidService(AsteroidRepository asteroidRepository) {
        this.asteroidRepository = asteroidRepository;
    }

    public List<Asteroid> allAsteroids() {
        return asteroidRepository.findAll();
    }

    public List<Asteroid> hazardousAsteroids() {
        return asteroidRepository.findByHazardTrue();
    }

    public Optional<Asteroid> asteroidById(Long id) {
        return asteroidRepository.findById(id);
    }

    public Asteroid saveAsteroid(Asteroid asteroid) {
        return asteroidRepository.save(asteroid);
    }
}
