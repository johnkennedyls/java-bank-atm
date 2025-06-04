package contract;

public interface Transaction {
    String getAccountNumber();

    double getAmount();

    enum TransactionType {
        DEPOSIT,
        WITHDRAWAL
    }
    void execute();
}