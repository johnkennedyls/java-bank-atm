import exception.InsufficientFundsException;
import exception.InvalidAccountException;

import java.util.HashMap;
import java.util.Map;

public class ATM {
    private Map<String, Account> accounts;

    public ATM() {
        accounts = new HashMap<>();
    }

    public void performTransfer(String sourceAccountNumber, String targetAccountNumber, double amount) {
        try {
            accounts.get(sourceAccountNumber).transferFunds(targetAccountNumber, amount);
            System.out.println("Transferencia exitosa");
        } catch (InvalidAccountException | InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Registro de la transacción
            if (accounts.containsKey(targetAccountNumber)) {
                System.out.println("Registro de transacción: " + amount + " transferidos de " + sourceAccountNumber + " a " + targetAccountNumber);
            } else {
                System.out.println("No se pudo registrar la transacción, cuenta destino no válida.");
            }
        }
    }
}
