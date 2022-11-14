package com.yandiar.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yandiar.api.models.Book;
import com.yandiar.api.service.BookServiceV1;

@RestController
@RequestMapping("v1")
public class BookControllerV1 {
    
    @Autowired
    private BookServiceV1 booService;

    @GetMapping("/books")
    public ResponseEntity<?> getBooks() {

        List<Book> lst = booService.getAll();
        return new ResponseEntity<List<Book>>(lst, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody Book book) {

        List<Book> lst = booService.addBook(book);
        return new ResponseEntity<List<Book>>(lst, HttpStatus.OK);
    }
}
