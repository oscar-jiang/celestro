package com.celestro.backend.satellite;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "satellites")
public class Satellite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String objectName;
    private String objectId;
    private LocalDateTime epoch;
    private Double meanMotion;
    private Double eccentricity;
    private Double inclination;
    private Double raOfAscNode;
    private Double argOfPericenter;
    private Double meanAnomaly;
    private Integer ephemerisType;
    private String classificationType;
    private Integer noradCatId;
    private Integer elementSetNo;
    private Integer revAtEpoch;
    private Double bstar;
    private Double meanMotionDot;
    private Double meanMotionDdot;
    private LocalDateTime fetchedAt;
    private String classification;

    // --- CONSTRUCTORS ---

    public Satellite() {
    }

    public Satellite(String objectName, String objectId, LocalDateTime epoch, Double meanMotion, Double eccentricity, Double inclination, Double raOfAscNode, Double argOfPericenter, Double meanAnomaly, Integer ephemerisType, String classificationType, Integer noradCatId, Integer elementSetNo, Integer revAtEpoch, Double bstar, Double meanMotionDot, Double meanMotionDdot, LocalDateTime fetchedAt, String classification) {
        this.objectName = objectName;
        this.objectId = objectId;
        this.epoch = epoch;
        this.meanMotion = meanMotion;
        this.eccentricity = eccentricity;
        this.inclination = inclination;
        this.raOfAscNode = raOfAscNode;
        this.argOfPericenter = argOfPericenter;
        this.meanAnomaly = meanAnomaly;
        this.ephemerisType = ephemerisType;
        this.classificationType = classificationType;
        this.noradCatId = noradCatId;
        this.elementSetNo = elementSetNo;
        this.revAtEpoch = revAtEpoch;
        this.bstar = bstar;
        this.meanMotionDot = meanMotionDot;
        this.meanMotionDdot = meanMotionDdot;
        this.fetchedAt = fetchedAt;
        this.classification = classification;
    }

    public Satellite(Long id, String objectName, String objectId, LocalDateTime epoch, Double meanMotion, Double eccentricity, Double inclination, Double raOfAscNode, Double argOfPericenter, Double meanAnomaly, Integer ephemerisType, String classificationType, Integer noradCatId, Integer elementSetNo, Integer revAtEpoch, Double bstar, Double meanMotionDot, Double meanMotionDdot, LocalDateTime fetchedAt, String classification) {
        this.id = id;
        this.objectName = objectName;
        this.objectId = objectId;
        this.epoch = epoch;
        this.meanMotion = meanMotion;
        this.eccentricity = eccentricity;
        this.inclination = inclination;
        this.raOfAscNode = raOfAscNode;
        this.argOfPericenter = argOfPericenter;
        this.meanAnomaly = meanAnomaly;
        this.ephemerisType = ephemerisType;
        this.classificationType = classificationType;
        this.noradCatId = noradCatId;
        this.elementSetNo = elementSetNo;
        this.revAtEpoch = revAtEpoch;
        this.bstar = bstar;
        this.meanMotionDot = meanMotionDot;
        this.meanMotionDdot = meanMotionDdot;
        this.fetchedAt = fetchedAt;
        this.classification = classification;
    }

    // --- FUNCTIONS ---
    @Override
    public String toString() {
        return "Satellite{" +
                "id=" + id +
                ", objectName='" + objectName + '\'' +
                ", objectId='" + objectId + '\'' +
                ", epoch=" + epoch +
                ", meanMotion=" + meanMotion +
                ", eccentricity=" + eccentricity +
                ", inclination=" + inclination +
                ", raOfAscNode=" + raOfAscNode +
                ", argOfPericenter=" + argOfPericenter +
                ", meanAnomaly=" + meanAnomaly +
                ", ephemerisType=" + ephemerisType +
                ", classificationType='" + classificationType + '\'' +
                ", noradCatId=" + noradCatId +
                ", elementSetNo=" + elementSetNo +
                ", revAtEpoch=" + revAtEpoch +
                ", bstar=" + bstar +
                ", meanMotionDot=" + meanMotionDot +
                ", meanMotionDdot=" + meanMotionDdot +
                ", fetchedAt=" + fetchedAt +
                ", classification='" + classification + '\'' +
                '}';
    }

    // --- GETTERS & SETTERS ---
    public LocalDateTime getFetchedAt() {
        return fetchedAt;
    }

    public void setFetchedAt(LocalDateTime fetchedAt) {
        this.fetchedAt = fetchedAt;
    }

    public Double getMeanMotionDdot() {
        return meanMotionDdot;
    }

    public void setMeanMotionDdot(Double meanMotionDdot) {
        this.meanMotionDdot = meanMotionDdot;
    }

    public Double getMeanMotionDot() {
        return meanMotionDot;
    }

    public void setMeanMotionDot(Double meanMotionDot) {
        this.meanMotionDot = meanMotionDot;
    }

    public Double getBstar() {
        return bstar;
    }

    public void setBstar(Double bstar) {
        this.bstar = bstar;
    }

    public Integer getRevAtEpoch() {
        return revAtEpoch;
    }

    public void setRevAtEpoch(Integer revAtEpoch) {
        this.revAtEpoch = revAtEpoch;
    }

    public Integer getElementSetNo() {
        return elementSetNo;
    }

    public void setElementSetNo(Integer elementSetNo) {
        this.elementSetNo = elementSetNo;
    }

    public Integer getNoradCatId() {
        return noradCatId;
    }

    public void setNoradCatId(Integer noradCatId) {
        this.noradCatId = noradCatId;
    }

    public String getClassificationType() {
        return classificationType;
    }

    public void setClassificationType(String classificationType) {
        this.classificationType = classificationType;
    }

    public Integer getEphemerisType() {
        return ephemerisType;
    }

    public void setEphemerisType(Integer ephemerisType) {
        this.ephemerisType = ephemerisType;
    }

    public Double getMeanAnomaly() {
        return meanAnomaly;
    }

    public void setMeanAnomaly(Double meanAnomaly) {
        this.meanAnomaly = meanAnomaly;
    }

    public Double getArgOfPericenter() {
        return argOfPericenter;
    }

    public void setArgOfPericenter(Double argOfPericenter) {
        this.argOfPericenter = argOfPericenter;
    }

    public Double getRaOfAscNode() {
        return raOfAscNode;
    }

    public void setRaOfAscNode(Double raOfAscNode) {
        this.raOfAscNode = raOfAscNode;
    }

    public Double getInclination() {
        return inclination;
    }

    public void setInclination(Double inclination) {
        this.inclination = inclination;
    }

    public Double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(Double eccentricity) {
        this.eccentricity = eccentricity;
    }

    public Double getMeanMotion() {
        return meanMotion;
    }

    public void setMeanMotion(Double meanMotion) {
        this.meanMotion = meanMotion;
    }

    public LocalDateTime getEpoch() {
        return epoch;
    }

    public void setEpoch(LocalDateTime epoch) {
        this.epoch = epoch;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
