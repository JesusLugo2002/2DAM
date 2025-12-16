package com.docencia.aed.services.interfaces;

import java.util.List;

import com.docencia.aed.entity.AuthorEntity;
import com.docencia.aed.entity.BookEntity;

public interface IAuthorService extends IGenericService<AuthorEntity, Integer> {
    /**
     * Get books from author with id.
     * @param authorId - Author id.
     * @return List of author books.
     */
    public List<BookEntity> findBooksByAuthor(Integer authorId);
}
