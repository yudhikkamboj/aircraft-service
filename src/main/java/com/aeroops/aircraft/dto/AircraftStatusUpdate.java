package com.aeroops.aircraft.dto;

import com.aeroops.aircraft.model.AircraftStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AircraftStatusUpdate {
    private AircraftStatus status;
}
