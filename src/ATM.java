public class ATM implements Runnable {
    private String transactionType;
    private double amount;

    public ATM(String transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
    }

    @Override
    public void run() {
        if(transactionType.equals("deposit")) {
            System.out.println("Ejecutando depósito de: " + amount);
        } else if(transactionType.equals("withdrawal")) {
            System.out.println("Ejecutando retiro de: " + amount);
        }
    }

    public static void main(String[] args) {
        Thread user1 = new Thread(new ATM("deposit", 100.0));
        Thread user2 = new Thread(new ATM("withdrawal", 50.0));

        user1.start();
        user2.start();
    }
}
