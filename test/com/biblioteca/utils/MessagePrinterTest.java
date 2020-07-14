package com.biblioteca.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

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

    @AfterEach
    public void resetStream(){
        System.setOut(original);
    }
}