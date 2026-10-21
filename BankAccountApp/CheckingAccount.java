package BankAccountApp;

public class CheckingAccount extends BankAccount{

    private double overdraftFee;

    public double getoverdraftFee() {
        return overdraftFee;
    }

    CheckingAccount() {
        System.out.println("CheckingAccount");
    }

    public CheckingAccount( int an, String ah, double b) {
        super(an, ah, b);
        overdraftFee = 3;
    }    
}
