package com.biblioteca.repositories;

import com.biblioteca.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookRepositoryTest {
    private BookRepository bookRepository;

    @BeforeEach
    public void setUpTestData(){
        Book bookOne = new Book("Iron Man");
        Book bookTwo = new Book("Superman");
        List<Book> books = Arrays.asList(bookOne, bookTwo);

        bookRepository = new BookRepositoryImp(books);
    }

    @Test
    public void givenSomeBooksWhenListAllBooksThenBookServiceReturnTheBookList(){
        List<Book> result = bookRepository.listAllBooks();

        assertEquals(2, result.size());
        assertEquals("Iron Man", result.get(0).getName());
        assertEquals("Superman", result.get(1).getName());
    }
}