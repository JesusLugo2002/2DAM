package com.docencia.aed.controller;

import com.docencia.aed.entity.Event;
import com.docencia.aed.service.EventService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@Tag(name = "Events Public API")
public class PublicEventController {

    private final EventService service;

    public PublicEventController(EventService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all approved events")
    @ApiResponse(responseCode = "200", description = "Query successfully executed")
    public ResponseEntity<List<Event>> listApproved() {
        return ResponseEntity.ok(service.listPublicApproved());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an approved event by id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Event found"),
        @ApiResponse(responseCode = "404", description = "Event not found")
    })
    public ResponseEntity<Event> getApproved(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getPublicApprovedById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
