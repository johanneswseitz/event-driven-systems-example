package com.innoq.fleetmanagement.vehicle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.innoq.fleetmanagement.vehicle.Vehicle.VehicleStatus.IN_SERVICE;
import static com.innoq.fleetmanagement.vehicle.Vehicle.VehicleType.CAR;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class VehicleRepositoryIntegrationTest {

  @Autowired
  VehicleRepository vehicleRepository;

  @Test
  void should_persist_new_vehicle() {
    var vehicle = vehicleRepository.save(new Vehicle(CAR, "VW", "Golf", "2022", IN_SERVICE, "green", "ME-IQ-999"));

    var generatedId = vehicleRepository.save(vehicle).getId();

    assertThat(vehicleRepository.findById(generatedId)).isNotNull();
  }

}
