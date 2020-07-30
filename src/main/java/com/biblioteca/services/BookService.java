package com.biblioteca.services;

import com.biblioteca.models.Book;
import com.biblioteca.repositories.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> listAvailableBooks(){
        return bookRepository.listAllBooks().stream().filter(Book::isAvailable).collect(Collectors.toList());
    }

    public void rentBook(String bookName) throws Exception{
        Book book = bookRepository.findBookByName(bookName);
        book.rent();
    }
}
