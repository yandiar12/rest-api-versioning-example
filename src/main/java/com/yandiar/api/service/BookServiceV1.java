package com.yandiar.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yandiar.api.models.Book;


@Service
public class BookServiceV1 {
    
    List<Book> lstBook = new ArrayList<>(
        Arrays.asList(
            new Book(1, "Negeri Para Bedebah", "Tere Liye"),
            new Book(2, "Beyond The Inspiration", "Felix Siauw"),
            new Book(3, "Sang Pangeran", "Salim A Fillah")
        )
    );

    public List<Book> getAll() {
        return lstBook;
    }

    public List<Book> addBook(Book book) {

        lstBook.add(book);
        return lstBook;
    }
}
