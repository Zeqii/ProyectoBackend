package com.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Sistema de Gestion Turnos")
                        .version("1.0")
                        .description("API para gestionar el sistema de turnos de Servicio al cliente")
                        .contact(new Contact()
                                .name("UMG")
                                .email("bnijl@umg.edu.gt")
                                .url("https://www.umg.edu.gt")));
    }
}