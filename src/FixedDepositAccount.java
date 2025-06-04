import exception.InsufficientFundsException;

public class FixedDepositAccount extends Account {
    private double interestRate;
    private int maturityPeriod; // in months
    private boolean isMatured;

    public FixedDepositAccount(String accountNumber, double initialBalance, double interestRate, int maturityPeriod) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
        this.maturityPeriod = maturityPeriod;
        this.isMatured = false;
    }

    public void applyInterest() {
        if (isMatured) {
            double interest = getBalance() * interestRate;
            deposit(interest);
        } else {
            throw new IllegalStateException("Account is not matured yet.");
        }
    }

    public void mature() {
        isMatured = true;
    }

    public boolean isMatured() {
        return isMatured;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getMaturityPeriod() {
        return maturityPeriod;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {

    }
}
