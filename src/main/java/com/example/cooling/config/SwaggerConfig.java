package com.example.cooling.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI districtCoolingAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("District Cooling System API")
                        .version("1.0")
                        .description("Spring Boot REST API for Customer Billing, Telemetry Monitoring and Profit Analysis")
                        .contact(new Contact()
                                .name("Vaishu")
                                .email("vaishumanogaran365@gmail.com")));
    }
}