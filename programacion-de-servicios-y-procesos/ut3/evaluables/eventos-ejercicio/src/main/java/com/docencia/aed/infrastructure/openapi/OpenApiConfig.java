package com.docencia.aed.infrastructure.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI api() {
        return new OpenAPI().info(new Info()
                .title("Eventos API (Ejercicio)")
                .version("1.0")
                .description("API para ejercicio de REST + JWT + reglas de negocio"));
    }
}
