package test.com.biblioteca.repositories;

import com.biblioteca.models.Book;
import com.biblioteca.repositories.BookRepository;
import com.biblioteca.repositories.BookRepositoryImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {
    private BookRepository bookRepository;

    @BeforeEach
    public void setUpTestData(){
        Book bookOne = new Book("Iron Man", "Stan Lee", 1970);
        Book bookTwo = new Book("Superman", "Jerry Siegel, Joe Shuster, Wayne Boring", 1938);
        List<Book> books = Arrays.asList(bookOne, bookTwo);

        bookRepository = new BookRepositoryImp(books);
    }

    @Test
    void givenSomeBooksWhenListAllBooksThenBookServiceReturnTheBookList(){
        List<Book> result = bookRepository.listAllBooks();

        assertEquals(2, result.size());
        assertEquals("Iron Man", result.get(0).getName());
        assertEquals("Superman", result.get(1).getName());
    }

    @Test
    void givenBookNameWhenCallFindBookByNameShouldReturnThenSameNameBook() throws Exception {
        Book book = bookRepository.findBookByName("Iron Man");

        assertEquals("Iron Man", book.getName());
        assertTrue(book.isAvailable());
    }

    @Test
    void givenNotExistBookNameWhenCallFindBookByNameShouldThrowsException(){
        assertThrows(Exception.class, () -> {
            bookRepository.findBookByName("Not exist book");
        });
    }
}