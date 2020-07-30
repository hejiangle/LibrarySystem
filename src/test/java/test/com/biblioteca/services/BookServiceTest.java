package test.com.biblioteca.services;

import com.biblioteca.models.Book;
import com.biblioteca.repositories.BookRepository;
import com.biblioteca.repositories.BookRepositoryImp;
import com.biblioteca.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


class BookServiceTest {
    private BookService bookService;
    private BookRepository mockBookRepository;

    @BeforeEach
    public void setUp(){
        mockBookRepository = mock(BookRepositoryImp.class);
        bookService = new BookService(mockBookRepository);
    }

    @Test
    public void givenBooksListWhenCallListAvailableBooksShouldReturnAvailableBooks(){
        Book bookOne = new Book("un-rent-book", "author", 2020);
        Book bookTwo = new Book("renting-book", "author", 2020);
        bookTwo.rent();
        List<Book> books = Arrays.asList(bookOne, bookTwo);
        when(mockBookRepository.listAllBooks()).thenReturn(books);

        List<Book> result = bookService.listAvailableBooks();

        assertEquals(1, result.size());
        assertEquals(bookOne, result.get(0));
    }

    @Test
    public void givenBooksWhenRentABookShouldSetThatBookIsNotAvailable() throws Exception {
        Book book = new Book("renting-book", "author", 2020);
        when(mockBookRepository.findBookByName("renting-book")).thenReturn(book);

        bookService.rentBook("renting-book");

        assertFalse(book.isAvailable());
    }
}