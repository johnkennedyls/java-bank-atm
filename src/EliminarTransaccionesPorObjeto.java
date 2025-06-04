import java.util.ArrayList;
import java.util.List;

public class EliminarTransaccionesPorObjeto {
    public static void main(String[] args) {
        List<TransactionForStream> transacciones = new ArrayList<>();
        transacciones.add(new TransactionForStream("123", 100.00, TransactionForStream.TransactionType.DEPOSIT));
        transacciones.add(new TransactionForStream("456", 50.00, TransactionForStream.TransactionType.WITHDRAWAL));
        transacciones.add(new TransactionForStream("123", 75.00, TransactionForStream.TransactionType.DEPOSIT));

        System.out.println("Lista original: " + transacciones);

        // Eliminar todas las transacciones de la cuenta "123"
        transacciones.removeIf(transaccion -> transaccion.getAccountNumber().equals("123"));

        System.out.println("Lista después de eliminar transacciones de la cuenta 123: " + transacciones);
    }
}