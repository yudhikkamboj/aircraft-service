package com.aeroops.aircraft.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class AircraftResponse {
    private UUID id;
    private String tailNumber;
    private String model;
    private String manufacturer;
    private String status;
}
