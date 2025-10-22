package com.docencia.files.repo;

import java.util.List;
import java.util.Optional;

import com.docencia.files.model.Note;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlNoteRepository extends FileNoteAbstractRepository {
    private static String filename = "nombre-fichero.xml";
    private static XmlMapper xmlMapper = new XmlMapper();

    public XmlNoteRepository() {
        super(filename, xmlMapper);
    }
}
