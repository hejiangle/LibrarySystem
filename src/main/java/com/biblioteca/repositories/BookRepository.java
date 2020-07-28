package com.biblioteca.repositories;

import com.biblioteca.models.Book;

import java.util.List;

public interface BookRepository {
    List<Book> listAllBooks();
}
