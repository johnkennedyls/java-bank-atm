import exception.InsufficientFundsException;

public class CheckingAccount extends Account {

    public CheckingAccount(String accountNumber, double balance, String pin) {
        super(accountNumber, balance, pin);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > getBalance()) {
            throw new InsufficientFundsException( "Insufficient funds for withdrawal.");
        }
        // Lógica específica de retiro...
        double newBalance = getBalance() - amount;
    }

    @Override
    public void deposit(double amount) {
        // Implementación de depósito...
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }else if (amount > getBalance()) {
            throw new IllegalArgumentException("Deposit amount exceeds account balance.");
        } else {
            double newBalance = getBalance() + amount;
            // Aquí se actualizaría el balance en la clase padre
             setBalance(newBalance);  
        }
    }

    public void setBalance(double newBalance) {
        if (newBalance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        super.setBalance(newBalance);
    }
}
