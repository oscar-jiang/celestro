package com.celestro.backend.satellite;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SatelliteRepository extends JpaRepository<Satellite, Long> {

    Satellite findByObjectId(String objectId);
}
