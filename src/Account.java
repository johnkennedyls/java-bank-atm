import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println("Depósito realizado: " + amount + ", Saldo actual: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        lock.lock();
        try {
            if(balance >= amount) {
                balance -= amount;
                System.out.println("Retiro realizado: " + amount + ", Saldo actual: " + balance);
            } else {
                throw new InsufficientFundsException("Fondos insuficientes");
            }
        } finally {
            lock.unlock();
        }
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
