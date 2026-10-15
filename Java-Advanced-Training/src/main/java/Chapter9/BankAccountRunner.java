package Chapter9;

public class BankAccountRunner {

    public static void main(String[] args) {

        try {

            BankAccount objAcc = new BankAccount(
                    "9098908",
                    "Jessica Jones",
                    AccountType.CHEQUE,
                    15000
            );

            objAcc.deposit(500);
            objAcc.withdraw(700);

            System.out.println(objAcc.displayDetails());

        } catch (IllegalArgumentException |
                 InsufficientFundsException e) {

            System.err.println(e.getMessage());
        }
    }
}