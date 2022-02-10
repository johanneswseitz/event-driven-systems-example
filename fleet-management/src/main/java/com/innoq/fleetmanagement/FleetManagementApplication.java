package com.innoq.fleetmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@EnableJdbcRepositories
@SpringBootApplication
public class FleetManagementApplication {

  public static void main(String[] args) {
    SpringApplication.run(FleetManagementApplication.class, args);
  }

}
