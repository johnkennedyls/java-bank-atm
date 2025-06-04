import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionFileReader {
    public static void main(String[] args) {
        String filePath = "transactions.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<TransactionForStream> transactions = br.lines()
                    .map(line -> line.split(","))
                    .map(data -> new TransactionForStream(data[0], Double.parseDouble(data[1]), TransactionForStream.TransactionType.valueOf(data[2])))
                    .collect(Collectors.toList());

            transactions.forEach(t -> System.out.println("Cuenta: " + t.getAccountNumber() + ", Monto: " + t.getAmount() + ", Tipo: " + t.getType()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
