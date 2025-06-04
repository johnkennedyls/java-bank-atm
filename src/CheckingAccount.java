import exception.InsufficientFundsException;

public class CheckingAccount extends Account {

    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > getBalance() + overdraftLimit) {
            throw new InsufficientFundsException("Withdrawal exceeds overdraft limit.");
        }
        super.withdraw(amount);
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}
