package BankAccountApp;

public class CheckingAccount extends BankAccount{

    private double overdraftFee;

    public double getoverdraftFee() {
        return overdraftFee;
    }

    public void withdraw(double amount) {
        if(amount >= getBalance()) {
            dowithdrawl(amount);
        }else{
            if(getBalance() >= overdraftFee) {
                dowithdrawl(amount);
            }
        }
    }

    CheckingAccount() {
        System.out.println("CheckingAccount");
    }

    public CheckingAccount( int an, String ah, double b) {
        super(an, ah, b);
        overdraftFee = 3;
    }    
}
