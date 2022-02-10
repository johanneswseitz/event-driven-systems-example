package com.innoq.fleetmanagement;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@EnableJdbcRepositories
@SpringBootApplication
public class FleetManagementApplication {

  @Bean
  public LayoutDialect layoutDialect() {
      return new LayoutDialect();
  }

  public static void main(String[] args) {
    SpringApplication.run(FleetManagementApplication.class, args);
  }

}
