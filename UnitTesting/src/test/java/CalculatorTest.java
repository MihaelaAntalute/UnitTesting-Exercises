import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    void testAddTwoNumbers_ShouldReturnCorrectSum() {
        //given
        Calculator calculator = new Calculator();
        //when
        int result = calculator.add(2, 3);
        //then
        assertEquals(5, result);
    }

    @Test
    void testDivideTwoNumbers_ShouldReturnCorrectDivision() {
        Calculator calculator = new Calculator();
        int result = calculator.divide(10, 5);
        assertEquals(2, result);
    }

    @Test
    void testDivideByZero_ShouldThrowException() {
        Calculator calculator = new Calculator();
        try {
            int result = calculator.divide(10, 0);
            fail("Exception not throw");
        } catch (IllegalArgumentException e) {
            assertEquals("You can't divide by 0", e.getMessage());
        }
    }



}

