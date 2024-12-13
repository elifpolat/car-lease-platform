package com.example.carleaseplatform.infrastructure.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Car Lease Platform API")
            .version("1.0.0")
            .description("API documentation for the Car Lease Platform"));
  }

  @Bean
  public GroupedOpenApi customerApi() {
    return GroupedOpenApi.builder()
        .group("customers")
        .pathsToMatch("/api/customers/**")
        .build();
  }

  @Bean
  public GroupedOpenApi carApi() {
    return GroupedOpenApi.builder()
        .group("cars")
        .pathsToMatch("/api/cars/**")
        .build();
  }
}