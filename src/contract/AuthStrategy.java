package contract;

public interface AuthStrategy {
    boolean authenticate(String data);
}