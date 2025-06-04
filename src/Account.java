import exception.InsufficientFundsException;
import exception.InvalidAccountException;

public class Account {
    private String accountNumber;
    private double balance;
    private String pin;

    public Account(String accountNumber, double balance, String pin) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void transferFunds(String targetAccountNumber, double amount)
            throws InsufficientFundsException, InvalidAccountException {
        if (balance < amount) {
            throw new InsufficientFundsException("Fondos insuficientes");
        }
        if (!Bank.isValidAccount(targetAccountNumber)) {
            throw new InvalidAccountException("Cuenta destino no válida");
        }
        balance -= amount;
        Bank.getAccount(targetAccountNumber).deposit(amount);
    }
}