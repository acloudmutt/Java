package BankAccountApp;

public class SavingsAccount extends BankAccount {

    private double interestRate;

    public void applyInterest() {
        deposit(getBalance() * interestRate);
    }

    public double getInterestRate() {
        return interestRate;
    }

    //@Override
    public void displayAccount() {

        System.out.printf("%-9s %-6d %-20s %6.2f %6.2f %n", "Savings,", getAccountNumber(), getAccountHolder(), getBalance(), interestRate);
    }

    SavingsAccount() {
        System.out.println("SavingsAccount");
        interestRate = 0.03;
    }

    public SavingsAccount( int an, String ah, double b) {
        super(an, ah, b);
        interestRate = 0.03;
    }

    public SavingsAccount( int an, String ah, double b, double r) {
        super(an, ah, b);
        interestRate = r;
    }
    
}
