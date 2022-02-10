package com.innoq.fleetmanagement.vehicle;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

public class Vehicle {

  @Id
  private UUID id;
  private final VehicleType type;
  private final String manufacturer;

  @PersistenceConstructor
  public Vehicle(UUID id, VehicleType type, String manufacturer) {
    this.id = requireNonNull(id);
    this.type = requireNonNull(type);
    this.manufacturer = requireNonNull(manufacturer);
  }

  public Vehicle(VehicleType type, String manufacturer) {
    this.type = requireNonNull(type);
    this.manufacturer = requireNonNull(manufacturer);
  }

  public UUID getId() {
    return id;
  }

  public VehicleType getType() {
    return type;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public enum VehicleType {
    CAR
  }
}
