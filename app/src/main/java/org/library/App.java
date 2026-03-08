package org.library;

import java.io.IOException;
import java.util.Scanner;

public class App {
    static Scanner read;

    public static Scanner getRead(){
        if (read == null) {
            read = new Scanner(System.in);
        }
        return read;
    }

    public void greeting() {
        System.out.println("Welcome to the Console based Library System");
    }

    public int serveMenu() {
        Scanner localRead = App.getRead();
        ConsoleMenu[] menuList = ConsoleMenu.values();
        for (ConsoleMenu value: menuList) {
            System.out.println(value.desc);
        }
        return Integer.parseInt(read.nextLine());
    }
    public static void main(String[] args) {
        App instance = new App();
        Scanner instanceRead = App.getRead();
        instance.greeting();

        System.out.println("Enter your name");
        String userName = instanceRead.nextLine();

        int userChoice = instance.serveMenu();
        switch(userChoice) {
            case 1 : {
                try {
                    RegisterFileHandler.writeUser(LibrarySystem.getLibraryInstance(userName));
                } catch (IOException e) {
                    System.out.println(e);
                }
                break;
            }
        }
    }
}
