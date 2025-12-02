package org.jesus.polyglot.model.nosql;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;

/**
 * Clase GuestPreferences.
 * Representa un documento de las preferencias del huesped que incluyen informacion
 * sobre su lenguaje preferido, si esta asociado al newsletter, su tipo de habitacion favorita,
 * sus etiquetas y anotaciones.
 * 
 * @author JesusLugo2002
 */
@Document(collection = "guest_preferences")
public class GuestPreferences {

    @Id
    private String guestId;

    @Field(name = "preferred_language")
    private String preferredLanguage;

    @Field(name = "newsletter_opt_in")
    private boolean newsletterOptIn;

    @Field(name = "favorite_room_type")
    private String favoriteRoomType;

    @Field(name = "tags")
    private List<String> tags = new ArrayList<>();

    @Field(name = "notes")
    private String notes;

    /**
     * Constructor vacio.
     */
    public GuestPreferences() {
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public boolean isNewsletterOptIn() {
        return newsletterOptIn;
    }

    public void setNewsletterOptIn(boolean newsletterOptIn) {
        this.newsletterOptIn = newsletterOptIn;
    }

    public String getFavoriteRoomType() {
        return favoriteRoomType;
    }

    public void setFavoriteRoomType(String favoriteRoomType) {
        this.favoriteRoomType = favoriteRoomType;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GuestPreferences other = (GuestPreferences) obj;
        if (guestId == null) {
            if (other.guestId != null)
                return false;
        } else if (!guestId.equals(other.guestId))
            return false;
        return true;
    }

    
}
