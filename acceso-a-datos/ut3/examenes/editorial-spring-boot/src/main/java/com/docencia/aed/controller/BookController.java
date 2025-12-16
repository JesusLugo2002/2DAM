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
import com.docencia.aed.services.interfaces.IBookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
@Tag(name = "Book operations")
public class BookController {

    private IBookService bookService;
    private IAuthorService authorService;

    @Autowired
    public void setAuthorService(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @Autowired
    public void setBookService(IBookService service) {
        this.bookService = service;
    }

    @Operation(summary = "Get all books")
    @GetMapping("/")
    public List<BookEntity> getAllBooks() {
        return bookService.findAll();
    }

    @Operation(summary = "Find book by ID")
    @GetMapping("/{id}")
    public BookEntity getBookById(@PathVariable(value = "id") int id) {
        return bookService.findById(id);
    }

    @Operation(summary = "Create a book linked to author with id")
    @PostMapping("/books?authorId={authorId}")
    public BookEntity createBook(@Valid @RequestBody BookEntity book, @PathVariable(value = "authorId") int id) {
        AuthorEntity author = authorService.findById(id);
        book.setAuthor(author);
        return bookService.create(book);
    }

}
