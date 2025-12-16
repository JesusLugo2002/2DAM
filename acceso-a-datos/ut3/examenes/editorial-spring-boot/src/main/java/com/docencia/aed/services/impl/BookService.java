package com.docencia.aed.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docencia.aed.entity.BookEntity;
import com.docencia.aed.repositories.jpa.BookJpaRepository;
import com.docencia.aed.services.interfaces.IBookService;

/**
 * Class BookService.
 * Handle book API operations.
 * 
 * @author JesusLugo2002
 */
@Service
public class BookService implements IBookService {

    private final BookJpaRepository repository;

    @Autowired
    public BookService(BookJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BookEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public BookEntity findById(Integer id) {
        if (id == null) return null;
        return repository.findById(id).orElse(null);
    }

    @Override
    public BookEntity create(BookEntity entity) {
        return repository.save(entity);
    }

}
