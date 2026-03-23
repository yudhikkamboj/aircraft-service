package com.aeroops.aircraft.controller;

import com.aeroops.aircraft.dto.AircraftRequest;
import com.aeroops.aircraft.dto.AircraftResponse;
import com.aeroops.aircraft.dto.AircraftStatusUpdate;
import com.aeroops.aircraft.service.AircraftService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/aircraft")
@Slf4j
@AllArgsConstructor
public class AircraftController {

    private final AircraftService aircraftService;
    private final Environment environment;

    @PostMapping
    public ResponseEntity<Void> createAircraft(@RequestBody AircraftRequest request) {
        aircraftService.createAircraft(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AircraftResponse> getAircraftById(@PathVariable UUID id) {
        log.info("Fetching aircraft with id: {}", id);
        log.info("value of env zipkin: {}", environment.getProperty("management.zipkin.tracing.endpoint"));
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
