package com.docencia.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.docencia.model.Note;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlServiceNote extends ServiceNoteAbstract {
    XmlMapper xmlMapper;


    private static Logger logger = LoggerFactory.getLogger(XmlServiceNote.class);


    public XmlServiceNote() {
        xmlMapper = new XmlMapper(); 
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
    public Note save(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public String noteToString(Note note) {
        try {
            return xmlMapper.writeValueAsString(note);
        } catch (JsonProcessingException e) {
            logger.error("Se ha producido un error en la transformacion de note {}", note,  e);

        }
        return null;
    }

    @Override
    public Note stringToNote(String data) {
        try {
            return xmlMapper.readValue(data, Note.class);
        } catch (JsonProcessingException e) {
            logger.error("Se ha producido un error en la transformacion de data {}", data,  e);
        }
        return null;
    }
}
