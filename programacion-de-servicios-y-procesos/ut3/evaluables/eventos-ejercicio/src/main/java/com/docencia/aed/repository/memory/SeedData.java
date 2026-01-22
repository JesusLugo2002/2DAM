package com.docencia.aed.repository.memory;

import com.docencia.aed.entity.Event;
import com.docencia.aed.entity.EventStatus;
import com.docencia.aed.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Inserta datos de ejemplo en la "BBDD" en memoria.
 */
@Component
public class SeedData implements CommandLineRunner {

    private final EventRepository repo;

    public SeedData(EventRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        Instant now = Instant.now();

        Event approved = new Event();
        approved.setTitle("Evento aprobado (seed)");
        approved.setDescription("Visible en v1.");
        approved.setStartAt(now.plus(7, ChronoUnit.DAYS));
        approved.setStatus(EventStatus.APPROVED);
        approved.setCreatedBy("collab");
        approved.setApprovedBy("admin");
        approved.setApprovedAt(now);
        repo.save(approved);

        Event pending = new Event();
        pending.setTitle("Evento pendiente (seed)");
        pending.setDescription("No visible en v1.");
        pending.setStartAt(now.plus(10, ChronoUnit.DAYS));
        pending.setStatus(EventStatus.PENDING_APPROVAL);
        pending.setCreatedBy("collab");
        repo.save(pending);

        Event draft = new Event();
        draft.setTitle("Evento borrador (seed)");
        draft.setDescription("Editable por el creador.");
        draft.setStartAt(now.plus(12, ChronoUnit.DAYS));
        draft.setStatus(EventStatus.DRAFT);
        draft.setCreatedBy("collab");
        repo.save(draft);

        Event rejected = new Event();
        rejected.setTitle("Evento rechazado (seed)");
        rejected.setDescription("Se puede reenviar a aprobación.");
        rejected.setStartAt(now.plus(15, ChronoUnit.DAYS));
        rejected.setStatus(EventStatus.REJECTED);
        rejected.setCreatedBy("collab");
        rejected.setRejectionReason("Faltan datos.");
        repo.save(rejected);
    }
}
