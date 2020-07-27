package com.biblioteca.models;

public class Book {
    private final String name;
    private final String author;
    private final int publishedYear;

    public Book(String bookName, String author, int publishedYear) {
        this.name = bookName;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "| {0} | " + this.name + " | " + this.author + " | " + this.publishedYear + " |";
    }
}
