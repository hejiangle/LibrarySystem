package com.biblioteca;

import com.biblioteca.models.Action;
import com.biblioteca.services.Menu;
import com.biblioteca.utils.MessagePrinter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
	    //1. Print welcome message
        MessagePrinter.welcome();
        //4. Refactor code to add menu to list all actions
        Menu menu = new Menu();
        menu.show();
        while (input.hasNextInt()){
            Action option = Action.values()[input.nextInt() - 1];

            try {
                menu.execute(option);
            } catch (Exception e){
                MessagePrinter.printMessage(e.getMessage());
            }
        }
        //5. Invalid option should have notification
        //6. Quit the application
    }
}
