package Chapter9;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * @author : Siyabonga Ntlati
 * Project : Java-Advanced-Training
 * Date   : 2026/10/13
 **/
public class ExploreAssertions {

    static int num1, num2;
    @BeforeAll
    static void setup(){
        num1 = 5;
        num2 = 3;
    }
    @Test
    @DisplayName("Test Sum of Two Numbers")
    void testSumOfTwoNumbers(){
        //Arrange
        int expected = 8;
        //Act - Actual
        int actual = num1 + num2;
        //Assert
        assertEquals(expected, actual, "The sum of " + num1
                + " + " + num2 + " is " + expected);
    }

    @Test
    @DisplayName("Test Difference of Two Numbers")
    void testDiffOfTwoNumbers(){
        //Arrange
        int expected = 2;
        //Act
        int actual = num1 - num2;
        //Assert
        assertTrue(expected == actual, "The difference between " + num1 +
                " and " + num2 + " is " + expected);
    }
    //5, 3
    @Test
    @DisplayName("Compute sum, difference and product")
    void testComputationOfTwoNumbers(){
        //Arrange
        int expectedSum = 8;
        int expectedDiff = 2;
        int expectedProduct = 15;

        //actual
        int actualSum = num1 + num2 + 1;//Fail
        int actualDiff = num1 - num2;
        int actualProduct = num1 * num2 + 1;//Fail
        //assert

        assertAll(
                () -> assertEquals(expectedDiff, actualDiff),
                () -> assertEquals(expectedSum, actualSum),
                () -> assertEquals(expectedProduct, actualProduct)
        );
    }
}