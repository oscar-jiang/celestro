package com.celestro.backend.satellite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SatelliteService {
    private final RestTemplate restTemplate;
    private final SatelliteRepository satelliteRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    @Value("${celestrak.api.url.space.station}")
    private String celestrakFetchUrl;

    @Autowired
    public SatelliteService(RestTemplate restTemplate, SatelliteRepository satelliteRepository) {
        this.restTemplate = restTemplate;
        this.satelliteRepository = satelliteRepository;
    }

    public List<Satellite> allSatellites() {
        return satelliteRepository.findAll();
    }

    public Optional<Satellite> satelliteById(Long id) {
        return satelliteRepository.findById(id);
    }

    public Optional<Satellite> satelliteByObjectId(String objectId) {
        return Optional.ofNullable(satelliteRepository.findByObjectId(objectId));
    }

    public void fetchAndStoreSatellites() {
        String url = celestrakFetchUrl;

        ResponseEntity<SatelliteDto[]> response = restTemplate.getForEntity(url, SatelliteDto[].class);
        SatelliteDto[] dtos = response.getBody();

        if (dtos != null) {
            List<Satellite> satellites = Arrays.stream(dtos)
                    .map(dto -> {
                       Satellite satellite = new Satellite();
                       satellite.setObjectName(dto.getObjectName());
                       satellite.setObjectId(dto.getObjectId());
                        satellite.setEpoch(LocalDateTime.parse(dto.getEpoch(), formatter));
                        satellite.setMeanMotion(dto.getMeanMotion());
                        satellite.setEccentricity(dto.getEccentricity());
                        satellite.setInclination(dto.getInclination());
                        satellite.setRaOfAscNode(dto.getRaOfAscNode());
                        satellite.setArgOfPericenter(dto.getArgOfPericenter());
                        satellite.setMeanAnomaly(dto.getMeanAnomaly());
                        satellite.setEphemerisType(dto.getEphemerisType());
                        satellite.setClassificationType(dto.getClassificationType());
                        satellite.setNoradCatId(dto.getNoradCatId());
                        satellite.setElementSetNo(dto.getElementSetNo());
                        satellite.setRevAtEpoch(dto.getRevAtEpoch());
                        satellite.setBstar(dto.getBstar());
                        satellite.setMeanMotionDot(dto.getMeanMotionDot());
                        satellite.setMeanMotionDdot(dto.getMeanMotionDdot());
                        satellite.setFetchedAt(LocalDateTime.now());
                        satellite.setClassification("navigation"); // chance this when you fetch the data
                        return satellite;
                    }).toList();

            satelliteRepository.saveAll(satellites);
        }

    }
}
