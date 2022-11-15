package com.yandiar.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yandiar.api.models.Book;
import com.yandiar.api.service.BookServiceV1;

@RestController
public class BookControllerV1 {
    
    @Autowired
    private BookServiceV1 booService;

    @GetMapping("v1/books")
    public ResponseEntity<?> getBooks() {

        List<Book> lst = booService.getAll();
        return new ResponseEntity<List<Book>>(lst, HttpStatus.OK);
    }

    @GetMapping("v1/books/{id}")
    public ResponseEntity<?> getBooks(@PathVariable int id) {

        List<Book> lst = booService.getById(id);
        return new ResponseEntity<List<Book>>(lst, HttpStatus.OK);
    }

    @PostMapping("v1/books")
    public ResponseEntity<?> addBook(@RequestBody Book book) {

        List<Book> lst = booService.addBook(book);
        return new ResponseEntity<List<Book>>(lst, HttpStatus.OK);
    }

    @DeleteMapping(value = "v1/books/{id}")
    private ResponseEntity<?> deleteStudent(
            @PathVariable int id
            ) {
        List<Book> lst = booService.deleteBook(id);
        return new ResponseEntity<List<Book>>(lst, HttpStatus.OK);
    }
}
