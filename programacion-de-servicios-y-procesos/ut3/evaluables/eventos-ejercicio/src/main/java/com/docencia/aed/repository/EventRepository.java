package com.docencia.aed.repository;

import com.docencia.aed.entity.Event;
import com.docencia.aed.entity.EventStatus;

import java.util.List;
import java.util.Optional;

public interface EventRepository {
    Event save(Event event);
    Optional<Event> findById(Long id);
    List<Event> findAll();
    void deleteById(Long id);

    List<Event> findByStatus(EventStatus status);
    List<Event> findByCreatedBy(String username);
    List<Event> findByCreatedByAndStatus(String username, EventStatus status);
}
