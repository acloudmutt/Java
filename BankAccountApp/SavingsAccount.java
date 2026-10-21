package BankAccountApp;

public class SavingsAccount extends BankAccount {

    private double interestRate;

    public void applyInterest() {

    }

    public double getInterestRate() {
        return interestRate;
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
