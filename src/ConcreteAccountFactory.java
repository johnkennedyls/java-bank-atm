public class ConcreteAccountFactory extends AccountFactory {
    @Override
    public Account createAccount(String accountType) {
        switch (accountType) {
            case "Savings":
                return new SavingsAccount("SA12345", 1000.0, "1234");
            case "Checking":
                return new CheckingAccount( "CA12345", 500.0, "5678");
            default:
                throw new IllegalArgumentException("Unknown account type");
        }
    }
}
