package org.jesus.polyglot.domain.repository;

import java.util.Optional;

import org.jesus.polyglot.model.nosql.GuestPreferences;

public interface GuestPreferencesRepository {

    /**
     * Busca un documento con las preferencias de un huesped por su id.
     * @param guestId - Identificador unico.
     * @return La informacion si es encontrada, si no, {@code null}.
     */
    Optional<GuestPreferences> findByGuestId(String guestId);

    /**
     * Guarda o actualiza las preferencias de un huesped.
     * @param prefs - Preferencias del huesped.
     * @return Preferencias del huesped ya guardadas/actualizadas.
     */
    GuestPreferences save(GuestPreferences prefs);

    /**
     * Elimina un {@code GuestPreferences} por su id.
     * @param guestId - Identificador unico.
     * @return {@code true} si es eliminado, si no, {@code false}.
     */
    boolean deleteByGuestId(String guestId);
}
