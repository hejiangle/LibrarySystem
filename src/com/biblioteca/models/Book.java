package com.biblioteca.models;

public class Book {
    private final String name;

    public Book(String bookName) {
        this.name = bookName;
    }

    public String getName() {
        return this.name;
    }
}
