package com.aeroops.aircraft.repository;

import com.aeroops.aircraft.model.Aircraft;
import com.aeroops.aircraft.model.AircraftStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, UUID> {
    List<Aircraft> findByStatus(AircraftStatus status);
}
