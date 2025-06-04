import exception.InsufficientFundsException;

public class SavingsAccount extends Account {

    public SavingsAccount(String accountNumber, double balance, String pin) {
        super(accountNumber, balance, pin);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        // Lógica específica para SavingsAccount...
        if (amount > getBalance()) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }else if (amount < getBalance()) {
            double newBalance = getBalance() - amount;
            // Aquí se actualizaría el balance en la clase padre
            setBalance(newBalance);
        } else {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
    }

    @Override
    public void deposit(double amount) {
        // Lógica específica para SavingsAccount...
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        } else {
            double newBalance = getBalance() + amount;
            // Aquí se actualizaría el balance en la clase padre
            setBalance(newBalance);
        }
    }
}