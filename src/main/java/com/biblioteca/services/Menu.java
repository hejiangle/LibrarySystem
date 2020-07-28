package com.biblioteca.services;

import com.biblioteca.models.Action;
import com.biblioteca.repositories.BookRepository;
import com.biblioteca.repositories.BookRepositoryImp;
import com.biblioteca.utils.MessagePrinter;

public class Menu {
    private final BookRepository bookRepository = new BookRepositoryImp();

    public void show(){
        MessagePrinter.printMenu(Action.values());
    }

    public void execute(Action action) throws Exception {
        switch (action) {
            case ListingBooks:
                MessagePrinter.bookTable(bookRepository.listAllBooks());
                break;
            case Exit:
                MessagePrinter.printMessage("Bye~");
                System.exit(0);
            default:
                throw new Exception("Please select a valid option!");
        }
    }

}
