package com.docencia.aed.controller;

import com.docencia.aed.entity.Event;
import com.docencia.aed.service.EventService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@Tag(name = "Events API")
public class PublicEventController {

    private final EventService service;

    public PublicEventController(EventService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Event>> listApproved() {
        return ResponseEntity.ok(service.listPublicApproved());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getApproved(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPublicApprovedById(id));
    }
}
