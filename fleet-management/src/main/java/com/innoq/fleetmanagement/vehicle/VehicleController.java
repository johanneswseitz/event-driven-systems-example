package com.innoq.fleetmanagement.vehicle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

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
    return new ModelAndView("overview", model);
  }
}
