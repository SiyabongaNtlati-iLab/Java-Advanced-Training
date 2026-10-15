package Chapter9;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    BankAccount objAcc;

    @BeforeEach
    void setupAccount() {
        objAcc = new BankAccount(
                "9625887",
                "Jessica Jones",
                AccountType.CHEQUE,
                15000
        );
    }

    @Test
    void testDeposit() {

        // Arrange
        double amountToDeposit = 600;
        double expectedBalance = 15600;

        // Act
        objAcc.deposit(amountToDeposit);
        double actualBalance = objAcc.getBalance();

        // Assert
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    void testInvalidDeposit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> objAcc.deposit(-500)
        );
    }

    @Test
    void testWithdraw() throws InsufficientFundsException {

        // Arrange
        double amountToWithdraw = 1500;
        double expectedBalance = 13500;
        try {
            // Act
            objAcc.withdraw(amountToWithdraw);
            double actualBalance = objAcc.getBalance();

            // Assert
            assertEquals(expectedBalance, actualBalance);
        }catch(InsufficientFundsException e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    void testInvalidWithdrawalNegativeAmount() {

        assertThrows(
                IllegalArgumentException.class,
                () -> objAcc.withdraw(-100)
        );
    }

    @Test
    void testWithdrawalInsufficientFunds() {

        double amountToWithdraw = objAcc.getBalance() + 1;

        assertThrows(
                InsufficientFundsException.class,
                () -> objAcc.withdraw(amountToWithdraw)
        );
    }

    @Test
    void testAccountNumberPrefixReceivesPrefix(){
        //Arrange
        String expectedAccountNumber = "CQ-9625887";
        //Act
        String actualAccountNumber = objAcc.getAccountNumber();
        //Assert
        assertEquals(expectedAccountNumber, actualAccountNumber);
    }

    @Test
    void testAllAccountNumberPrefixes(){
        //Arrange and Act
        BankAccount debitAccount = new BankAccount(
                "10001",
                "Debit Holder",
                AccountType.DEBIT,
                1000
        );
        BankAccount savingsAccount = new BankAccount(
                "10002",
                "Savings Holder",
                AccountType.SAVINGS,
                1000
        );

        BankAccount creditAccount = new BankAccount(
                "10003",
                "Credit Holder",
                AccountType.CREDIT,
                1000
        );

        BankAccount chequeAccount = new BankAccount(
                "10004",
                "Cheque Holder",
                AccountType.CHEQUE,
                1000
        );

        BankAccount loanAccount = new BankAccount(
                "10005",
                "Loan Holder",
                AccountType.LOAN,
                1000
        );

        //look at the main focus(testing the prefixes)
        //changing the account number does affect prefix
        //changing name doesn't affect it also
        //just use the same account number(its not that important)

        //Assert
        assertAll(
                () -> assertEquals(
                        "DB-10001",
                        debitAccount.getAccountNumber()
                ),
                () -> assertEquals(
                        "SV-10002",
                        savingsAccount.getAccountNumber()
                ),

                () -> assertEquals(
                        "CR-10003",
                        creditAccount.getAccountNumber()
                ),

                () -> assertEquals(
                        "CQ-10004",
                        chequeAccount.getAccountNumber()
                ),

                () -> assertEquals(
                        "LN-10005",
                        loanAccount.getAccountNumber()
                )
        );
    }

    @AfterEach
    void getAccountDetails() {
        System.out.println(objAcc.displayDetails());
    }
}