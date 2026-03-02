package com.aeroops.aircraft.controller;

import com.aeroops.aircraft.dto.AircraftRequest;
import com.aeroops.aircraft.dto.AircraftResponse;
import com.aeroops.aircraft.dto.AircraftStatusUpdate;
import com.aeroops.aircraft.service.AircraftService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/aircraft")
public class AircraftController {

    private final AircraftService aircraftService;

    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @PostMapping
    public ResponseEntity<Void> createAircraft(@RequestBody AircraftRequest request) {
        aircraftService.createAircraft(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AircraftResponse> getAircraftById(@PathVariable UUID id) {
        return ResponseEntity.ok(aircraftService.getAircraftById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAircraftStatus(@PathVariable UUID id, @RequestBody AircraftStatusUpdate statusUpdate) {
        aircraftService.updateAircraftStatus(id, statusUpdate);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/available")
    public ResponseEntity<List<AircraftResponse>> getAvailableAircraft() {
        return ResponseEntity.ok(aircraftService.getAvailableAircraft());
    }

    @PostMapping("/simulate/failure")
    public ResponseEntity<Void> simulateFailure(@RequestParam int rate) {
        return ResponseEntity.ok().build();
    }
}
