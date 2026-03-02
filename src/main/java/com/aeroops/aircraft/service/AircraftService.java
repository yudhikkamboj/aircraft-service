package com.aeroops.aircraft.service;

import com.aeroops.aircraft.dto.AircraftRequest;
import com.aeroops.aircraft.dto.AircraftResponse;
import com.aeroops.aircraft.dto.AircraftStatusUpdate;
import com.aeroops.aircraft.exception.AircraftNotFoundException;
import com.aeroops.aircraft.model.Aircraft;
import com.aeroops.aircraft.model.AircraftStatus;
import com.aeroops.aircraft.repository.AircraftRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;

    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    @Transactional
    public void createAircraft(AircraftRequest request) {
        Aircraft aircraft = new Aircraft();
        aircraft.setTailNumber(request.getTailNumber());
        aircraft.setModel(request.getModel());
        aircraft.setManufacturer(request.getManufacturer());
        aircraft.setMaxRangeKm(request.getMaxRangeKm());
        aircraft.setCapacity(request.getCapacity());
        aircraft.setInductedOn(request.getInductedOn());
        aircraftRepository.save(aircraft);
    }

    public AircraftResponse getAircraftById(UUID id) {
        Aircraft aircraft = aircraftRepository.findById(id)
                .orElseThrow(() -> new AircraftNotFoundException(id));
        return toResponse(aircraft);
    }

    @Transactional
    public void updateAircraftStatus(UUID id, AircraftStatusUpdate statusUpdate) {
        Aircraft aircraft = aircraftRepository.findById(id)
                .orElseThrow(() -> new AircraftNotFoundException(id));
        aircraft.setStatus(statusUpdate.getStatus());
        aircraftRepository.save(aircraft);
    }

    public List<AircraftResponse> getAvailableAircraft() {
        return aircraftRepository.findByStatus(AircraftStatus.AVAILABLE)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private AircraftResponse toResponse(Aircraft aircraft) {
        return new AircraftResponse(
                aircraft.getId(),
                aircraft.getTailNumber(),
                aircraft.getModel(),
                aircraft.getManufacturer(),
                aircraft.getStatus().name()
        );
    }
}
