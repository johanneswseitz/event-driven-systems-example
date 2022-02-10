package com.innoq.fleetmanagement.vehicle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class VehicleRepositoryIntegrationTest {

  @Autowired
  VehicleRepository vehicleRepository;

  @Test
  void should_persist_new_vehicle() {
    var vehicle = new Vehicle(Vehicle.VehicleType.CAR, "Awesome Cars Inc.");

    var generatedId = vehicleRepository.save(vehicle).getId();

    assertThat(vehicleRepository.findById(generatedId)).isNotNull();
  }

}
