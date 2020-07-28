package com.biblioteca.models;

public class Book {
    private final String name;
    private final String author;
    private final int publishedYear;
    private boolean isAvailable;

    public Book(String bookName, String author, int publishedYear) {
        this.name = bookName;
        this.author = author;
        this.publishedYear = publishedYear;
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
