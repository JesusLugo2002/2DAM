package com.docencia.repo.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.docencia.model.Note;
import com.docencia.repo.INoteRepository;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Note find(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public List<Note> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Note save(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
