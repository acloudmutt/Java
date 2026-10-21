package BankAccountApp;

import java.util.Scanner;

public class BankAccountApp {

     public static void displayMenu() {
        System.out.println("\n=========================");
        System.out.println("       BANK ACCOUNT SYSTEM");
        System.out.println("=========================");
        System.out.println("1. Create Checking Account");
        System.out.println("2. Create Savings Account");
        System.out.println("3. Deposit Money");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Display Account Information");
        System.out.println("6. Display All Acccounts");
        System.out.println("7. Apply Savings Interest");
        System.out.println("0. Exit");
        System.out.println("=========================");
    }
    
    public static void main(String[] args) {
        //System.out.println("BankAccountApp");

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();

            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Create Checking Account");
                    break;

                case 2:
                    System.out.println("Create Savings Account");
                    break;

                case 3:
                    System.out.println("Deposit Money");
                    break;

                case 4:
                    System.out.println("Withdraw Money");
                    break;

                case 5:
                    System.out.println("Display Account Information");
                    break;

                case 6:
                    System.out.println("Display All Acccounts");
                    break;

                case 7:
                    System.out.println("Apply Savings Interest1");
                    break;

                case 0:
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        scanner.close();

        //BankAccount ba = new BankAccount(1234, "Smith, John", 0);
        //BankAccount ba = new BankAccount();
        //System.out.printf("%-6d %-20s %6.1f %n", ba.getAccountNumber(), ba.getAccountHolder(), ba.getBalance());
    }
}