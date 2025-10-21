package com.docencia.files.service;

import java.util.List;
import java.util.Optional;

import com.docencia.files.model.Note;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class JsonServiceNote implements IServiceNote {

    JsonMapper jsonMapper;

    public JsonServiceNote() {
        jsonMapper = new JsonMapper();
    }

    @Override
    public boolean exists(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public Note findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Note> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Note save(Note note, Optional<String> expOpt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public String noteToString(Note note) {
        String result = null;
        try {
            result = jsonMapper.writeValueAsString(note);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Note stringToNote(String data) {
        Note result = null;
        try {
            result = jsonMapper.readValue(data, Note.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
