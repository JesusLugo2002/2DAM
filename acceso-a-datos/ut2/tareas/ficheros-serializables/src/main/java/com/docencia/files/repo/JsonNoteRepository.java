package com.docencia.files.repo;

import com.fasterxml.jackson.databind.json.JsonMapper;

public class JsonNoteRepository extends FileNoteAbstractRepository {
    
    private static String filename = "note-repository.json";
    private static JsonMapper jsonMapper = new JsonMapper();

    public JsonNoteRepository() {
        super(filename, jsonMapper);
    }
}