package com.biblioteca.utils;

import com.biblioteca.models.Book;

import java.text.MessageFormat;
import java.util.List;

public class MessagePrinter {
    private final static String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Xi'an!";
    private final static String TABLE_TITLE = "| Index | Book Name |";
    private final static String TABLE_TEMPLATE = "| {0} | {1} |";

    public static void welcome(){
        System.out.println(WELCOME_MESSAGE);
    }

    public static void bookTable(List<Book> books){
        System.out.println(TABLE_TITLE);
        books.forEach(x -> System.out.println(MessageFormat.format(TABLE_TEMPLATE, books.indexOf(x) + 1 , x.getName())));
    }

}
