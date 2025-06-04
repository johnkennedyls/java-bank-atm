import contract.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionStreamExample {
    public static void main(String[] args) {
        List<TransactionForStream> transactions = new ArrayList<>();
        transactions.add(new TransactionForStream("123", 100.00, Transaction.TransactionType.DEPOSIT));
        transactions.add(new TransactionForStream("123", 50.00, Transaction.TransactionType.WITHDRAWAL));
        transactions.add(new TransactionForStream("456", 75.00, Transaction.TransactionType.DEPOSIT));

        // Filtramos transacciones de tipo DEPOSIT
        List<Transaction> deposits = transactions.stream()
                .filter(t -> t.getType() == Transaction.TransactionType.DEPOSIT)
                .collect(Collectors.toList());

        deposits.forEach(t -> System.out.println("Cuenta: " + ((Transaction) t).getAccountNumber() + ", Monto: " + ((Transaction) t).getAmount()));

        //Encontrar transaccion con el mayor monto
        TransactionForStream maxTransaction = transactions.stream()
                .max((t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()))
                .orElse(null);

        System.out.println("The mayor transaction: " + maxTransaction.getAmount());

        //Calcular el valor total de los depósitos
        double totalDeposits = transactions.stream()
                .filter(t -> t.getType() == Transaction.TransactionType.DEPOSIT)
                .mapToDouble(TransactionForStream::getAmount)
                .sum();
        System.out.println("Total Deposits: " + totalDeposits);
    }
}