package company.mail;

import company.mail.*;

import java.util.Scanner;

public class Main extends mail {
    public static Scanner scan = new Scanner(System.in);
    public static boolean running;
    public static String dummyUser = "user";
    public static String dummyPassword = "Password";


    public static void viewMail()
    {
        boolean mailwork = true;
        do {

            System.out.println("Here is your mail");
            System.out.println("1. from | Subject | datetime release");
            System.out.println("2. from | Subject | datetime release");
            System.out.println("3. from | Subject | datetime release");
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
            System.out.println("Welcome " + dummyUser + ". what would you like to do?");
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
                    System.out.println("System in the works");
                    break;
                }
                case ("3"): {
                    System.out.println("Logging out");
                    viewingMail = false;
                    break;
                }
                case ("4"): {
                    System.out.println("Good bye");
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
        if (userNameToTest.equals(dummyUser) && userPassword.equals(dummyPassword)) {
            System.out.println("You Successfully logged in");
            mailSystem();
        } else {
            System.out.println("Loggin was incorrect");
        }
    }

    public static void main(String[] args) {
        do {
            System.out.println("\n" + "Welcome To CodeCrew Mailers");
            System.out.println("What would you like to do?");
            System.out.println("1. Create a new use");
            System.out.println("2. Log into your account");
            System.out.println("3. Exit project");
            String userCommand = scan.next();

            switch (userCommand) {
                case ("1"): {
                    System.out.println("System in the work");
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