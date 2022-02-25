package com.innoq.fleetmanagement.vehicle;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

public class Vehicle {

  @Id
  private final UUID id;
  private final VehicleType type;
  private final String manufacturer;
  private final String model;
  private final String modelYear;
  private String licencePlate;
  private String colour;
  private VehicleStatus status;

  public void setLicencePlate(String licencePlate) {
    this.licencePlate = licencePlate;
  }

  public void setColour(String colour) {
    this.colour = colour;
  }

  public void setStatus(VehicleStatus status) {
    this.status = status;
  }

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
