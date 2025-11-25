package com.docencia.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.docencia.rest.model.Product;
import com.docencia.rest.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService service;

    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    } 

    @Operation(summary = "Get all products")
    @GetMapping("/")
    public List<Product> getAllProducts() {
        return service.findAll();
    }
    
}
