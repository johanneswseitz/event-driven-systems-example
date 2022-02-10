package com.innoq.fleetmanagement.vehicle;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import static com.innoq.fleetmanagement.vehicle.Vehicle.VehicleStatus.*;
import static com.innoq.fleetmanagement.vehicle.Vehicle.VehicleType.CAR;

@Service
public class VehicleFixtureService {

  private final VehicleRepository vehicleRepository;

  public VehicleFixtureService(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  @PostConstruct
  public void addVehicleFixtures() {
    vehicleRepository.save(new Vehicle(CAR, "VW", "Golf", "2022", IN_SERVICE, "green", "ME-IQ-999"));
    vehicleRepository.save(new Vehicle(CAR, "BMW", "i3", "2022", AVAILABLE, "black", "ME-IQ-998"));
    vehicleRepository.save(new Vehicle(CAR, "Tesla", "Model 3", "2022", ORDERED, "green", "ME-IQ-997"));
  }
}
