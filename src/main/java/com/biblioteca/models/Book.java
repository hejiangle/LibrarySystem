package com.biblioteca.models;

import java.time.Year;

public class Book {
    private final String name;
    private final String author;
    private final Year publishedYear;
    private boolean isAvailable;

    public Book(String bookName, String author, int publishedYear) {
        this.name = bookName;
        this.author = author;
        this.publishedYear = Year.of(publishedYear);
        this.isAvailable = true;
    }

    public String getName() {
        return this.name;
    }

    public void rent() { this.isAvailable = false; }

    public boolean isAvailable(){
        return this.isAvailable;
    }

    @Override
    public String toString() {
        return "| {0} | " + this.name + " | " + this.author + " | " + this.publishedYear + " |";
    }
}
