package com.docencia.aed.controller;

import com.docencia.aed.domain.EventCreateRequest;
import com.docencia.aed.domain.EventPatchRequest;
import com.docencia.aed.domain.RejectRequest;
import com.docencia.aed.entity.Event;
import com.docencia.aed.entity.EventStatus;
import com.docencia.aed.service.EventService;
import com.docencia.aed.util.SecurityUtils;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/events")
public class EventControllerV2 {

    private final EventService service;

    public EventControllerV2(EventService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Event>> list(@RequestParam(value = "status", required = false) EventStatus status) {
        return ResponseEntity.ok(service.listV2(SecurityUtils.username(), SecurityUtils.isAdmin(), status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getV2ById(SecurityUtils.username(), SecurityUtils.isAdmin(), id));
    }

    @PostMapping
    public ResponseEntity<Event> create(@Valid @RequestBody EventCreateRequest req) {
        return ResponseEntity.ok(service.create(SecurityUtils.username(), SecurityUtils.isAdmin(), req));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Event> patch(@PathVariable Long id, @RequestBody EventPatchRequest req) {
        return ResponseEntity.ok(service.patch(SecurityUtils.username(), SecurityUtils.isAdmin(), id, req));
    }

    @PostMapping("/{id}/submit")
    public ResponseEntity<Event> submit(@PathVariable Long id) {
        return ResponseEntity.ok(service.submitForApproval(SecurityUtils.username(), SecurityUtils.isAdmin(), id));
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<Event> approve(@PathVariable Long id) {
        return ResponseEntity.ok(service.approve(SecurityUtils.username(), SecurityUtils.isAdmin(), id));
    }

    @PostMapping("/{id}/reject")
    public ResponseEntity<Event> reject(@PathVariable Long id, @Valid @RequestBody RejectRequest req) {
        return ResponseEntity.ok(service.reject(SecurityUtils.username(), SecurityUtils.isAdmin(), id, req.getReason()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(SecurityUtils.username(), SecurityUtils.isAdmin(), id);
        return ResponseEntity.noContent().build();
    }
}
