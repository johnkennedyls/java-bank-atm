import contract.Transaction;
import contract.TransactionFilter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ATM {
    TransactionFilter highValueTransactions = t -> t.getAmount() > 1000;

    List<TransactionForStream> transactions = new ArrayList<>(); // Inicializar la lista de transacciones
    List<TransactionForStream> highValueList = transactions.stream()
            .filter(t -> highValueTransactions.filter(t))
            .collect(Collectors.toList());

    TransactionFilter deposits = t -> t.getType() == Transaction.TransactionType.DEPOSIT;
    TransactionFilter withdrawals = t -> t.getType() == Transaction.TransactionType.WITHDRAWAL;

    List<Transaction> depositList = transactions.stream()
            .filter(deposits::filter)
            .collect(Collectors.toList());

    List<Transaction> withdrawalList = transactions.stream()
            .filter(withdrawals::filter)
            .collect(Collectors.toList());

    public void updateBalancesAsync() {
        CompletableFuture.runAsync(() -> {
            // Lógica para actualizar saldos
            System.out.println("Updating balances asynchronously...");
        });
    }


    LocalDate today = LocalDate.now();
    LocalTime now = LocalTime.now();
    LocalDateTime dateTime = LocalDateTime.now();


}