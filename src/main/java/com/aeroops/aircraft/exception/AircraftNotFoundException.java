package com.aeroops.aircraft.exception;

import java.util.UUID;

public class AircraftNotFoundException extends RuntimeException {
    public AircraftNotFoundException(UUID id) {
        super("Aircraft not found with id: " + id);
    }
}
