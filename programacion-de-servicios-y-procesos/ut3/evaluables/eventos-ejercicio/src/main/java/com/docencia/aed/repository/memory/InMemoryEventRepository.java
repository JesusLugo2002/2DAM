package com.docencia.aed.repository.memory;

import com.docencia.aed.entity.Event;
import com.docencia.aed.entity.EventStatus;
import com.docencia.aed.repository.EventRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class InMemoryEventRepository implements EventRepository {

    private final ConcurrentHashMap<Long, Event> store = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(0);

    @Override
    public Event save(Event event) {
        if (event.getId() == null) {
            event.setId(seq.incrementAndGet());
        }
        store.put(event.getId(), event);
        return event;
    }

    @Override
    public Optional<Event> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Event> findAll() {
        return store.values().stream()
                .sorted(Comparator.comparing(Event::getId))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }

    @Override
    public List<Event> findByStatus(EventStatus status) {
        return store.values().stream()
                .filter(e -> e.getStatus() == status)
                .sorted(Comparator.comparing(Event::getId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> findByCreatedBy(String username) {
        return store.values().stream()
                .filter(e -> username != null && username.equals(e.getCreatedBy()))
                .sorted(Comparator.comparing(Event::getId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> findByCreatedByAndStatus(String username, EventStatus status) {
        return store.values().stream()
                .filter(e -> username != null && username.equals(e.getCreatedBy()))
                .filter(e -> e.getStatus() == status)
                .sorted(Comparator.comparing(Event::getId))
                .collect(Collectors.toList());
    }
}
