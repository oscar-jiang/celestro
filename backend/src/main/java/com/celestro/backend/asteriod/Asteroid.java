package com.celestro.backend.asteriod;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "asteroids")
public class Asteroid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double diameterMinKm;
    private Double diameterMaxKm;
    private Double velocityKmS;
    private Double missDistanceKm;
    private Boolean hazard;
    private LocalDate approachDate;

    // --- CONSTRUCTORS ---

    public Asteroid() {
    }

    public Asteroid(String name, Double diameterMinKm, Double diameterMaxKm, Double velocityKmS, Double missDistanceKm, Boolean hazard, LocalDate approachDate) {
        this.name = name;
        this.diameterMinKm = diameterMinKm;
        this.diameterMaxKm = diameterMaxKm;
        this.velocityKmS = velocityKmS;
        this.missDistanceKm = missDistanceKm;
        this.hazard = hazard;
        this.approachDate = approachDate;
    }

    public Asteroid(Long id, String name, Double diameterMinKm, Double diameterMaxKm, Double velocityKmS, Double missDistanceKm, Boolean hazard, LocalDate approachDate) {
        this.id = id;
        this.name = name;
        this.diameterMinKm = diameterMinKm;
        this.diameterMaxKm = diameterMaxKm;
        this.velocityKmS = velocityKmS;
        this.missDistanceKm = missDistanceKm;
        this.hazard = hazard;
        this.approachDate = approachDate;
    }

    // --- FUNCTIONS ---
    @Override
    public String toString() {
        return "Asteroid{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", diameterMinKm=" + diameterMinKm +
                ", diameterMaxKm=" + diameterMaxKm +
                ", velocityKmS=" + velocityKmS +
                ", missDistanceKm=" + missDistanceKm +
                ", hazard=" + hazard +
                ", approachDate=" + approachDate +
                '}';
    }



    // --- GETTERS & SETTERS ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDiameterMinKm() {
        return diameterMinKm;
    }

    public void setDiameterMinKm(Double diameterMinKm) {
        this.diameterMinKm = diameterMinKm;
    }

    public Double getDiameterMaxKm() {
        return diameterMaxKm;
    }

    public void setDiameterMaxKm(Double diameterMaxKm) {
        this.diameterMaxKm = diameterMaxKm;
    }

    public Double getVelocityKmS() {
        return velocityKmS;
    }

    public void setVelocityKmS(Double velocityKmS) {
        this.velocityKmS = velocityKmS;
    }

    public Double getMissDistanceKm() {
        return missDistanceKm;
    }

    public void setMissDistanceKm(Double missDistanceKm) {
        this.missDistanceKm = missDistanceKm;
    }

    public Boolean getHazard() {
        return hazard;
    }

    public void setHazard(Boolean hazard) {
        this.hazard = hazard;
    }

    public LocalDate getApproachDate() {
        return approachDate;
    }

    public void setApproachDate(LocalDate approachDate) {
        this.approachDate = approachDate;
    }
}
