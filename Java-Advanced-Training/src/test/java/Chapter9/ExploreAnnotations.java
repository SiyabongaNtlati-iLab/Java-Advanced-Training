package Chapter9;

import org.junit.jupiter.api.*;

/**
 * @author : Siyabonga Ntlati
 * Project : Java-Advanced-Training
 * Date   : 2026/10/13
 * This class demonstrate use of different annotations from JUnit 5
 * <ol>
 *     <li>Sanity Test: Test for basic functionality after a fix, change or addition of a feature</li>
 *     <li>Regression Test: Test unchanged parts of the system</li>
 *     <li>Integration Test: Testing individual units when they are connected to internal or extenal components</li>
 * </ol>
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExploreAnnotations {

    @BeforeAll
    static void setup(){
        System.err.println("Setup");
    }

    @AfterAll
    static void tearDown(){
        System.err.println("Realising all resources");
    }

    @BeforeEach
    void beforeAnyTest(){
        System.out.println("Before a test case");
    }

    @AfterEach
    void afterEachTest(){
        System.out.println("After a test case");
    }
    @Test
    @DisplayName("TC1 - First Test")
    @Order(1)
    @Tag("Sanity")
    void firstTest(){
        System.out.println("---- First Test Method");
    }

    @Test
    @DisplayName("TC2 - Second Test")
    @Order(2)
    @Tag("Integration")
    @Tag("Regression")
    void secondTest(){
        System.out.println("---- Second Test Method");
    }
    @Test
    @DisplayName("TC3 - Third Test")
    @Order(3)
    @Tag("Sanity")
    void thirdTest(){
        System.out.println("---- Third Test Method");
    }

    @Test
    @DisplayName("TC4 - Test Sum")
    @Order(4)
    @Tag("Regression")
    void testSum(){
        //Arrange - define inputs and expected results
        int num1 = 6;
        int num2 = 3;
        int expectedSum = 9;
        System.out.println("Test Sum");
    }

}