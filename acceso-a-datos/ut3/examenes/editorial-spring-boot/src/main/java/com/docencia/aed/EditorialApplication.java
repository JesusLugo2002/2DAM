package com.docencia.aed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
info = @Info(
title = "API de Autores, Libros y Editoriales",
version = "1.0",
description = "Ejercicio guiado en Navidad"
)
)
@SpringBootApplication
public class EditorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(EditorialApplication.class, args);
    }
}
