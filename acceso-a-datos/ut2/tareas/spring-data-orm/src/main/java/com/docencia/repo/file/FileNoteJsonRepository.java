package com.docencia.repo.file;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class FileNoteJsonRepository extends FileNoteAbstractRepository{
    
    private static String nameFile= "nombre-fichero.json";
    private static  JsonMapper mapper= new JsonMapper();

    public FileNoteJsonRepository() {
        super(nameFile, mapper);
    }
}
