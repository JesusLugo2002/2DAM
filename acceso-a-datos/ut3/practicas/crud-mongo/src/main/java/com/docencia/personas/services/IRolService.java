package com.docencia.personas.services;

import com.docencia.personas.model.Rol;

public interface IRolService {
    public Rol save(Rol rol);
    public Rol find(Rol rol);
    public boolean delete(Rol rol);
}
