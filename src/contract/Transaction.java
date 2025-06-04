package contract;

public interface Transaction {
    enum TransactionType {
        DEPOSIT,
        WITHDRAWAL
    }
    void execute();
}