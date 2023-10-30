package org.example;

import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class AtmInterface {
    private static final String validuserid = "12345";
    private static final String validuserpin = "6789";
    private static double balance = 1000.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Welcome to the atm! ");

        while (true){
            System.out.print("Please enter your userId: ");
            String userid = sc.next();
            System.out.print("Please enter your userPin: ");
            String userPin = sc.next();

            if (authenticateUser(userid, userPin)) {
                displayMenu();
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> TranscationHistory();
                    case 2 -> Withdraw();
                    case 3 -> Deposit();
                    case 4 -> Transfer();
                    case 5 -> Quit();
                    default -> System.out.println("Invalid choice please try again");
                }

            }
            }
        }

    private static void Quit() {
        System.out.println("Thank you for using the ATM.");
        System.exit(0);
    }

    private static void Transfer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount to transfer: ");
        double amounttransfer = scanner.nextDouble();
        System.out.println("Enter the Account no. of Receiver: ");
        int accountdetail = scanner.nextInt();
        System.out.println("Amount Transferred Successfully || " + " Amount: " + amounttransfer + " || Account number: " + accountdetail);
        System.out.println();

    }

    private static void Deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount to deposit: ");
        Double depositamount = scanner.nextDouble();
        if (depositamount <= 0){
            System.out.println("Invalid amount. Please enter a positive value.");
        }
        else {
            double balance1 = balance + depositamount;
            System.out.println();
            System.out.println("Deposit successful. Your new balance is: " + balance1);
            System.out.println();
        }

        }



    private static void Withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount <= 0){
            System.out.println("Invalid amount. Please Enter a valid amount");
        }
        else if (amount > balance){
            System.out.println("Insufficient balance.");
        }
        else {
           int  balance1 = (int) (balance - amount);
            System.out.println();
            System.out.println("Withdrawal successful. Your new balance is: " + balance1);
            System.out.println();
        }

    }

    private static void TranscationHistory() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your userPin: ");
        String Transactionpin = sc.next();
        int withdrawal = 200;
        int deposit = 300;
        int balance1 = (int) (balance - withdrawal + deposit);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


        if (validuserpin.equals(Transactionpin)){
            System.out.println();
            System.out.println("<<< Transaction History >>>");
            System.out.println("Date: " + java.time.LocalDate.now() + " Time: " + dateTimeFormatter.format(LocalTime.now()));
            System.out.println("Withdrawal Amount: " + withdrawal);
            System.out.println("Deposit Amount: " + deposit);
            System.out.println("Balance Amount: " + balance1);
            System.out.println();
        }
        else {
            System.out.println();
            System.out.println("userpin is incorrect !!  please inter valid userpin");
            System.out.println();
        }

    }

    private static void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1: Transactions History");
        System.out.println("2: Withdraw");
        System.out.println("3: Deposit");
        System.out.println("4: Transfer");
        System.out.println("5: QUIT");
        System.out.print("Please inter your choice: ");
        System.out.println();
    }

    private static boolean authenticateUser(String userid, String userPin) {
        return validuserid.equals(userid) && validuserpin.equals(userPin);
    }


}
