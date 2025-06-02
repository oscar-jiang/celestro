package com.celestro.backend.satellite;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/satellites")
public class SatelliteController {

    private final SatelliteService satelliteService;

    public SatelliteController(SatelliteService satelliteService) {
        this.satelliteService = satelliteService;
    }

    @GetMapping
    public ResponseEntity<List<Satellite>> getAllSatellites() {
        return new ResponseEntity<List<Satellite>>(satelliteService.allSatellites(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Satellite> getSatelliteById(@PathVariable Long id) {
        return satelliteService.satelliteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/object-id/{objectId}")
    public ResponseEntity<Satellite> getSatelliteByObjectId(@PathVariable String objectId) {
        return satelliteService.satelliteByObjectId(objectId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/fetch/fetch-v2")
    public ResponseEntity<String> fetchSatellites() {
        satelliteService.fetchAndStoreSatellites();
        return ResponseEntity.ok("Fetched satellites successfully.");
    }
}
