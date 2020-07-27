package com.biblioteca;

import com.biblioteca.models.Book;
import com.biblioteca.repositories.BookRepository;
import com.biblioteca.repositories.BookRepositoryImp;
import com.biblioteca.utils.MessagePrinter;

import java.util.List;

public class Main {
    private static final BookRepository BOOK_REPOSITORY = new BookRepositoryImp();

    public static void main(String[] args) {
	    //1. Print welcome message
        MessagePrinter.welcome();
        //2. Display all library books
        List<Book> books = BOOK_REPOSITORY.listAllBooks();
        MessagePrinter.bookTable(books);
        //3. Enrich the booking model
        //4. Refactor code to add menu to list all actions
        //5. Invalid option should have notification
        //6. Quit the application
    }
}
