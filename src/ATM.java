import contract.Transaction;

public class ATM {
    private static final String LOG_FILE = "transactions.log";
    private TransactionLogger logger = new TransactionLogger(LOG_FILE);

    public void performTransaction(String accountNumber, Transaction.TransactionType type, double amount) {
        logger.logTransaction(accountNumber + " " + type + " " + amount);
    }
}
