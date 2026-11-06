package BankAccountApp;

public class CheckingAccount extends BankAccount{

    private double overdraftFee;

    public double getoverdraftFee() {
        return overdraftFee;
    }

    public void withdraw(double amount) 
        throws InsufficientFundsException {

        if (amount <= 0) {
        throw new IllegalArgumentException(
            "Withdrawal amount must be positive");
        }

        if (amount > getBalance()) {
            double fee = Math.min(overdraftFee, getBalance());

            try {
                super.withdraw(fee);
            } catch (InsufficientFundsException e) {
                throw new IllegalStateException(e);
            }

            throw new InsufficientFundsException(
                "Insufficient funds. Overdraft fee: $" + fee);
        }

        super.withdraw(amount);
    }

    //@Override
    public void displayAccount() {

        System.out.printf("%-9s %-6d %-20s %6.2f %6.2f %n", "Checking,", getAccountNumber(), getAccountHolder(), getBalance(), overdraftFee);
    }

    CheckingAccount() {
        System.out.println("CheckingAccount");
    }

    public CheckingAccount( int an, String ah, double b) {
        super(an, ah, b);
        overdraftFee = 3;
    }    
}


