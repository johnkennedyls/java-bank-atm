import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ATM {
    private Map<String, Account> accounts;

    public ATM() {
        accounts = new HashMap<>();
        // Inicializa con algunas cuentas
    }

    public CompletableFuture<Void> updateUserBalanceAsync(String accountNumber, double amount) {
        return CompletableFuture.runAsync(() -> {
            Account account = accounts.get(accountNumber);
            synchronized (account) {
                double newBalance = account.getBalance() + amount;
                account.setBalance(newBalance);
            }
        });
    }
}
