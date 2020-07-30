package com.biblioteca.services;

import com.biblioteca.models.Action;
import com.biblioteca.repositories.BookRepository;
import com.biblioteca.repositories.BookRepositoryImp;
import com.biblioteca.utils.MessagePrinter;

import java.util.Scanner;

public class Menu {
    private final BookRepository bookRepository = new BookRepositoryImp();
    private final BookService bookService = new BookService(bookRepository);

    public void show(){
        MessagePrinter.printMenu(Action.values());
    }

    public void execute(Action action) throws Exception {
        switch (action) {
            case ListingBooks:
                MessagePrinter.bookTable(bookService.listAvailableBooks());
                break;
            case RentBook:
                MessagePrinter.rentBook();
                Scanner sc = new Scanner(System.in);
                boolean isRentFinished = false;
                while (sc.hasNextLine() && !isRentFinished){
                    String bookName = sc.nextLine();
                    try {
                        bookService.rentBook(bookName);
                        isRentFinished = true;
                        MessagePrinter.printMessage("Renting book succeed.");
                    } catch (Exception e){
                        MessagePrinter.printMessage("Renting book failed.");
                        MessagePrinter.printMessage(e.getMessage());
                    }
                }
                break;
            case Exit:
                MessagePrinter.printMessage("Bye~");
                System.exit(0);
            default:
                throw new Exception("Please select a valid option!");
        }
    }

}
