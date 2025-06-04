import contract.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CompositeTransaction implements Transaction {
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public String getAccountNumber() {
        return transactions.isEmpty() ? "" : transactions.get(0).getAccountNumber();
    }

    @Override
    public double getAmount() {
        return transactions.stream().mapToDouble(Transaction::getAmount).sum();
    }

    @Override
    public void execute() {
        for (Transaction t : transactions) {
            t.execute();
        }
    }
}