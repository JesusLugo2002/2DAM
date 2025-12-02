package com.docencia.personas.services.implementations;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.docencia.personas.model.Rol;
import com.docencia.personas.repository.RolRepository;
import com.docencia.personas.services.IRolService;

@Service
public class RolService implements IRolService {
    
    private RolRepository repository;

    public RolService(RolRepository repository) {
        this.repository = repository;
    }

    @Override
    public Rol save(Rol rol) {
        return repository.save(rol);
    }

    @Override
    public Rol find(Rol rol) {
        return repository.findById(rol.getId()).orElse(null);
    }

    @Override
    public boolean delete(Rol rol) {
        repository.delete(rol);
        return true;
    }

    
}
