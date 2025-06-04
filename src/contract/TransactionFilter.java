package contract;

@FunctionalInterface
public interface TransactionFilter {
    boolean filter(Transaction transaction);
}
