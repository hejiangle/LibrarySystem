package com.biblioteca.utils;

import com.biblioteca.models.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessagePrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    @BeforeEach
    public void setUpStream(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void printCorrectMessage(){
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Xi'an!\n";
        MessagePrinter.welcome();
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void printBookTable(){
        List<Book> books = Arrays.asList(new Book("Test","Author", 2020));
        MessagePrinter.bookTable(books);

        assertEquals("| Index | Book Name | Author | Published Year |\n| 1 | Test | Author | 2020 |\n", outContent.toString());
    }

    @AfterEach
    public void resetStream(){
        System.setOut(original);
    }
}