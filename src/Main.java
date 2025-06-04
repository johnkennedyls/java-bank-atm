import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double balance = 1000.0;
        ArrayList<String> transactionHistory = new ArrayList<>();

        deposit(500, balance, transactionHistory);
        withdraw(100, balance, transactionHistory);

        System.out.println("Balance final: " + balance);
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public static void deposit(double amount, double balance, ArrayList<String> transactionHistory) {
        balance += amount;
        transactionHistory.add("Deposited: $" + amount);
    }

    public static boolean withdraw(double amount, double balance, ArrayList<String> transactionHistory) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            return true;
        } else {
            System.out.println("Insufficient funds");
            return false;
        }
    }

    public void mainMenu() {

        System.out.println("Main Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");

        System.out.println("Please select an option from the menu.");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                deposit(depositAmount, 1000.0, new ArrayList<>());
                System.out.println("Deposit successful.");
                break;
            case 2:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                if (withdraw(withdrawAmount, 1000.0, new ArrayList<>())) {
                    System.out.println("Withdrawal successful.");
                }
                break;
            case 3:
                System.out.println("Current balance: $1000.0");
                break;
            case 4:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
