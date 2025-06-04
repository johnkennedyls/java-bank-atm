import contract.Authenticatable;
import exception.InsufficientFundsException;

public abstract class Account implements Authenticatable {
    private String accountNumber;
    private double balance;
    private String pin;

    public Account(String accountNumber, double balance, String pin) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public abstract void withdraw(double amount) throws InsufficientFundsException;
    public abstract void deposit(double amount);

    @Override
    public boolean authenticate(String pin) {
        return this.pin.equals(pin);
    }

    public void setBalance(double newBalance) {
        if (newBalance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = newBalance;
    }
}


