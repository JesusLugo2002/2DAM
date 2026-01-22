package com.docencia.aed.service.impl;

import com.docencia.aed.domain.EventCreateRequest;
import com.docencia.aed.domain.EventPatchRequest;
import com.docencia.aed.entity.Event;
import com.docencia.aed.entity.EventStatus;
import com.docencia.aed.repository.EventRepository;
import com.docencia.aed.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO (ALUMNADO):
 * Implementa aquí las reglas de negocio descritas en el README:
 * - visibilidad por versión/rol
 * - ownership (colaborador solo sus eventos)
 * - edición solo en DRAFT/REJECTED para colaborador
 * - transiciones de estado válidas
 * - approve/reject/delete solo admin
 */
@Service
public class EventServiceImpl implements EventService {

    private final EventRepository repo;

    public EventServiceImpl(EventRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Event> listPublicApproved() {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    @Override
    public Event getPublicApprovedById(Long id) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    @Override
    public List<Event> listV2(String requestingUser, boolean isAdmin, EventStatus statusFilterOrNull) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    @Override
    public Event getV2ById(String requestingUser, boolean isAdmin, Long id) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    @Override
    public Event create(String requestingUser, boolean isAdmin, EventCreateRequest req) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    @Override
    public Event patch(String requestingUser, boolean isAdmin, Long id, EventPatchRequest req) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    @Override
    public Event submitForApproval(String requestingUser, boolean isAdmin, Long id) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    @Override
    public Event approve(String requestingUser, boolean isAdmin, Long id) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    @Override
    public Event reject(String requestingUser, boolean isAdmin, Long id, String reason) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    @Override
    public void delete(String requestingUser, boolean isAdmin, Long id) {
        throw new UnsupportedOperationException("TODO: implementar");
    }
}
