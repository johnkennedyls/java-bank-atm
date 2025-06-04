import java.util.HashMap;
import java.util.Map;

public class Bank {
    private static Map<String, Account> accounts = new HashMap<>();

    public static void addAccount(String accountNumber, Account account) {
        accounts.put(accountNumber, account);
    }

    public static boolean isValidAccount(String accountNumber) {
        return accounts.containsKey(accountNumber);
    }

    public static Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}