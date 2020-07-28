package com.biblioteca.repositories;

import com.biblioteca.models.Book;

import java.util.Arrays;
import java.util.List;

public class BookRepositoryImp implements BookRepository {
    private final List<Book> originalBooks = Arrays.asList(
            new Book("Head First Java", "Bert Bates and Kathy Sierra", 2003),
            new Book("Design Pattern", " Erich Gamma, John Vlissides, Ralph Johnson, Richard Helm", 1994));
    private final List<Book> books;

    public BookRepositoryImp(){
        this.books = originalBooks;
    }

    public BookRepositoryImp(List<Book> books) {
        this.books = books;
    }

    @Override
    public List<Book> listAllBooks() {
        return  books.isEmpty() ? originalBooks : books;
    }
}
