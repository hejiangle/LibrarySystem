package com.biblioteca.utils;

import com.biblioteca.models.Action;
import com.biblioteca.models.Book;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

public class MessagePrinter {
    private final static String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Xi'an!";
    private final static String TABLE_TITLE = "| Index | Book Name | Author | Published Year |";
    private final static String MENU_MESSAGE_ONE = "Biblioteca provides following options for you:";
    private final static String MENU_MESSAGE_TWO = "Give your selection option number bellow:";
    private final static String RENT_MESSAGE = "Please input the book name which you want to rent:";
    private final static String ACTION_OPTION_TEMPLATE = "{0}. {1}";

    public static void welcome(){
        System.out.println(WELCOME_MESSAGE);
    }

    public static void bookTable(List<Book> books){
        System.out.println(TABLE_TITLE);
        books.forEach(x -> System.out.println(MessageFormat.format(x.toString(), books.indexOf(x) + 1)));
    }

    public static void rentBook(){
        System.out.println(RENT_MESSAGE);
    }

    public static void printMenu(Action[] values) {
        System.out.println(MENU_MESSAGE_ONE);

        List<Action> actions = Arrays.asList(values);
        actions.forEach(action -> System.out.println(MessageFormat.format(ACTION_OPTION_TEMPLATE, actions.indexOf(action) + 1, action.name())));
    }

    public static void printNext(){
        System.out.println(MENU_MESSAGE_TWO);
    }

    public static void printMessage(String message){
        System.out.println(message);
    }
}
