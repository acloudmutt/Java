package BankAccountApp;

import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountApp {

    public static ArrayList<BankAccount> accounts = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

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

    public static int selectAccount() {
        int choice = -1;
        boolean done = false;        

        do{
            if(accounts.isEmpty()) {
                System.out.println("No accounts exist\n");                
                done = true;
                continue;                
            }
            System.out.println("Select account: ");
            for(int i = 0; i < accounts.size(); i++) {
                BankAccount ba = accounts.get(i);
                System.out.printf("%-2d %-6d %-20s %6.2f %n", i+1, ba.getAccountNumber(), ba.getAccountHolder(), ba.getBalance());
            }
            
            if(scanner.hasNext()) {
                choice = scanner.nextInt();
                if((choice > 0) && (choice <= accounts.size())) {
                    done = true;
                }
            }else {
                System.out.println("Invalid input. Enter a number.");
                scanner.next();     // Consume invalid token                
                continue;
            }
        }while (!done);       
        if(choice > 0) {
            choice -= 1;
        }
        return choice;
    }

    public static int getNewAccountNumber() {
        int number = 0;
        if(accounts.isEmpty()) {
            number = 1000;
        }else{
            BankAccount ba = accounts.get(accounts.size() - 1);
            number = ba.getAccountNumber();
            number += 1;
        }
        return number;
    }

    public static void initializeAccounts()
    {
        int number = getNewAccountNumber();        
        CheckingAccount ca = new CheckingAccount(number, "Smith, John", 0);        
        System.out.printf("%-6d %-20s %6.2f %6.2f %n", ca.getAccountNumber(), ca.getAccountHolder(), ca.getBalance(), ca.getoverdraftFee());
        accounts.add(ca);

        number = getNewAccountNumber();        
        ca = new CheckingAccount(number, "Stewart, Rod", 100.25);        
        System.out.printf("%-6d %-20s %6.2f %6.2f %n", ca.getAccountNumber(), ca.getAccountHolder(), ca.getBalance(), ca.getoverdraftFee());
        accounts.add(ca);

        number = getNewAccountNumber();  
        SavingsAccount sa = new SavingsAccount(number, "Langevin, Murphy", 500.25);        
        System.out.printf("%-6d %-20s %6.2f %6.2f %n", number, sa.getAccountHolder(), sa.getBalance(), sa.getInterestRate());
        accounts.add(sa);
    }
    
    public static void main(String[] args) {
        
        int choice, number, choice1;

        initializeAccounts();

        do {
            displayMenu();

            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();                
            } else {
                System.out.println("Invalid input. Enter a number.");                
                choice = -1;
                scanner.next();     // Consume invalid token 
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Create Checking Account");

                    number = getNewAccountNumber();
                    //System.out.printf("%-6d\n", number);
                    CheckingAccount ca = new CheckingAccount(number, "Gabriel, Peter", 0);        
                    System.out.printf("%-6d %-20s %6.2f %6.2f %n", ca.getAccountNumber(), ca.getAccountHolder(), ca.getBalance(), ca.getoverdraftFee());
                    accounts.add(ca);
                    break;

                case 2:
                    System.out.println("Create Savings Account");

                    number = getNewAccountNumber();
                    //System.out.printf("%-6d\n", number);
                    SavingsAccount sa = new SavingsAccount(number, "Doe, Jane", 0);        
                    System.out.printf("%-6d %-20s %6.1f %6.1f %n", number, sa.getAccountHolder(), sa.getBalance(), sa.getInterestRate());
                    accounts.add(sa);
                    break;

                case 3:
                    System.out.println("Deposit Money");
                    choice1 = selectAccount();
                    if(choice1 >= 0) {                        
                        System.out.printf("Enter amount:  ");
                        
                        double dvalue = scanner.nextDouble();                        
                        //System.out.printf("amount:  %-6.2f\n", dvalue);
                        
                        if (dvalue > 0) {
                            accounts.get(choice1).deposit(dvalue);
                        }
                        System.out.printf("%-6d %-20s %-6.2f \n", accounts.get(choice1).getAccountNumber(), accounts.get(choice1).getAccountHolder(), accounts.get(choice1).getBalance());
                       
                    }
                    break;

                case 4:
                    System.out.println("Withdraw Money");
                    choice1 = selectAccount();
                    //System.out.printf("%-6d\n", choice1);
                    if(choice1 >= 0) {                        
                        System.out.printf("Enter amount:  ");
                        
                        double dvalue = scanner.nextDouble();                        
                        //System.out.printf("amount:  %-6.2f\n", dvalue);
                        
                        if (dvalue > 0) {
                            try {                            
                                accounts.get(choice1).withdraw(dvalue);
                            } catch (InsufficientFundsException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        System.out.printf("%-6d %-20s %-6.2f \n", accounts.get(choice1).getAccountNumber(), accounts.get(choice1).getAccountHolder(), accounts.get(choice1).getBalance());
                    }
                    break;

                case 5:
                    System.out.println("Display Account Information");
                    choice1 = selectAccount();
                    if(choice1 >= 0) { 
                        accounts.get(choice1).displayAccount();
                    }
                    break;

                case 6:
                    System.out.println("Display All Acccounts");

                    for(int i = 0; i < accounts.size(); i++) {
                        BankAccount ba = accounts.get(i);
                        //System.out.printf("%-6d %-20s %6.2f %n", ba.getAccountNumber(), ba.getAccountHolder(), ba.getBalance());
                        ba.displayAccount();
                    }
                    break;

                case 7:
                    System.out.println("Apply Savings Interest1");
                    choice1 = selectAccount();
                    if(choice1 >= 0) { 
                        BankAccount ba = accounts.get(choice1);
                        if(ba instanceof SavingsAccount) {
                            SavingsAccount savings = (SavingsAccount) ba;
                            savings.applyInterest();
                        } else {
                            System.out.println("Interest applies only to savings accounts.");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        scanner.close();        
    }
}