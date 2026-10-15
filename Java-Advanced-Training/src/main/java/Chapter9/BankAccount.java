package Chapter9;

enum AccountType {
    DEBIT,
    SAVINGS,
    CREDIT,
    CHEQUE,
    LOAN
}

public class BankAccount {

    private String accountHolder;
    private String accountNumber;
    private AccountType accountType;
    private double balance;

    public BankAccount(String accountNumber,
                       String accountHolder,
                       AccountType accountType,
                       double balance) {

        this.accountHolder = accountHolder;
        this.accountType = accountType;
        setAccountNumber(accountNumber);
        this.balance = balance;
    }

    public String displayDetails() {
        return String.format("""
                Account Holder  : %s
                Account Number  : %s
                Account Type    : %s
                Account Balance : %.2f
                """,
                getAccountHolder(),
                getAccountNumber(),
                getAccountType(),
                getBalance());
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {

        String prefix = "";

        switch (accountType) {
            case DEBIT:
                prefix = "DB";
                break;

            case SAVINGS:
                prefix = "SV";
                break;

            case CREDIT:
                prefix = "CR";
                break;

            case CHEQUE:
                prefix = "CQ";
                break;

            case LOAN:
                prefix = "LN";
                break;
        }

        this.accountNumber = prefix + "-" + accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Deposit amount must be greater than zero.");
        }

        balance += amount;
    }

    public void withdraw(double amount)
            throws InsufficientFundsException {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount must be greater than zero.");
        }

        if (amount > balance) {
            throw new InsufficientFundsException(balance, amount);
        }

        balance -= amount;
    }
}