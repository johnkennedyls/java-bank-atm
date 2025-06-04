import contract.Transaction;

public class SimpleTransaction implements Transaction {
    private String description;

    public SimpleTransaction(String description) {
        this.description = description;
    }

    @Override
    public String getAccountNumber() {
        return  "123456789"; // Placeholder account number
    }

    @Override
    public double getAmount() {
        return 0;
    }

    @Override
    public void execute() {
        System.out.println("Executing: " + description);
    }
}