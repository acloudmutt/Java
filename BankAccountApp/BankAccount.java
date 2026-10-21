package BankAccountApp;

public class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if(amount > 0) {
            if(balance > amount) {
                balance -= amount;
            }
        }
    }

    public void displayAccount() {

        System.out.printf("%-6d %-20s %6.1f %n", accountNumber, accountHolder, balance);
    }
    

    BankAccount( int an, String ah, double b) {
        accountNumber = an;
        accountHolder = ah;
        balance = b;
    }

    BankAccount() {

        accountNumber = 0;
        accountHolder = "";
        balance = 0;
        System.out.println("BankAccount");
    }

}
