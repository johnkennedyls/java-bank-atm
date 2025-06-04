import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Transaction {
    private String accountNumber;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public String getFormattedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return this.timestamp.format(formatter);
    }

    // Método para simulación de Optional
    public Optional<String> getOptionalComment() {
        return Optional.ofNullable(null); // Simulando un campo que podría estar ausente
    }
}
   