package com.celestro.backend.satellite;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SatelliteDto {
    @JsonProperty("OBJECT_NAME")
    private String objectName;

    @JsonProperty("OBJECT_ID")
    private String objectId;

    @JsonProperty("EPOCH")
    private String epoch;

    @JsonProperty("MEAN_MOTION")
    private Double meanMotion;

    @JsonProperty("ECCENTRICITY")
    private Double eccentricity;

    @JsonProperty("INCLINATION")
    private Double inclination;

    @JsonProperty("RA_OF_ASC_NODE")
    private Double raOfAscNode;

    @JsonProperty("ARG_OF_PERICENTER")
    private Double argOfPericenter;

    @JsonProperty("MEAN_ANOMALY")
    private Double meanAnomaly;

    @JsonProperty("EPHEMERIS_TYPE")
    private Integer ephemerisType;

    @JsonProperty("CLASSIFICATION_TYPE")
    private String classificationType;

    @JsonProperty("NORAD_CAT_ID")
    private Integer noradCatId;

    @JsonProperty("ELEMENT_SET_NO")
    private Integer elementSetNo;

    @JsonProperty("REV_AT_EPOCH")
    private Integer revAtEpoch;

    @JsonProperty("BSTAR")
    private Double bstar;

    @JsonProperty("MEAN_MOTION_DOT")
    private Double meanMotionDot;

    @JsonProperty("MEAN_MOTION_DDOT")
    private Double meanMotionDdot;

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public Double getMeanMotion() {
        return meanMotion;
    }

    public void setMeanMotion(Double meanMotion) {
        this.meanMotion = meanMotion;
    }

    public Double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(Double eccentricity) {
        this.eccentricity = eccentricity;
    }

    public Double getInclination() {
        return inclination;
    }

    public void setInclination(Double inclination) {
        this.inclination = inclination;
    }

    public Double getRaOfAscNode() {
        return raOfAscNode;
    }

    public void setRaOfAscNode(Double raOfAscNode) {
        this.raOfAscNode = raOfAscNode;
    }

    public Double getArgOfPericenter() {
        return argOfPericenter;
    }

    public void setArgOfPericenter(Double argOfPericenter) {
        this.argOfPericenter = argOfPericenter;
    }

    public Double getMeanAnomaly() {
        return meanAnomaly;
    }

    public void setMeanAnomaly(Double meanAnomaly) {
        this.meanAnomaly = meanAnomaly;
    }

    public Integer getEphemerisType() {
        return ephemerisType;
    }

    public void setEphemerisType(Integer ephemerisType) {
        this.ephemerisType = ephemerisType;
    }

    public String getClassificationType() {
        return classificationType;
    }

    public void setClassificationType(String classificationType) {
        this.classificationType = classificationType;
    }

    public Integer getNoradCatId() {
        return noradCatId;
    }

    public void setNoradCatId(Integer noradCatId) {
        this.noradCatId = noradCatId;
    }

    public Integer getElementSetNo() {
        return elementSetNo;
    }

    public void setElementSetNo(Integer elementSetNo) {
        this.elementSetNo = elementSetNo;
    }

    public Integer getRevAtEpoch() {
        return revAtEpoch;
    }

    public void setRevAtEpoch(Integer revAtEpoch) {
        this.revAtEpoch = revAtEpoch;
    }

    public Double getBstar() {
        return bstar;
    }

    public void setBstar(Double bstar) {
        this.bstar = bstar;
    }

    public Double getMeanMotionDot() {
        return meanMotionDot;
    }

    public void setMeanMotionDot(Double meanMotionDot) {
        this.meanMotionDot = meanMotionDot;
    }

    public Double getMeanMotionDdot() {
        return meanMotionDdot;
    }

    public void setMeanMotionDdot(Double meanMotionDdot) {
        this.meanMotionDdot = meanMotionDdot;
    }
}
