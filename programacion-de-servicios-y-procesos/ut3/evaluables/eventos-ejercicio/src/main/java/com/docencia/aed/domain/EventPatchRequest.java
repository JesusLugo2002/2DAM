package com.docencia.aed.domain;

import java.time.Instant;

/**
 * PATCH parcial: deja null lo que no quieras modificar.
 */
public class EventPatchRequest {
    private String title;
    private String description;
    private Instant startAt;
    private Instant endAt;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Instant getStartAt() { return startAt; }
    public void setStartAt(Instant startAt) { this.startAt = startAt; }

    public Instant getEndAt() { return endAt; }
    public void setEndAt(Instant endAt) { this.endAt = endAt; }
}
