package com.celestro.backend.asteriod;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsteroidRepository extends JpaRepository<Asteroid, Long> {

    List<Asteroid> findByHazardTrue();
}
