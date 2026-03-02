package com.aeroops.aircraft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "aircraft")
@Getter
@Setter
public class Aircraft {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(unique = true, nullable = false)
    private String tailNumber;
    
    private String model;
    private String manufacturer;
    private Integer maxRangeKm;
    private Integer capacity;
    private LocalDate inductedOn;
    
    @Enumerated(EnumType.STRING)
    private AircraftStatus status = AircraftStatus.AVAILABLE;
}
