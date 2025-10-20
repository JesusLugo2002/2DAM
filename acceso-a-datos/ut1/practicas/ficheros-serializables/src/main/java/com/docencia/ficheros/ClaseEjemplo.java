package com.docencia.ficheros;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class ClaseEjemplo {

    private static final Logger logger = LoggerFactory.getLogger(ClaseEjemplo.class);
    
    public ClaseEjemplo() {
        String variable = "soy variable";
        logger.info("Soy un mensaje {}", variable);
    }

}
