public class PayPal {
    private String email;

    public PayPal(String email) {
        this.email = email;
    }

    public void sendPayment(double amount) {
        // Simulate sending payment through PayPal
        System.out.println("Sending payment of $" + amount + " via PayPal to " + email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
