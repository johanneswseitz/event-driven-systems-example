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
  private final String model;
  private final String modelYear;
  private final String licencePlate;
  private final String colour;
  private final VehicleStatus status;

  @PersistenceConstructor
  public Vehicle(UUID id, VehicleType type, String manufacturer, String model, String modelYear, String licencePlate, String colour, VehicleStatus status) {
    this.id = id;
    this.type = requireNonNull(type);
    this.manufacturer = requireNonNull(manufacturer);
    this.model = requireNonNull(model);
    this.modelYear = requireNonNull(modelYear);
    this.licencePlate = licencePlate;
    this.colour = requireNonNull(colour);
    this.status = requireNonNull(status);
  }

  public Vehicle(VehicleType type, String manufacturer, String model, String modelYear, VehicleStatus status, String colour, String licencePlate) {
    this(null, type, manufacturer, model, modelYear, licencePlate, colour, status);
  }


  public Vehicle(String manufacturer, String model, String modelYear, String colour) {
    this(null, VehicleType.CAR, manufacturer, model, modelYear, null, colour, VehicleStatus.ORDERED);
  }

  public UUID getId() {
    return id;
  }

  public VehicleType getType() {
    return type;
  }

  public String getModel() {
    return model;
  }

  public String getModelYear() {
    return modelYear;
  }

  public String getLicencePlate() {
    return licencePlate;
  }

  public String getColour() {
    return colour;
  }

  public VehicleStatus getStatus() {
    return status;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public enum VehicleType {
    CAR
  }

  public enum VehicleStatus {
    ORDERED,
    AVAILABLE,
    IN_SERVICE
  }

}
