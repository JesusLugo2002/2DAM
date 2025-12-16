package com.docencia.aed.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docencia.aed.entity.AuthorEntity;
import com.docencia.aed.entity.BookEntity;
import com.docencia.aed.repositories.jpa.AuthorJpaRepository;
import com.docencia.aed.services.interfaces.IAuthorService;

/**
 * Class AuthorService.
 * Handle author API operations.
 * 
 * @author JesusLugo2002
 */
@Service
public class AuthorService implements IAuthorService {

    private final AuthorJpaRepository repository;

    @Autowired
    public AuthorService(AuthorJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AuthorEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public AuthorEntity findById(Integer id) {
        if (id == null) return null;
        return repository.findById(id).orElse(null);
    }

    @Override
    public AuthorEntity create(AuthorEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<BookEntity> findBooksByAuthor(Integer authorId) {
        if (authorId == null) return null;
        AuthorEntity author = findById(authorId);
        return author.getBooks();
    }

}
