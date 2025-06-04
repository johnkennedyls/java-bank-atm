import contract.Authenticatable;

public class ATM implements Authenticatable {

    private String storedPin = "1234"; // Example stored PIN

    @Override
    public boolean authenticate(String pin) {
        if (pin != null && pin.equals(storedPin)) {
            return true; // Authentication successful
        } else {
            return false; // Authentication failed
        }
    }
}