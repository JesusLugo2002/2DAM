package com.docencia.repo.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.docencia.model.Note;
import com.docencia.repo.INoteRepository;

import io.micrometer.common.util.StringUtils;

@Repository
public class NoteJpaRepository implements INoteRepository {

    private final ISqliteNoteRepository repository;

    /**
     * Constructor por defecto
     */
    public NoteJpaRepository() {
        this.repository = null;
    }

    /**
     * Constructor con repositorio inicializado
     * @param repository repositorio de conexion sobre la base de datos
     */
    public NoteJpaRepository(ISqliteNoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean exists(String id) {
        return repository.existsById(id);
    }

    @Override
    public Note findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Note find(Note note) {
        return this.findById(note.getId());
    }

    @Override
    public List<Note> findAll() {
        return repository.findAll();
    }

    @Override
    public Note save(Note note) {
        if (note.getId() == null || StringUtils.isEmpty(note.getId())) {
            note.setId(UUID.randomUUID().toString());
        }
        return repository.save(note);
    }

    @Override
    public boolean delete(String id) {
        if (!exists(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

}
