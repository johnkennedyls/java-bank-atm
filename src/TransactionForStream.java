public class TransactionForStream implements contract.Transaction {
    private String accountNumber;
    private double amount;
    private TransactionType type;

    public TransactionForStream(String accountNumber, double amount, TransactionType type) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    @Override
    public void execute() {
        // Implement the transaction execution logic here
        System.out.println("Executing transaction for account: " + accountNumber + ", amount: " + amount + ", type: " + type);
    }
}