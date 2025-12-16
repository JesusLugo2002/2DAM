package com.docencia.aed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docencia.aed.entity.AuthorEntity;
import com.docencia.aed.entity.BookEntity;
import com.docencia.aed.services.interfaces.IAuthorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/authors")
@Tag(name = "Author operations")
public class AuthorController {

    private IAuthorService authorService;

    @Autowired
    public void setAuthorService(IAuthorService service) {
        this.authorService = service;
    }

    @Operation(summary = "Get all authors")
    @GetMapping("/")
    public List<AuthorEntity> getAllAuthors() {
        return authorService.findAll();
    }

    @Operation(summary = "Find author by ID")
    @GetMapping("/{id}")
    public AuthorEntity getAuthorById(@PathVariable(value = "id") int id) {
        return authorService.findById(id);
    }

    @Operation(summary = "Create a new author")
    @PostMapping("/")
    public AuthorEntity createAuthor(@Valid @RequestBody AuthorEntity author) {
        return authorService.create(author);
    }

    @Operation(summary = "Get books from author by author id")
    @GetMapping("/{id}/books")
    public List<BookEntity> findBooksByAuthor(@PathVariable(value = "id") int id) {
        return authorService.findBooksByAuthor(id);
    }

}
