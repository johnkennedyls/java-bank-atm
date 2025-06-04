import contract.AuthStrategy;
import contract.Transaction;
import exception.InsufficientFundsException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ATM {
    private Map<String, Account> accounts = new HashMap<>();
    private AuthStrategy authStrategy;
    private double balance;

    public ATM(AuthStrategy authStrategy) {
        this.authStrategy = authStrategy;
    }

    public void addAccount(String accountNumber, Account account) {
        accounts.put(accountNumber, account);
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("Fondos insuficientes");
        }
        balance -= amount;
    }

    public void performTransaction(String accountNumber, Transaction.TransactionType type, double amount) {
        try {
            if (type == Transaction.TransactionType.WITHDRAWAL) {
                SavingsAccount account = (SavingsAccount) accounts.get(accountNumber);
                account.withdraw(amount);
                System.out.println("Retiro exitoso");
            }
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Registro de la transacción
        }
    }

    public void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }


}