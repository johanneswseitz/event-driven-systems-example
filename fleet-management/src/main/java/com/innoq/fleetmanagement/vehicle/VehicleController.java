package com.innoq.fleetmanagement.vehicle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.UUID;

import static com.innoq.fleetmanagement.vehicle.Vehicle.VehicleType.CAR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
public class VehicleController {

  private final VehicleRepository vehicleRepository;

  public VehicleController(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  @GetMapping("/")
  public ModelAndView getOverview() {
    var all = vehicleRepository.findAll();
    var model = Map.of("vehicles", all);
    return new ModelAndView("fleet_overview", model);
  }

  @GetMapping("/order-new-car/")
  public String orderNewCar() {
    return "order_new_car";
  }

  @PostMapping("/order-new-car/")
  public String orderNewCarPost(@ModelAttribute CreateVehicleCommand createVehicleCommand) {
    var vehicle = new Vehicle(null, CAR, createVehicleCommand.manufacturer, createVehicleCommand.model, createVehicleCommand.modelYear, null, createVehicleCommand.colour, Vehicle.VehicleStatus.ORDERED);
    vehicleRepository.save(vehicle);
    return "redirect:/";
  }

  @PostMapping(value = "/vehicles/{id}", name = "update-vehicle")
  public Object updateVehicle(@PathVariable("id") UUID id, @ModelAttribute UpdateVehicleCommand updateVehicleCommand) {
    var optionalVehicle = vehicleRepository.findById(id);
    if (optionalVehicle.isEmpty()) {
      return notFoundModel();
    }
    var vehicle = optionalVehicle.get();
    vehicle.setColour(updateVehicleCommand.colour());
    vehicle.setLicencePlate(updateVehicleCommand.licencePlate());
    vehicle.setStatus(updateVehicleCommand.status());
    vehicleRepository.save(vehicle);
    return "redirect:/";
  }

  record UpdateVehicleCommand(
      String licencePlate,
      String colour,
      Vehicle.VehicleStatus status
  ) {
  }


  @GetMapping("/vehicles/{id}")
  public ModelAndView getVehicleDetails(@PathVariable("id") UUID id) {
    var vehicle = vehicleRepository.findById(id);
    if (vehicle.isPresent()) {
      return new ModelAndView("vehicle_details", Map.of("vehicle", vehicle.get()));
    } else {
      return notFoundModel();
    }
  }

  private ModelAndView notFoundModel() {
    var notFoundModel = new ModelAndView();
    notFoundModel.setStatus(NOT_FOUND);
    return notFoundModel;
  }

  public record CreateVehicleCommand(String manufacturer, String model, String modelYear, String colour) {
  }


}
