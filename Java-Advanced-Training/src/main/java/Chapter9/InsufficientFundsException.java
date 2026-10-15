package Chapter9;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(double balance, double amount) {
        super("Insufficient funds. Available balance: R"
                + balance
                + ", Withdrawal amount: R"
                + amount);

    }

}
