package com.docencia.aed.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docencia.aed.entity.PublisherEntity;
import com.docencia.aed.repositories.jpa.PublisherJpaRepository;
import com.docencia.aed.services.interfaces.IPublisherService;

/**
 * Class PublisherService.
 * Handle publisher API operations.
 * 
 * @author JesusLugo2002
 */
@Service
public class PublisherService implements IPublisherService {

    private final PublisherJpaRepository repository;

    @Autowired
    public PublisherService(PublisherJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PublisherEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public PublisherEntity findById(Integer id) {
        if (id == null) return null;
        return repository.findById(id).orElse(null);
    }

    @Override
    public PublisherEntity create(PublisherEntity entity) {
        return repository.save(entity);
    }
    
}
