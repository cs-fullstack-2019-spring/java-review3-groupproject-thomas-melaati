package company.mail;

import company.mail.*;

import java.util.Scanner;

public class Main extends mail {

    public static Scanner scan = new Scanner(System.in);
    public static boolean running;
    public static String Username;
    public static int userID;


    public static void viewMail()
    {
        boolean mailwork = true;
        do {

            mail.viewYourMail(userID);
            System.out.println("enter a number to view or exit to return");
            String mailCommand = scan.next();
            if (mailCommand.equalsIgnoreCase("exit")) {
                mailwork = false;
            }
            else
                {
                    System.out.println("Command in the works");
                }
        }
        while (mailwork);

    }

    public static void mailSystem() {
        boolean viewingMail = true;
        do {
            System.out.println("Welcome " + Username + ". what would you like to do?");
            System.out.println("1. View Your mail.");
            System.out.println("2. Write a new message");
            System.out.println("3. log out");
            System.out.println("4. exit");
            String userInterface = scan.next();
            switch (userInterface) {
                case ("1"): {
                    viewMail();
                    break;
                }
                case ("2"): {
                    mail.createNewCodeCrewMail(userID);
                    break;
                }
                case ("3"): {
                    System.out.println("Logging out");
                    viewingMail = false;
                    Username = null;
                    userID = 0;
                    break;
                }
                case ("4"): {
                    System.out.println("Good bye");
                    Username = null;
                    viewingMail = false;
                    running =true;
                    break;
                }
            }
        }
        while (viewingMail);
    }

    public static void Loggin() {
        System.out.println("Welcome To LogIn");
        System.out.println("Please Enter Your Username");
        String userNameToTest = scan.next();
        System.out.println("Please Enter Password");
        String userPassword = scan.next();
         userID = user.UserVerification(userNameToTest,userPassword);
        if (userID != 0) {
            System.out.println("You Successfully logged in");
            Username = userNameToTest;
            mailSystem();
        } else {
            System.out.println("Loggin was incorrect");
        }
    }

    public static void main(String[] args) {
        do {
            System.out.println("\n" + "Welcome To CodeCrew Mailers");
            System.out.println("What would you like to do?");
            System.out.println("1. Create a new user");
            System.out.println("2. Log into your account");
            System.out.println("3. Exit project");
            String userCommand = scan.next();

            switch (userCommand) {
                case ("1"): {
                    user.createNewUser();
                    break;
                }
                case ("2"): {
                    Loggin();
                    break;
                }
                case ("3"): {
                    System.out.println("GoodBye");
                    running = true;
                    break;
                }
                default: {
                    System.out.println("Not A valid Command");
                    break;
                }
            }

        }
        while (!running);
    }
}