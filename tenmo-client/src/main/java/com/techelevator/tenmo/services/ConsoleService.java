package com.techelevator.tenmo.services;


import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserCredentials;

import java.math.BigDecimal;
import java.net.UnknownServiceException;
import java.util.List;
import java.util.Scanner;

public class ConsoleService {
    private String API_BASE_URL = "http://localhost:8080/";
    private final Scanner scanner = new Scanner(System.in);
    private final AccountService accountService = new AccountService(API_BASE_URL);
    private User user = new User();

    public int promptForMenuSelection(String prompt) {
        int menuSelection;
        System.out.print(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void printGreeting() {
        System.out.println("*********************");
        System.out.println("* Welcome to TEnmo! *");
        System.out.println("*********************");
    }

    public void printLoginMenu() {
        System.out.println();
        System.out.println("1: Register");
        System.out.println("2: Login");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printMainMenu() {
        System.out.println();
        System.out.println("1: View your current balance");
        System.out.println("2: View your past transfers");
        System.out.println("3: View your pending requests");
        System.out.println("4: Send TE bucks");
        System.out.println("5: Request TE bucks");
        System.out.println("0: Exit");
        System.out.println();
    }


    public void printBalance(BigDecimal bigDecimal){
       System.out.println("Your current account balance is: " + bigDecimal);
    }

    public void printUserList(User[] users) {
        User[] userArray = new User[users.length];
        System.out.println("--------------------");
        System.out.println("Users");
        System.out.printf( "ID"+"           " + "NAME");
        System.out.println();
        System.out.println("--------------------");


        for (User user : users) {
            System.out.println(user.getId() + "          " + user.getUsername());
            //if(user.getUsername() == promptForCredentials().getUsername())






    }
        System.out.println("Enter ID of user you are sending to (0 to cancel): ");
        String userId = scanner.nextLine();
        System.out.println("Enter amount:");
        String userAmount = scanner.nextLine();

        Double newAmount = Double.parseDouble(userAmount);
        if(newAmount <= 0){
            System.out.println("Please enter a positive number");
        }


    }
    public UserCredentials promptForCredentials() {
        String username = promptForString("Username: ");
        String password = promptForString("Password: ");
        return new UserCredentials(username, password);
    }

    public String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int promptForInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public BigDecimal promptForBigDecimal(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a decimal number.");
            }
        }
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }

}
