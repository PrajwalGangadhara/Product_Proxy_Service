import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("Testing 10+12=12")
    public void Test_addInteger_ReturnInteger() {
        //Arrange
        Calculator calculator = new Calculator();
        //Act
        int result = calculator.add(10, 12);
        //Assert
        assertEquals(22, result);
    }

    @Test
    public void Test_Dividebyzero_ThrowException()
    {
        Calculator calculator=new Calculator();
        assertThrows(ArithmeticException.class, ()->calculator.div(10,0));
    }

}