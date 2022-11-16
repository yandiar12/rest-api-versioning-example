package com.yandiar.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yandiar.api.models.Book;
import com.yandiar.api.service.BookServiceV1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("v1/books")
@Api(value = "Books API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Books"})
public class BookControllerV1 {
    
    @Autowired
    private BookServiceV1 booService;

    @GetMapping
    public ResponseEntity<?> getBooks() {

        List<Book> lst = booService.getAll();
        return new ResponseEntity<List<Book>>(lst, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {

        List<Book> lst = booService.getById(id);
        return new ResponseEntity<List<Book>>(lst, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) {

        List<Book> lst = booService.addBook(book);
        return new ResponseEntity<List<Book>>(lst, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteStudent(
            @PathVariable int id
            ) {
        List<Book> lst = booService.deleteBook(id);
        return new ResponseEntity<List<Book>>(lst, HttpStatus.OK);
    }
}
