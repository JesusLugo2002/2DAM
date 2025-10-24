package com.docencia.files.repo;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlNoteRepository extends FileNoteAbstractRepository {
    
    private static String filename = "note-repository.xml";
    private static XmlMapper xmlMapper = new XmlMapper();

    public XmlNoteRepository() {
        super(filename, xmlMapper);
    }
}
