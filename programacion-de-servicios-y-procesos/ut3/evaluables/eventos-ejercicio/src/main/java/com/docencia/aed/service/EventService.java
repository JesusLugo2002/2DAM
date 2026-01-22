package com.docencia.aed.service;

import com.docencia.aed.domain.EventCreateRequest;
import com.docencia.aed.domain.EventPatchRequest;
import com.docencia.aed.entity.Event;
import com.docencia.aed.entity.EventStatus;

import java.util.List;

public interface EventService {

    // v1
    List<Event> listPublicApproved();
    Event getPublicApprovedById(Long id);

    // v2
    List<Event> listV2(String requestingUser, boolean isAdmin, EventStatus statusFilterOrNull);
    Event getV2ById(String requestingUser, boolean isAdmin, Long id);

    Event create(String requestingUser, boolean isAdmin, EventCreateRequest req);
    Event patch(String requestingUser, boolean isAdmin, Long id, EventPatchRequest req);

    Event submitForApproval(String requestingUser, boolean isAdmin, Long id);
    Event approve(String requestingUser, boolean isAdmin, Long id);
    Event reject(String requestingUser, boolean isAdmin, Long id, String reason);

    void delete(String requestingUser, boolean isAdmin, Long id);
}
