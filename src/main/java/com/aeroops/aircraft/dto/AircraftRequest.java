package com.aeroops.aircraft.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AircraftRequest {
    private String tailNumber;
    private String model;
    private String manufacturer;
    private Integer maxRangeKm;
    private Integer capacity;
    private LocalDate inductedOn;
}
