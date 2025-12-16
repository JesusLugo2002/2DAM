package com.docencia.aed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docencia.aed.entity.PublisherEntity;
import com.docencia.aed.services.interfaces.IPublisherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/publishers")
@Tag(name = "Publisher operations")
public class PublisherController {

    private IPublisherService publisherService;

    @Autowired
    public void setPublisherService(IPublisherService service) {
        this.publisherService = service;
    }

    @Operation(summary = "Get all publishers")
    @GetMapping("/")
    public List<PublisherEntity> getAllPublishers() {
        return publisherService.findAll();
    }

    @Operation(summary = "Create a new publisher")
    @PostMapping("/")
    public PublisherEntity createPublisher(@Valid @RequestBody PublisherEntity publisher) {
        return publisherService.create(publisher);
    }

}
